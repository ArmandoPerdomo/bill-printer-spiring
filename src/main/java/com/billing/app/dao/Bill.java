package com.billing.app.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "get_invoice_fiscal_printer_ibs")
@Table(name = "get_invoice_fiscal_printer_ibs", schema = "CRPDTA")
@Data
public class Bill {
	@Id
	public String ROW_NUM;
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
    // Detalles
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
}
