package ac.kmgames.controller;

import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.service.*;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
public class AdminController {
    private final UserService userService;
    private final PaymentService paymentService;
    private final GameReviewService gameReviewService;

    @Autowired
    public AdminController(UserService userService, PaymentService paymentService,GameReviewService gameReviewService){
        this.userService = userService;
        this.paymentService = paymentService;
        this.gameReviewService = gameReviewService;
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

    //회원상세정보
    @GetMapping(value = "member_detail.do")
    public String member_detail(@RequestParam int id, HttpServletRequest request,
                                @RequestParam(value = "page", defaultValue = "1") int page) {
        User select_user = userService.findAllById(id);
        List<PaymentHistory> user_payment = paymentService.findAllByUser(page,select_user);
        List<GameReview> user_review = gameReviewService.findAllByUser(select_user);
        request.setAttribute("user_review",user_review);
        request.setAttribute("user_payment",user_payment);
//        request.setAttribute("current_page", page + 1);
//        request.setAttribute("payment_page", (long)Math.ceil(paymentService.countAllByUser(select_user) / 5.0));
        request.setAttribute("select_user",select_user);
        System.out.println(user_review);

        return "admin_dashboard/member_detail";
    }

    @GetMapping("main_list")
    public String main_list() {
        return "main/main_list";
    }
}
