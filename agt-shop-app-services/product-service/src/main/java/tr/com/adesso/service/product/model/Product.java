package tr.com.adesso.service.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "brand"})
})
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "brand")
    private String brand;

    @NotNull
    @NotBlank
    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name="warranty")
    private String warranty;

    @NotNull
    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private float price;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
