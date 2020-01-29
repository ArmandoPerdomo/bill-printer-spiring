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

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    void init() {
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("update_invoice_fiscal_number");
    }

    @Override
    public Map<String, Object> execProcedure(String DOC_NUMBER, String DOC_TYPE, String FISCAL_NUMBER) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("DOC_NUMBER", DOC_NUMBER)
                .addValue("DOC_TYPE", DOC_TYPE)
                .addValue("FISCAL_NUMBER", FISCAL_NUMBER);
        Map<String, Object> out = null;
        try {
            out = simpleJdbcCall.execute(in);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return out;
    }

    @Override
    public List<BillDTO> all() {
        Iterable<Bill> bills = billRepository.findAll();
        List<BillDTO> outBills = new ArrayList<BillDTO>();

        bills.forEach(
                bill -> {
                    BillDetailDTO actualDetail = new BillDetailDTO(bill);
                    Stream<BillDTO> billDTOStream = outBills.stream();
                    // Si existe la factura entonces agrega el detalle
                    if(billDTOStream.anyMatch(b -> b.DOC_NUM_FISCAL.equals(bill.DOC_NUM_FISCAL))){
                        outBills.forEach(
                                outBill -> {
                                    if(outBill.DOC_NUM_FISCAL.equals(bill.DOC_NUM_FISCAL)){
                                        outBill.getLINEAS().add(actualDetail);
                                    }
                                }
                        );
                    }else{
                        // Si no existe la factura la agrega y con el detalle actual
                        BillDTO actualBill = new BillDTO(bill);
                        actualBill.getLINEAS().add(actualDetail);
                        outBills.add(actualBill);
                    }
                }
        );

        return outBills;
    }
}
