package com.billing.app.services;

import com.billing.app.dto.BillDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BillService {
    Map<String, Object> execProcedure(String DOC_NUMBER, String DOC_TYPE, String FISCAL_NUMBER);
    List<BillDTO> all();
}
