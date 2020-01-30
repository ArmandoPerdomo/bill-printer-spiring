package com.billing.app.dto;

import com.billing.app.dao.Bill;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BillDetailDTO {
	@JsonProperty("MOV_TIPDOC")
    public String movTipdoc;
	@JsonProperty("MOV_CODIGO")
    public String movCodigo;
	@JsonProperty("INV_DESCRI")
    public String invDescri;
	@JsonProperty("MOV_CANTID")
    public String movCantid;
	@JsonProperty("MOV_UNDMED")
    public String movUnmed;
	@JsonProperty("MOV_PRECIO")
    public String movPrecio;
	@JsonProperty("MOV_DESCUE")
    public String movDescue;
	@JsonProperty("MOV_TOTAL")
    public String movTotal;
	@JsonProperty("MOV_ITEM")
    public String movItem;
	@JsonProperty("MOV_ITBMS")
    public String movItbms;
	@JsonProperty("MOV_OBS")
    public String movObs;

    public BillDetailDTO(Bill bill){
        this.setMovTipdoc(bill.MOV_TIPDOC);
        this.setMovCodigo(bill.MOV_CODIGO);
        this.setInvDescri(bill.INV_DESCRI);
        this.setMovCantid(bill.MOV_CANTID);
        this.setMovUnmed(bill.MOV_UNDMED);
        this.setMovPrecio(bill.MOV_PRECIO);
        this.setMovDescue(bill.MOV_DESCUE);
        this.setMovTotal(bill.MOV_TOTAL);
        this.setMovItem(bill.MOV_ITEM);
        this.setMovItbms(bill.MOV_ITBMS);
        this.setMovObs(bill.MOV_OBS);
    }
}
