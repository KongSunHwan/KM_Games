package ac.kmgames.controller.restApi;

import ac.kmgames.model.entity.GameOrder;
import ac.kmgames.model.entity.User;
import ac.kmgames.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingCartRestController {

    private final ShoppingCartService shoppingCartService;

    // 쇼핑 카트에서 주문을 완료하는 엔드포인트
//    @PostMapping("/api/shopping-cart/{cartId}/checkout")
//    public GameOrder checkout(@PathVariable Long cartId) {
//        return shoppingCartService.checkout(cartId);
//    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestParam Long userId, @RequestParam Long gameId) {
        try {
            shoppingCartService.addToCart(userId, gameId);
            return ResponseEntity.ok("상품이 카트에 추가되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("카트에 상품을 추가하는 중에 오류가 발생했습니다.");
        }
    }

    @PostMapping("/remove-from-cart")
    public ResponseEntity<String> removeFromCart(@RequestParam Long userId, @RequestParam Long gameId) {
        try {
            shoppingCartService.removeFromCart(userId, gameId);
            return ResponseEntity.ok("상품이 카트에서 제거되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("카트에서 상품을 제거하는 중에 오류가 발생했습니다.");
        }
    }
}
