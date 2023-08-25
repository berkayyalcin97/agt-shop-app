package tr.com.adesso.service.customer.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.adesso.service.customer.dto.CustomerRequestDto;
import tr.com.adesso.service.customer.dto.CustomerResponseDto;
import tr.com.adesso.service.customer.model.Customer;
import tr.com.adesso.service.customer.repository.CustomerRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;


@Service

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream().map(this::mapCustomerToCustomerResponse).toList();
    }

    public CustomerResponseDto getCustomerById(UUID id) {

        return customerRepository.findById(id).map(this::mapCustomerToCustomerResponse)
                .orElseThrow(null);

        //TODO : Exception Handling in Throw Customer Not Found
    }

    public void createCustomer(CustomerRequestDto customerRequestDto) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        String creationDate = LocalDateTime.now().format(dateTimeFormatter);

        Customer customer = Customer.builder()
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .birthDate(customerRequestDto.getBirthDate())
                .creationDate(creationDate)
                .address(customerRequestDto.getAddress())
                .email(customerRequestDto.getEmail())
                .tel(customerRequestDto.getTel())
                .build();

        customerRepository.save(customer);
    }

    public void updateCustomer(UUID id, CustomerRequestDto customerRequestDto) {

        Customer existingCustomer = customerRepository.getById(id);

        existingCustomer.setFirstName(customerRequestDto.getFirstName());
        existingCustomer.setLastName(customerRequestDto.getLastName());
        existingCustomer.setBirthDate(customerRequestDto.getBirthDate());
        existingCustomer.setAddress(customerRequestDto.getAddress());
        existingCustomer.setEmail(customerRequestDto.getEmail());
        existingCustomer.setTel(customerRequestDto.getTel());

        customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    public CustomerResponseDto mapCustomerToCustomerResponse(Customer customer){

        return CustomerResponseDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .birthDate(customer.getBirthDate())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .tel(customer.getTel())
                .build();
    }
}
