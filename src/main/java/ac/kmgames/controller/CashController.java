package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
import ac.kmgames.service.CashService;
import ac.kmgames.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CashController{
    private final CashService cashService;
    private final PaymentService paymentService;

    @Autowired
    public CashController(CashService cashService, PaymentService paymentService){
        this.cashService = cashService;
        this.paymentService = paymentService;
    }

    @GetMapping("/shop")
    public String shop(){
        return "cash/shop";
    }

    @GetMapping("/payment_history")
    public String myPage(HttpSession session, HttpServletRequest request,
                         @RequestParam(value = "page", defaultValue = "1") int page){
        var obj = session.getAttribute("user");
        page = Math.max(page - 1, 0);

        if(obj instanceof User user){
            request.setAttribute("current_page", page + 1);
            request.setAttribute(
                "page_count",
                Math.max(paymentService.getHistoryCountByEmail(user.getEmail()) / 20, 1)
            );
            request.setAttribute(
                "payment_history",
                paymentService.getHistoryListByEmail(user.getEmail(), page)
            );
        }
        return "cash/payment_history";
    }
}
