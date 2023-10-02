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
public class InformationController{
    private final CashService cashService;
    private final PaymentService paymentService;

    @Autowired
    public InformationController(CashService cashService, PaymentService paymentService){
        this.cashService = cashService;
        this.paymentService = paymentService;
    }

    @GetMapping("/my_info")
    public String myInfo(){
        return "my_info/my_info";
    }

    @GetMapping("/payment_history")
    public String paymentHistory(HttpSession session, HttpServletRequest request,
                         @RequestParam(value = "page", defaultValue = "1") int page){
        var obj = session.getAttribute("user");
        page = Math.max(page - 1, 0);

        if(obj instanceof User user){
            request.setAttribute("current_page", page + 1);
            request.setAttribute(
                "history_count",
                paymentService.getCountByUserId(user.getId())
            );
            request.setAttribute(
                "payment_history",
                paymentService.getAllByUserId(user.getId(), page)
            );
        }
        return "my_info/payment_history";
    }

    @GetMapping("/cash_history")
    public String cashHistory(HttpSession session, HttpServletRequest request,
                         @RequestParam(value = "page", defaultValue = "1") int page){
        var obj = session.getAttribute("user");
        page = Math.max(page - 1, 0);

        if(obj instanceof User user){
            request.setAttribute("current_page", page + 1);
            request.setAttribute(
                "history_count",
                cashService.getHistoryCountByEmail(user.getEmail())
            );
            request.setAttribute(
                "payment_history",
                    cashService.getHistoryListByEmail(user.getEmail(), page)
            );
        }
        return "my_info/cash_history";
    }
}
