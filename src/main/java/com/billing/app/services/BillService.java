package com.billing.app.services;

import com.billing.app.dto.BillDTO;

import java.util.List;
import java.util.Map;

public interface BillService {
    Map<String, Object> execProcedure(String DOC_NUMBER, String DOC_TYPE, String FISCAL_NUMBER, String DOC_EMPRESA);
    List<BillDTO> all(String DOC_FILTER_TYPE);
}
