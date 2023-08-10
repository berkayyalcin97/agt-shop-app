package tr.com.adesso.service.order.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.adesso.service.order.dto.OrderRequestDto;
import tr.com.adesso.service.order.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name="v1 - Order APIs",description = "Maintain Order APIs")
public class OrderController {

    private final OrderService orderService;

    @Operation(
            summary = "Get all Orders",
            description = "Returns all Orders"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK.",
                            content = @Content(schema = @Schema(implementation = OrderRequestDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {

        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Operation(
            summary = "Get Order by Id",
            description = "Returns Order by given Id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK.",
                            content = @Content(schema = @Schema(implementation = OrderRequestDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @Operation(
            summary = "Create Order",
            description = "Creates Order by given Payload"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.createOrder(orderRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Update Order",
            description = "Updates Order by given Id and Payload"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<OrderRequestDto> updateOrder(@PathVariable("id") Long id, @RequestBody OrderRequestDto orderRequestDto) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderRequestDto));
    }

    @Operation(
            summary = "Delete Order",
            description = "Deletes Order by Id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request."),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorised."),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden."),
                    @ApiResponse(
                            responseCode = "412",
                            description = "Precondition Failed."),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error.",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
