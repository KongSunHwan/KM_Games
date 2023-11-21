package ac.kmgames.controller.restApi;

import ac.kmgames.model.entity.GameOrder;
import ac.kmgames.service.GameOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameOrderRestController {
    private final GameOrderService gameOrderService;

    @GetMapping("/api/orders")
    public List<GameOrder> getAllOrders() {
        return gameOrderService.getAllGameOrders();
    }

    @GetMapping("/api/orders/{id}")
    public GameOrder getOrderById(@PathVariable Long id) {
        return gameOrderService.getGameOrderById(id)
                .orElseThrow(() -> new RuntimeException("주문을 찾을 수 없습니다. id: " + id));
    }
}
