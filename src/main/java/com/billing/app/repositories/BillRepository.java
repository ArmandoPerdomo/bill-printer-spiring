package com.billing.app.repositories;

import com.billing.app.dao.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, String> {
}
