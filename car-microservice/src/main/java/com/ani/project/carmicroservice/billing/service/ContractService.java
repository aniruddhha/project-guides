package com.ani.project.carmicroservice.billing.service;

import com.ani.project.carmicroservice.billing.domain.Contract;
import com.ani.project.carmicroservice.billing.domain.Supplier;
import com.ani.project.carmicroservice.billing.repository.ContractRepository;
import com.ani.project.carmicroservice.billing.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContractService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ContractRepository contractRepository;

    public void saveTempData() {
        Supplier sp = new Supplier();
        sp.setId(1L);
        sp.setName("Android");

        Contract c1 = new Contract();
        c1.setStatus("closed");
        c1.setName("Contract 1");
        c1.setId(1L);
        c1.setSupplier(sp);
        sp.getContracts().add(c1);
       contractRepository.save(c1);

        Contract c2 = new Contract();
        c2.setStatus("active");
        c2.setName("Contract 2");
        c2.setId(2L);
        c2.setSupplier(sp);
       contractRepository.save(c2);

        Contract c3 = new Contract();
        c3.setStatus("active");
        c3.setName("Contract 2");
        c3.setId(3L);
        c3.setSupplier(sp);
        contractRepository.save(c3);

        Supplier saved = supplierRepository.save(sp);
    }

    public Set<Supplier> fetchAllSuppliersWithActiveContract() {
        List<Contract> contracts = contractRepository.findAll();
        List<Contract> activeContracts = contracts.stream().filter( ct -> ct.getStatus().endsWith("active")).collect(Collectors.toList());

        Set<Supplier> suppliers = new HashSet<>();
        activeContracts.forEach( ct -> suppliers.add(ct.getSupplier()) );
        return suppliers;
    }
}
