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

    @RequestMapping("/")
    List<BillDTO> allBills() {
        return billService.all();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, params = {"DOC_NUMBER", "DOC_TYPE", "FISCAL_NUMBER"})
    Map<String, Object> execProc(
            @RequestParam("DOC_NUMBER") String DOC_NUMBER,
            @RequestParam("DOC_TYPE") String DOC_TYPE,
            @RequestParam("FISCAL_NUMBER") String FISCAL_NUMBER
    ){
        return billService.execProcedure(DOC_NUMBER, DOC_TYPE, FISCAL_NUMBER);
    }

}
