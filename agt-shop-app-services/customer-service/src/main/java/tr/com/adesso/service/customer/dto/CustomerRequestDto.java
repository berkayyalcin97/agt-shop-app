package tr.com.adesso.service.customer.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String email;
    private String tel;
}
