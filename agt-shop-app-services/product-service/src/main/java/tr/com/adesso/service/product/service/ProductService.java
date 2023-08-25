package tr.com.adesso.service.product.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.adesso.service.product.dto.ProductRequestDto;
import tr.com.adesso.service.product.dto.ProductResponseDto;
import tr.com.adesso.service.product.model.Product;
import tr.com.adesso.service.product.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@Builder
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream().map(product -> ProductResponseDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .brand(product.getBrand())
                        .stock(product.getStock())
                        .price(product.getPrice())
                        .build()
                ).toList();
    }

    public ProductResponseDto getProductById(UUID id) {

        return productRepository.findById(id).map(product -> ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .stock(product.getStock())
                .price(product.getPrice())
                .build()
        ).orElseThrow(null);
        //TODO : Exception Handling in Throw
    }

    public void createProduct(ProductRequestDto productRequestDto) {
        Product product = Product.builder()
                .name(productRequestDto.getName())
                .brand(productRequestDto.getBrand())
                .countryOfOrigin(productRequestDto.getCountryOfOrigin())
                .warranty(productRequestDto.getWarranty())
                .stock(productRequestDto.getStock())
                .price(productRequestDto.getPrice()).build();

        productRepository.save(product);
    }

    public void updateProduct(UUID id, ProductRequestDto productRequestDto) {

        Product existingProduct = productRepository.getById(id);

        existingProduct.setName(productRequestDto.getName());
        existingProduct.setBrand(productRequestDto.getBrand());
        existingProduct.setCountryOfOrigin(productRequestDto.getCountryOfOrigin());
        existingProduct.setWarranty(productRequestDto.getWarranty());
        existingProduct.setStock(productRequestDto.getStock());
        existingProduct.setPrice(productRequestDto.getPrice());

        productRepository.save(existingProduct);

    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);

    }

}
