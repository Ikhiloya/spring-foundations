package com.lynda.common.web;

import com.lynda.common.data.entity.ActivityLog;
import com.lynda.common.data.entity.Customer;
import com.lynda.common.service.ActivityLogService;
import com.lynda.common.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class CustomerWebService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping
    public List<Customer> getAll() {
        return this.customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable("id") String id) {
        return this.customerService.findOne(id);
    }

    @GetMapping("all")
    public List<ActivityLog> getAllActivityLogs() {
        return this.activityLogService.getAll();
    }

}
