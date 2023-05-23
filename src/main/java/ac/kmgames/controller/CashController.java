package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
import ac.kmgames.service.CashService;
import ac.kmgames.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashController{
    private final CashService cashService;
    private final PaymentService paymentService;

    @Autowired
    public CashController(CashService cashService, PaymentService paymentService){
        this.cashService = cashService;
        this.paymentService = paymentService;
    }

    @GetMapping("/payment_history")
    public String myPage(HttpSession session, HttpServletRequest request){
        var obj = session.getAttribute("user");
        if(obj instanceof User user){
            request.setAttribute("payment_history", paymentService.getAllHistoryByEmail(user.getEmail()));
        }
        return "my_page";
    }
}
