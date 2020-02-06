package com.billing.app.repositories;

import com.billing.app.dao.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, String> {
    @Query(value = "SELECT b from Bill b WHERE b.DOC_FILTER_TYPE = ?1", nativeQuery = true)
    List<Bill> all(String type);
}
