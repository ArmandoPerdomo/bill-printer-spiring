package com.billing.app.controllers;

import com.billing.app.dto.BillDTO;
import com.billing.app.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class main {
    @Autowired
    BillService billService;

    @RequestMapping(value = "/")
    List<BillDTO> allBills(
            @RequestParam(value = "DOC_FILTER_TYPE", required = false) String DOC_FILTER_TYPE
    ) {
        return billService.all(DOC_FILTER_TYPE);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.PUT,
            params = {"DOC_NUMBER", "DOC_TYPE", "FISCAL_NUMBER", "DOC_EMPRESA"})
    Map<String, Object> execProc(
            @RequestParam("DOC_NUMBER") String DOC_NUMBER,
            @RequestParam("DOC_TYPE") String DOC_TYPE,
            @RequestParam("FISCAL_NUMBER") String FISCAL_NUMBER,
            @RequestParam("DOC_EMPRESA") String DOC_EMPRESA
    ){
        return billService.execProcedure(DOC_NUMBER, DOC_TYPE, FISCAL_NUMBER, DOC_EMPRESA);
    }

}
