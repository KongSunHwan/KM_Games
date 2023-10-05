package ac.kmgames.controller;

import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.service.CashService;
import ac.kmgames.service.GameService;
import ac.kmgames.service.PaymentService;
import ac.kmgames.service.UserService;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
public class AdminController {
    private final UserService userService;
    private final PaymentService paymentService;
    private final CashService cashService;

    @Autowired
    public AdminController(UserService userService, PaymentService paymentService,CashService cashService){
        this.userService = userService;
        this.paymentService = paymentService;
        this.cashService = cashService;
    }
    @GetMapping("game_management")
    public String game_management() {
        return "admin_dashboard/game_management";
    }

    @GetMapping("game_review")
    public String game_review() {
        return "admin_dashboard/game_review";
    }

    @GetMapping("game_statistics")
    public String game_statistics() {
        return "admin_dashboard/game_statistics";
    }

    @GetMapping("member_manag_information")
    public String member_manag_information() {
        return "admin_dashboard/member_manag_information";
    }

    @GetMapping("member_order")
    public String member_order() {
        return "admin_dashboard/member_order";
    }

    @GetMapping("member_stop")
    public String member_stop() {
        return "admin_dashboard/member_stop";
    }

    @GetMapping("member_withdrawal")
    public String member_withdrawal() {
        return "admin_dashboard/member_withdrawal";
    }

    @GetMapping("monthly_refund")
    public String monthly_refund() {
        return "admin_dashboard/monthly_refund";
    }

    @GetMapping("monthly_sales")
    public String monthly_sales() {
        return "admin_dashboard/monthly_sales";
    }
    @GetMapping("member_searchs")
    public String member_searchs(HttpServletRequest request,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "searches", required = false) String id) {
        page = Math.max(page -1, 0);
        List<User> users;
        if(id == null){
            users = userService.getAll(page);
        }else{
            users = userService.getUsersByName(id);
            //users.add(userService.getUserByEmail(id));
            //users.addAll(userService.getUsersByNickname(id));
        }
        /*for(var user : users){
            for(var payment : user.getPaymentHistories()){
                System.out.println("구매한 게임: " + payment.getGame().getName());
            }
        }*/
        request.setAttribute("userlist", users);
        request.setAttribute("current_page", page + 1);
        request.setAttribute("user_page", (long) Math.ceil(userService.getCount() / 10.0));
        return "admin_dashboard/member_searchs";
    }
}
