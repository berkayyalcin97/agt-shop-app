package tr.com.adesso.service.product.api;

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
import tr.com.adesso.service.product.dto.ProductDto;
import tr.com.adesso.service.product.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name="v1 - Product APIs",description = "Maintain Product APIs")
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Get all Products",
            description = "Returns all Products"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK.",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))),
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
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(
            summary = "Get Product by Id",
            description = "Returns Product by given Id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK.",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))),
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
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id, @RequestBody ProductDto productDto){

        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(
            summary = "Create Product",
            description = "Creates Product by given Payload"
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
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Update Product",
            description = "Updates Product by given Id and Payload"
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
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Delete Product",
            description = "Deletes Product by Id"
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
    public ResponseEntity<Void> deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
