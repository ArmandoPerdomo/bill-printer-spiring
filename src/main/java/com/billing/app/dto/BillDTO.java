package com.billing.app.dto;

import com.billing.app.dao.Bill;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BillDTO {
	@JsonProperty("DOC_NUMERO")
    public String docNumero;
	@JsonProperty("DOC_CODIGO")
    public String docCodigo;
	@JsonProperty("CLI_NOMBRE")
    public String cliNombre;
	@JsonProperty("CLI_NOMBRE2")
    public String cliNombre2;
	@JsonProperty("CLI_RUC")
    public String cliRuc;
	@JsonProperty("DOC_FECHA")
    public String docFecha;
	@JsonProperty("DOC_TIPDOC")
    public String docTipdoc;
	@JsonProperty("DOC_NETO")
    public String docNeto;
	@JsonProperty("DOC_DCTO")
    public String docDcto;
	@JsonProperty("DOC_CONDIC")
    public String docCondic;
	@JsonProperty("DOC_ACT")
    public String docAct;
	@JsonProperty("DOC_BASNET")
    public String docBasnet;
	@JsonProperty("DOC_MTOITBMS")
    public String docMtoitbms;
	@JsonProperty("DOC_NUM_FISCAL")
    public String docNumFiscal;
	@JsonProperty("DOC_FACAFE2")
    public String docFacafe2;
	@JsonProperty("DOC_DIR1")
    public String docDir1;
	@JsonProperty("DOC_DIR2")
    public String docDir2;
	@JsonProperty("DOC_DIR3")
    public String docDir3;
	@JsonProperty("DOC_OBS")
    public String docObs;
	@JsonProperty("LINEAS")
    public List<BillDetailDTO> lineas;

    public BillDTO(){
        this.setLineas(new ArrayList<BillDetailDTO>());
    }

    public BillDTO(Bill bill){
        this.setLineas(new ArrayList<BillDetailDTO>());
        this.setDocNumero(bill.DOC_NUMERO);
        this.setDocCodigo(bill.DOC_CODIGO);
        this.setCliNombre(bill.CLI_NOMBRE);
        this.setCliNombre2(bill.CLI_NOMBRE2);
        this.setCliRuc(bill.CLI_RUC);
        this.setDocFecha(bill.DOC_FECHA);
        this.setDocTipdoc(bill.DOC_TIPDOC);
        this.setDocNeto(bill.DOC_NETO);
        this.setDocDcto(bill.DOC_DCTO);
        this.setDocCondic(bill.DOC_CONDIC);
        this.setDocAct(bill.DOC_ACT);
        this.setDocBasnet(bill.DOC_BASNET);
        this.setDocMtoitbms(bill.DOC_MTOITBMS);
        this.setDocNumFiscal(bill.DOC_NUM_FISCAL);
        this.setDocFacafe2(bill.DOC_FACAFE2);
        this.setDocDir1(bill.DOC_DIR1);
        this.setDocDir2(bill.DOC_DIR2);
        this.setDocDir3(bill.DOC_DIR3);
        this.setDocObs(bill.DOC_OBS);
    }
}
