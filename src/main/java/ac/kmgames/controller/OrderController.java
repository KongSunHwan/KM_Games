package ac.kmgames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {
    @GetMapping("/order_detail/{id}")
    public String order_detail(@PathVariable long id, Model model) {
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
