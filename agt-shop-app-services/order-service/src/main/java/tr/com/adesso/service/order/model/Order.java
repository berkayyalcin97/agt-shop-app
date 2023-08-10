package tr.com.adesso.service.order.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import tr.com.adesso.service.customer.model.Customer;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String creationDate;
    private float orderPrice;


    //TODO : Customer Info who gave the order etc
    //TODO : Customer Address Info where order is going to ship
    //TODO : Product Info which products contains this order
}
