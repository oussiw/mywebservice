package com.os.mywebservice.dao;

import com.os.mywebservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
