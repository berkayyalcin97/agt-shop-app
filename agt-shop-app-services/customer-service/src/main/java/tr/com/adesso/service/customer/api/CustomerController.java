package tr.com.adesso.service.customer.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.adesso.service.customer.model.CustomerDto;
import tr.com.adesso.service.customer.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id,@RequestBody CustomerDto customerDto){

         return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PostMapping("customer")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateCustomer(id,customerDto));
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id")Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}
