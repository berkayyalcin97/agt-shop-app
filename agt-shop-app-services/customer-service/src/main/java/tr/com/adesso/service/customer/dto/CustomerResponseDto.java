package tr.com.adesso.service.customer.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String email;
    private String tel;
}
