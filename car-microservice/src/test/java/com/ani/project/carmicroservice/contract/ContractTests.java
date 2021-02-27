package com.ani.project.carmicroservice.contract;

import com.ani.project.carmicroservice.billing.domain.Contract;
import com.ani.project.carmicroservice.billing.domain.Supplier;
import com.ani.project.carmicroservice.billing.repository.ContractRepository;
import com.ani.project.carmicroservice.billing.repository.SupplierRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContractTests {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveSupplier() {
        Supplier sp = new Supplier();
        sp.setId(1L);
        sp.setName("Android");

        Supplier saved = supplierRepository.save(sp);
        assertNotNull(saved);

        Contract c1 = new Contract();
        c1.setStatus("closed");
        c1.setName("Contract 1");
        c1.setId(1L);
        c1.setSupplier(sp);
        assertNotNull(contractRepository.save(c1));

        Contract c2 = new Contract();
        c2.setStatus("active");
        c2.setName("Contract 2");
        c2.setId(2L);
        c2.setSupplier(sp);
        assertNotNull(contractRepository.save(c2));

        Contract c3 = new Contract();
        c3.setStatus("active");
        c3.setName("Contract 2");
        c3.setId(2L);
        c3.setSupplier(sp);
        assertNotNull(contractRepository.save(c3));
    }

    @Test
    @Order(2)
    public void fetchAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        assertThat(suppliers.size(), Matchers.greaterThan(0));
    }

    @Test
    @Order(3)
    public void fetchAllContractsForSupplier() {
        List<Supplier> suppliers = supplierRepository.findAll();
        assertThat( suppliers.get(0).getContracts().size(), Matchers.greaterThan(0));
    }

    @Test
    @Order(4)
    public void fetchAllActiveSupplierContracts() {
        List<Contract> contracts = contractRepository.findAll();
        List<Contract> activeContracts = contracts.stream().filter( ct -> ct.getStatus().endsWith("active")).collect(Collectors.toList());
        assertThat( activeContracts.size(), Matchers.greaterThan(0));
    }

    @Test
    @Order(5)
    public void checkSupplierIsAvailable() {
        List<Contract> contracts = contractRepository.findAll();
        List<Contract> activeContracts = contracts.stream().filter( ct -> ct.getStatus().endsWith("active")).collect(Collectors.toList());
        assertEquals("Android", activeContracts.get(0).getSupplier().getName());
    }

    @Test
    @Order(6)
    public void fetchAllSuppliersWithActiveContract() {
        List<Contract> contracts = contractRepository.findAll();
        List<Contract> activeContracts = contracts.stream().filter( ct -> ct.getStatus().endsWith("active")).collect(Collectors.toList());

        Set<Supplier> suppliers = new HashSet<>();
        activeContracts.forEach( ct -> suppliers.add(ct.getSupplier()) );
        assertThat( suppliers.size(), Matchers.greaterThan(0));
    }
}
