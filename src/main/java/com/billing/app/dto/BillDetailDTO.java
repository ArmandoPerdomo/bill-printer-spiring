package com.billing.app.dto;

import com.billing.app.dao.Bill;
import lombok.Data;

@Data
public class BillDetailDTO {
    public String MOV_TIPDOC;
    public String MOV_CODIGO;
    public String INV_DESCRI;
    public String MOV_CANTID;
    public String MOV_UNDMED;
    public String MOV_PRECIO;
    public String MOV_DESCUE;
    public String MOV_TOTAL;
    public String MOV_ITEM;
    public String MOV_ITBMS;
    public String MOV_OBS;

    public BillDetailDTO(Bill bill){
        this.setMOV_TIPDOC(bill.MOV_TIPDOC);
        this.setMOV_CODIGO(bill.MOV_CODIGO);
        this.setINV_DESCRI(bill.INV_DESCRI);
        this.setMOV_CANTID(bill.MOV_CANTID);
        this.setMOV_UNDMED(bill.MOV_UNDMED);
        this.setMOV_PRECIO(bill.MOV_PRECIO);
        this.setMOV_DESCUE(bill.MOV_DESCUE);
        this.setMOV_TOTAL(bill.MOV_TOTAL);
        this.setMOV_ITEM(bill.MOV_ITEM);
        this.setMOV_ITBMS(bill.MOV_ITBMS);
        this.setMOV_OBS(bill.MOV_OBS);
    }
}
