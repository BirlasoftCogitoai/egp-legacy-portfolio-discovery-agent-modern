package com.egp.modern.service;

            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.stereotype.Service;
            import com.egp.modern.repository.CustomerRepository;
            import com.egp.modern.dto.CustomerDTO;

            @Service
            public class CustomerService {
                @Autowired
                private CustomerRepository customerRepository;

                public CustomerDTO getCustomer(String customerId) {
                    return customerRepository.findById(customerId)
                        .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
                }

                public CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO) {
                    return customerRepository.findById(customerId)
                        .map(customer -> {
                            customer.setName(customerDTO.getName());
                            customer.setEmail(customerDTO.getEmail());
                            customer.setPhone(customerDTO.getPhone());
                            return customerRepository.save(customer);
                        })
                        .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
                }
            }