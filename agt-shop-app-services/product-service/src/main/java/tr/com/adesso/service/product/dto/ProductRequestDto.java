package tr.com.adesso.service.product.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private String brand;
    private String model;
    private String countryOfOrigin;
    private String warranty;
    private int stock;
    private float price;
}
