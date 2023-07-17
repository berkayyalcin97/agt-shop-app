package tr.com.adesso.service.customer.model;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String Email;
    private String tel;
}
