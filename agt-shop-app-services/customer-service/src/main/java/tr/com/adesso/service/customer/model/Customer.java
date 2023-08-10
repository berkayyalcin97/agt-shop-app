package tr.com.adesso.service.customer.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(
            nullable = false,
            columnDefinition = "Text"
    )
    private String firstName;
    private String lastName;
    private String birthDate;
    private String creationDate;
    private String address;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            nullable = false,
            unique = true
    )
    private String tel;
}
