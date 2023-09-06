package ac.kmgames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/order_detail")
    public String order_detail() {
        return "order_detail/order_detail";
    }

    @GetMapping("/order_receipt")
    public String order_receipt() {
        return "order_receipt/order_receipt";
    }

    @GetMapping("/order_history")
    public String order_history() {
        return "order_history/order_history";
    }

    @GetMapping("/order_basket")
    public String order_basket() {
        return "order_basket/order_basket";
    }
}
