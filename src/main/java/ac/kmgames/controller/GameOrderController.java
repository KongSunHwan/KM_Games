package ac.kmgames.controller;

import ac.kmgames.model.entity.*;
import ac.kmgames.service.CartItemService;
import ac.kmgames.service.GameOrderService;
import ac.kmgames.service.GamePostService;
import ac.kmgames.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GameOrderController {

    private final GameOrderService gameOrderService;
    private final GamePostService gamePostService;
    private final ShoppingCartService shoppingCartService;
    private final CartItemService cartItemService;

    @ModelAttribute("PaymentType")
    public PaymentType[] PaymentType() {
        return PaymentType.values(); // 해당 ENUM의 모든 정보를 배열로 반환한다. [CARD, BANK_TRANSFER, MOBILE_PAYMENT] 등
    }

    @GetMapping("/order_detail/{UserId}")
    public String order_detail(@PathVariable long UserId,
                               HttpSession session,
                               Model model) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        List<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartByUser(userId);
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("userId", userId);

        return "order_detail/order_detail";
    }

//    @PostMapping("/placeOrder")
//    public String placeOrder(@RequestParam Long gameId,
//                             @RequestParam Long userId,
//                             @RequestParam(required = false, defaultValue = "0") int totalAmount,
//                             @RequestParam String paymentTypeStr,
//                             @RequestParam String orderStatusStr) {
//
//        // PaymentType과 OrderStatus로의 변환은 각각의 열거형에서 제공하는 메서드를 사용하여 디폴트값 설정
//        PaymentType paymentType = PaymentType.UNCHECKED_PAYMENT;
//        OrderStatus orderStatus = OrderStatus.COMPLETED;
//
//        try {
//            paymentType = PaymentType.valueOf(paymentTypeStr);
//            orderStatus = OrderStatus.valueOf(orderStatusStr);
//        } catch (IllegalArgumentException e) {
//            log.error("Error converting paymentType or orderStatus. paymentTypeStr: {}, orderStatusStr: {}", paymentTypeStr, orderStatusStr, e);
//        }
//
//        log.info("Received values - gameId: {}, userId: {}, totalAmount: {}, paymentType: {}, orderStatus: {}",
//                gameId, userId, totalAmount, paymentType, orderStatus);
//
//        // 주문 서비스를 통해 주문을 처리합니다.
//        gameOrderService.createGameOrder(gameId, userId, totalAmount, paymentType, orderStatus);
//
//        return "redirect:/order_receipt/" + userId + "/" + gameId; // 주문 완료 페이지로 리다이렉트
//    }

//    @PostMapping("/cart/orderSelectedItems")
//    public String orderSelectedItems(HttpServletRequest request) {
//        ShoppingCart shoppingCart = getOrCreateShoppingCart(request); // 쇼핑 카트를 가져오거나 생성합니다.
//        GameOrder order = shoppingCart.orderSelectedItems(); // 선택된 아이템 주문
//        if (order != null) {
//            gameOrderService.processOrder(order); // 주문 처리 로직을 호출
//        }
//        shoppingCartService.save(shoppingCart); // 쇼핑 카트 업데이트
//        return "redirect:/cart";
//    }
//
//    private ShoppingCart getOrCreateShoppingCart(HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
//
//        if (shoppingCart == null) {
//            shoppingCart = new ShoppingCart();
//            session.setAttribute("cart", shoppingCart);
//        }
//
//        return shoppingCart;
//    }

    @RequestMapping("/order_confirmation")
    public String showOrderConfirmation(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        long userId = user.getId();
        GameOrder order = gameOrderService.getLastOrder(userId);
        model.addAttribute("order", order);

//        if (user != null) {
//            long userId = user.getId();
//            GameOrder order = gameOrderService.getLastOrder(userId);
//
//            if (order != null) {
//                model.addAttribute("order", order);
//                return "order_confirmation/order_confirmation";
//            }
//        }

        return "order_confirmation/order_confirmation";

        // 로그인되지 않은 경우 또는 주문이 없는 경우
//        return "redirect:/";
    }

    // 회원 주문 내역
    @GetMapping("/order_history/{userId}")
    public String order_history(@PathVariable Long userId,
                                @PageableDefault(size = 3) Pageable pageable,
                                Model model,
                                HttpSession session
    ) {

        if (session.getAttribute("user")== null) {
            return "redirect:/";
        }
        // 서비스를 통해 주문 내역 가져오기
//        Page<GameOrder> orderPage = gameOrderService.findOrdersByUserIdWithGameInfo(userId, pageable);
//        Page<CartItem> orderPage = cartItemService.getGamePostsByUserIdAndOrderState(userId, pageable);
        Long idByCartId = shoppingCartService.findIdByUserId(userId);
        // OrderService를 통해 주문 내역을 가져옴
        Page<GamePost> games = cartItemService.getGamesByMemberAndCartWithPaging(userId, idByCartId, pageable);

        // Model에 페이징된 주문 세부 정보 추가
//        model.addAttribute("orderPage", orderPage.getContent());
//        model.addAttribute("page", orderPage);

//        List<GamePost> games = cartItemService.getGamesByMemberAndCart(userId, idByCartId);

        // 결과를 모델에 추가
        model.addAttribute("games", games.getContent());
        model.addAttribute("page", games);

        return "order_history/order_history";
    }

    // 주문 영수증 페이지
    @RequestMapping("/order_receipt")
    public String order_receipt(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user != null) {
            long userId = user.getId();
            GameOrder order = gameOrderService.getLastOrder(userId);

            if (order != null) {
                model.addAttribute("order", order);
            } else {
                // 주문이 없는 경우 메인 페이지로 이동
                return "redirect:/main";
            }
        } else {
            // 사용자 정보가 없는 경우 메인 페이지로 이동
            return "redirect:/";
        }


        return "order_receipt/order_receipt";
    }

    // 쇼핑 카트 페이지
    @GetMapping("/order_basket/{userId}")
    public String order_basket(@PathVariable("userId") Long id, HttpSession session, Model model) {

        if (session.getAttribute("user")== null) {
            return "redirect:/";
        }
        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        List<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartByUser(userId);
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("userId", userId);

        return "order_basket/order_basket";
    }

    // 쇼핑 카트 페이지
    @GetMapping("/cart")
    public String viewShoppingCart(Model model, HttpSession session) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        List<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartByUser(userId);
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("userId", userId);

        return "order_basket/cart";
    }

    @PostMapping("/order_basket/add")
    public String addToCart(@RequestParam("gameId") long gameId, HttpSession session) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        shoppingCartService.addGameToCart(gameId, userId);
        return "redirect:/order_basket/{userId}";
    }

    @PostMapping("/order_basket/update")
    public String updateCart(@RequestParam("gameId") long gameId, @RequestParam("isChecked") boolean isChecked, HttpSession session) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        shoppingCartService.setGameItemChecked(gameId, isChecked, userId);
        return "redirect:/order_basket/{userId}";
    }

    @PostMapping("/order_basket/remove")
    public String removeFromCart(@RequestParam("gameId") long gameId, HttpSession session) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        shoppingCartService.removeGameFromCart(gameId, userId);
        return "redirect:/order_basket/{userId}";
    }

    @PostMapping("/order_basket/checkout")
    public String checkoutCart(Model model, HttpSession session) {

        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        GameOrder order = shoppingCartService.orderSelectedItems(userId);
        if (order != null) {
            model.addAttribute("order", order);
            model.addAttribute("userId", userId);
            return "redirect:/order_receipt";
        } else {
            // 아무 것도 선택되지 않은 경우 처리
            return "redirect:/";
        }
    }
}
