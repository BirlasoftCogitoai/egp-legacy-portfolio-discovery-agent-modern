package com.egp.modern.controller;

            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.http.ResponseEntity;
            import org.springframework.web.bind.annotation.*;
            import com.egp.modern.service.CustomerService;
            import com.egp.modern.dto.CustomerDTO;

            @RestController
            @RequestMapping("/api/v1/customers")
            @CrossOrigin(origins = "*")
            public class CustomerController {
                @Autowired
                private CustomerService customerService;

                @GetMapping("/{id}")
                public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String id) {
                    CustomerDTO customer = customerService.getCustomer(id);
                    return ResponseEntity.ok(customer);
                }

                @PutMapping("/{id}")
                public ResponseEntity<CustomerDTO> updateCustomer(
                        @PathVariable String id,
                        @RequestBody CustomerDTO customerDTO) {
                    CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
                    return ResponseEntity.ok(updatedCustomer);
                }
            }