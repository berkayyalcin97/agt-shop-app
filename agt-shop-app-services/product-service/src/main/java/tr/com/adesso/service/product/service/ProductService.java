package tr.com.adesso.service.product.service;

import org.springframework.stereotype.Service;
import tr.com.adesso.service.product.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    ArrayList<ProductDto> productDtos = new ArrayList<ProductDto>();
    ProductDto productDto = new ProductDto();
    public List<ProductDto> getAllProducts() {

        productDto.setId(1L);
        productDto.setBrand("Asus");
        productDto.setName("Wireless Keyboard");
        productDto.setPrice(1000);

        productDtos.add(productDto);
        return productDtos;
    }

    public ProductDto getProductById(Long id) {
        return null;
    }
    public ProductDto createProduct(ProductDto productDto) {

        return null;
    }

    public ProductDto updateProduct(Long id , ProductDto productDto) {
        return null;
    }
    public ProductDto deleteProduct(Long id) {
        return null;
    }

}
