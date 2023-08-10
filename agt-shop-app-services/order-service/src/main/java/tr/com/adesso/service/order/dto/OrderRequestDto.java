package tr.com.adesso.service.order.dto;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private String creationDate;
    private float orderPrice;
}
