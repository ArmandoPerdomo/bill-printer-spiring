package com.billing.app.services;

import com.billing.app.dao.Bill;
import com.billing.app.dto.BillDTO;
import com.billing.app.dto.BillDetailDTO;
import com.billing.app.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    void init() {
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("update_invoice_fiscal_number");
    }

    @Override
    public Map<String, Object> execProcedure(String DOC_NUMBER, String DOC_TYPE, String FISCAL_NUMBER, String DOC_COMPANY) {
    	SqlParameterSource in = new MapSqlParameterSource()
                .addValue("DOC_NUMBER", DOC_NUMBER)
                .addValue("DOC_TYPE", DOC_TYPE)
                .addValue("FISCAL_NUMBER", FISCAL_NUMBER)
                .addValue("DOC_COMPANY", DOC_COMPANY);

        Map<String, Object> out = null;
        try {
           out = simpleJdbcCall.execute(in);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return out;
    }

    @Override
    public List<BillDTO> all(String DOC_FILTER_TYPE) {
        Iterable<Bill> bills;

        if(DOC_FILTER_TYPE != null && DOC_FILTER_TYPE.isEmpty()){
            bills = billRepository.all(DOC_FILTER_TYPE);
        }else{
            bills = billRepository.findAll();
        }

        List<BillDTO> outBills = new ArrayList<BillDTO>();

        bills.forEach(
                bill -> {
                    BillDetailDTO actualDetail = new BillDetailDTO(bill);
                    Stream<BillDTO> billDTOStream = outBills.stream();
                    // Si existe la factura entonces agrega el detalle
                    if(billDTOStream.anyMatch(b -> b.docNumero.equals(bill.DOC_NUMERO))){
                        outBills.forEach(
                                outBill -> {
                                    if(outBill.docNumero.equals(bill.DOC_NUMERO)){
                                        outBill.getLineas().add(actualDetail);
                                    }
                                }
                        );
                    }else{
                        // Si no existe la factura la agrega y con el detalle actual
                        BillDTO actualBill = new BillDTO(bill);
                        actualBill.getLineas().add(actualDetail);
                        outBills.add(actualBill);
                    }
                }
        );

        return outBills;
    }
}
