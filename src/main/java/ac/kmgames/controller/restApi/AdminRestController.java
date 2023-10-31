package ac.kmgames.controller.restApi;


import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.service.PaymentService;
import ac.kmgames.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.Certificate;

@Slf4j
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminRestController {
    private final UserService userService;
    private final PaymentService paymentService;

    //회원정보
    @GetMapping("user/{id}")
    public ResponseEntity userInfo(@PathVariable("id") int id) {
        UserDTO result = userService.getUserDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    //구매내역
    @PostMapping("user/payment/{id}")
    public ResponseEntity userPaymentInfo(@PathVariable("id") int id,
                                           @RequestBody Criteria criteria) {
        ResponsePageDTO.ResponsePayment result = paymentService.getPaymentHListAdmin(id, criteria);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    //찜목록
    //리뷰내역
}
