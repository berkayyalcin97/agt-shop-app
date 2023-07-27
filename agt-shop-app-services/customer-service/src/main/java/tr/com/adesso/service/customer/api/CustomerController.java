package tr.com.adesso.service.customer.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.adesso.service.customer.dto.CustomerDto;
import tr.com.adesso.service.customer.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name="v1 - Customer APIs",description = "Maintain Customer APIs")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(
            summary = "Get all Customers",
            description = "Returns all Customers"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK.",
                            content = @Content(schema = @Schema(implementation = CustomerDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @LoadBalanced
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @Operation(
            summary = "Get Customer by Id",
            description = "Returns Customer by given Id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK.",
                            content = @Content(schema = @Schema(implementation = CustomerDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @Operation(
            summary = "Create Customer",
            description = "Creates Customer by given Payload"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Update Customer",
            description = "Updates Customer by given Id and Payload"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Delete Customer",
            description = "Deletes Customer by Id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}
