package com.ani.project.carmicroservice.billing.controller;

import com.ani.project.carmicroservice.billing.domain.Bill;
import com.ani.project.carmicroservice.billing.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingController {

    @Autowired
    private BillRepository repository;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Bill generateBill(@RequestBody Bill bill) {
        return repository.save(bill);
    }
}
