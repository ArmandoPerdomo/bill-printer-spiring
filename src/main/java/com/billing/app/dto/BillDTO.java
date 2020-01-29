package com.billing.app.dto;

import com.billing.app.dao.Bill;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BillDTO {
    public String DOC_NUMERO;
    public String DOC_CODIGO;
    public String CLI_NOMBRE;
    public String CLI_NOMBRE2;
    public String CLI_RUC;
    public String DOC_FECHA;
    public String DOC_TIPDOC;
    public String DOC_NETO;
    public String DOC_DCTO;
    public String DOC_CONDIC;
    public String DOC_ACT;
    public String DOC_BASNET;
    public String DOC_MTOITBMS;
    public String DOC_NUM_FISCAL;
    public String DOC_FACAFE2;
    public String DOC_DIR1;
    public String DOC_DIR2;
    public String DOC_DIR3;
    public String DOC_OBS;
    public List<BillDetailDTO> LINEAS;

    public BillDTO(){
        this.setLINEAS(new ArrayList<BillDetailDTO>());
    }

    public BillDTO(Bill bill){
        this.setLINEAS(new ArrayList<BillDetailDTO>());
        this.setDOC_NUMERO(bill.DOC_NUMERO);
        this.setDOC_CODIGO(bill.DOC_CODIGO);
        this.setCLI_NOMBRE(bill.CLI_NOMBRE);
        this.setCLI_NOMBRE2(bill.CLI_NOMBRE2);
        this.setCLI_RUC(bill.CLI_RUC);
        this.setDOC_FECHA(bill.DOC_FECHA);
        this.setDOC_TIPDOC(bill.DOC_TIPDOC);
        this.setDOC_NETO(bill.DOC_NETO);
        this.setDOC_DCTO(bill.DOC_DCTO);
        this.setDOC_CONDIC(bill.DOC_CONDIC);
        this.setDOC_ACT(bill.DOC_ACT);
        this.setDOC_BASNET(bill.DOC_BASNET);
        this.setDOC_MTOITBMS(bill.DOC_MTOITBMS);
        this.setDOC_NUM_FISCAL(bill.DOC_NUM_FISCAL);
        this.setDOC_FACAFE2(bill.DOC_FACAFE2);
        this.setDOC_DIR1(bill.DOC_DIR1);
        this.setDOC_DIR2(bill.DOC_DIR2);
        this.setDOC_DIR3(bill.DOC_DIR3);
        this.setDOC_OBS(bill.DOC_OBS);
    }
}
