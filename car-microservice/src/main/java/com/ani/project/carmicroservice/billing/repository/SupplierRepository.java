package com.ani.project.carmicroservice.billing.repository;

import com.ani.project.carmicroservice.billing.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
