package tr.com.adesso.service.product.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "products")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(
            nullable = false,
            unique = true
    )
    private String name;
    @Column(
            nullable = false,
            unique = true
    )
    private String brand;
    @Column(
            nullable = false,
            unique = true
    )
    private String model;
    private String countryOfOrigin;
    private String warranty;
    @Column(
            nullable = false
    )
    private int stock;
    @Column(
            nullable = false
    )
    private float price;
}
