package com.ani.project.carmicroservice.billing.repository;

import com.ani.project.carmicroservice.billing.domain.Contract;
import com.ani.project.carmicroservice.billing.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
