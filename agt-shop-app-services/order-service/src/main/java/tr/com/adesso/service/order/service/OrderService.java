package tr.com.adesso.service.order.service;

import org.springframework.stereotype.Service;
import tr.com.adesso.service.order.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<OrderDto> orderDtos = new ArrayList<OrderDto>();
    OrderDto orderDto = new OrderDto();
    public List<OrderDto> getAllOrders(){

        orderDto.setId(1L);
        orderDto.setCustomerId(2L);

        orderDtos.add(orderDto);
        return orderDtos;
    }

    public OrderDto getOrderById(Long id) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(5L);
        orderDto.setOrderPrice(9999.7f);
        return orderDto;
    }

    public OrderDto createOrder(OrderDto order) {

        return null;
    }

    public OrderDto updateOrder(Long id , OrderDto orderDto) {
        return null;
    }
    public OrderDto deleteOrder(Long id) {
        return null;
    }

}
