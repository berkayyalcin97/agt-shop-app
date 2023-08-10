package tr.com.adesso.service.order.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import tr.com.adesso.service.order.dto.OrderRequestDto;
import tr.com.adesso.service.order.model.Order;
import tr.com.adesso.service.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderRequestDto> getAllOrders(){


        return null;
    }

    public OrderRequestDto getOrderById(Long id) {

        return null;
    }

    public OrderRequestDto createOrder(OrderRequestDto orderRequestDto) {

       return null;
    }

    public OrderRequestDto updateOrder(Long id , OrderRequestDto orderRequestDto) {
        return null;
    }
    public OrderRequestDto deleteOrder(Long id) {
        return null;
    }

}
