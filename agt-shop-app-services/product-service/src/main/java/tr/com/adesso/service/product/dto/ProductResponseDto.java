package tr.com.adesso.service.product.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponseDto {

    private UUID id;
    private String name;
    private String brand;
    private String model;
    private int stock;
    private float price;
}
