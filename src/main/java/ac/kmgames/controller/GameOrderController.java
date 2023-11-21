package ac.kmgames.controller;

import ac.kmgames.model.dto.GameOrderDTO;
import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.entity.*;
import ac.kmgames.service.GameOrderService;
import ac.kmgames.service.GamePostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GameOrderController {

    private final GameOrderService gameOrderService;
    private final GamePostService gamePostService;

    @ModelAttribute("PaymentType")
    public PaymentType[] PaymentType() {
        return PaymentType.values(); // 해당 ENUM의 모든 정보를 배열로 반환한다. [CARD, BANK_TRANSFER, MOBILE_PAYMENT] 등
    }

    @GetMapping("/order_detail/{gameId}/{userId}")
    public String order_detail(@PathVariable long gameId,
                               @PathVariable long userId,
                               HttpSession session,
                               Model model) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        String name = user.getNickname();
//        long userId = user.getId();

        // 세션에 유저 정보가 있으면 모델에 추가
        if (user != null) {
            model.addAttribute("user", user);
        }

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("gameOrders", new GameOrderDTO());
        model.addAttribute("gamePost", gamePostService.findById(gameId).get());
        model.addAttribute("name", name);
        model.addAttribute("userId", userId);

        return "order_detail/order_detail";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam Long gameId,
                             @RequestParam Long userId,
                             @RequestParam(required = false, defaultValue = "0") int totalAmount,
                             @RequestParam String paymentTypeStr,
                             @RequestParam String orderStatusStr) {

        // PaymentType과 OrderStatus로의 변환은 각각의 열거형에서 제공하는 메서드를 사용하여 디폴트값 설정
        PaymentType paymentType = PaymentType.UNCHECKED_PAYMENT;
        OrderStatus orderStatus = OrderStatus.COMPLETED;

        try {
            paymentType = PaymentType.valueOf(paymentTypeStr);
            orderStatus = OrderStatus.valueOf(orderStatusStr);
        } catch (IllegalArgumentException e) {
            log.error("Error converting paymentType or orderStatus. paymentTypeStr: {}, orderStatusStr: {}", paymentTypeStr, orderStatusStr, e);
        }

        log.info("Received values - gameId: {}, userId: {}, totalAmount: {}, paymentType: {}, orderStatus: {}",
                gameId, userId, totalAmount, paymentType, orderStatus);

        // 주문 서비스를 통해 주문을 처리합니다.
        gameOrderService.createGameOrder(gameId, userId, totalAmount, paymentType, orderStatus);

        return "redirect:/order_receipt/" + userId + "/" + gameId; // 주문 완료 페이지로 리다이렉트
    }

    @GetMapping("/order_receipt/{userId}/{gameId}")
    public String order_receipt(@PathVariable long userId, @PathVariable long gameId, Model model) {

        // 주문 정보 가져오는 로직을 추가
        List<GameOrder> gameOrder = gameOrderService.getOrderByUserIdAndGamePostId(userId, gameId);

        // 모델에 주문 정보 추가
        model.addAttribute("gameOrder", gameOrder);

        return "order_receipt/order_receipt";
    }

    @GetMapping("/order_history/{userId}")
    public String order_history(@PathVariable Long userId,
                                @PageableDefault(size = 3) Pageable pageable,
                                Model model) {

        // 주문 세부 정보를 가져오기 위해 서비스 호출
        Page<GameOrder> orderPage = gameOrderService.findByUserIdWithGameInfo(userId, pageable);

        // Model에 페이징된 주문 세부 정보 추가
        model.addAttribute("orderPage", orderPage.getContent());
        model.addAttribute("page", orderPage);

        return "order_history/order_history";
    }

    @GetMapping("/order_basket")
    public String order_basket() {
        return "order_basket/order_basket";
    }
}
