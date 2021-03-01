package com.ani.project.carmicroservice.billing.repository;

import com.ani.project.carmicroservice.billing.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query("select ct from Contract ct where ct.supplier.id = ?1")
    List<Contract> findAllContracts(Long supplierId);
}
