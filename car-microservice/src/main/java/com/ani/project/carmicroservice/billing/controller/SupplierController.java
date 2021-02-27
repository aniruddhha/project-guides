package com.ani.project.carmicroservice.billing.controller;

import com.ani.project.carmicroservice.billing.domain.Contract;
import com.ani.project.carmicroservice.billing.domain.Supplier;
import com.ani.project.carmicroservice.billing.repository.ContractRepository;
import com.ani.project.carmicroservice.billing.repository.SupplierRepository;
import com.ani.project.carmicroservice.billing.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ContractService contractService;

    @PostMapping("/")
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @PostMapping("/contract")
    public Contract saveContract(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }

    @GetMapping("/activecontract")
    public Set<Supplier> fetchAllSuppliersWithActiveContract() {
        return contractService.fetchAllSuppliersWithActiveContract();
    }
}
