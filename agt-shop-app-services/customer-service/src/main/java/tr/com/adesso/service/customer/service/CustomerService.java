package tr.com.adesso.service.customer.service;

import org.springframework.stereotype.Service;
import tr.com.adesso.service.customer.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    ArrayList<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
    CustomerDto customerDto = new CustomerDto();
    public List<CustomerDto> getAllCustomers() {
        customerDto.setId(1L);
        customerDto.setFirstName("Berkay");
        customerDto.setLastName("Yalcin");
        customerDto.setTel("12312312");

        customerDtos.add(customerDto);
        return customerDtos;
    }

    public CustomerDto getCustomerById(Long id) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(2L);
        customerDto.setFirstName("Test");
        return customerDto;
    }
    public CustomerDto createCustomer(CustomerDto customerDto) {

        return null;
    }
    //TO-DO
    //updateCustomer variablelarnı kontrol et
    public CustomerDto updateCustomer(Long id ,CustomerDto customerDto) {
        return null;
    }
    public CustomerDto deleteCustomer(Long id) {
        return null;
    }



}
