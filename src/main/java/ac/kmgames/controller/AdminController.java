package ac.kmgames.controller;

import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final PaymentService paymentService;
    private final GameReviewService gameReviewService;
    private final GameService gameService;

    @Autowired
    public AdminController(UserService userService, PaymentService paymentService,GameReviewService gameReviewService,GameService gameService){
        this.userService = userService;
        this.paymentService = paymentService;
        this.gameReviewService = gameReviewService;
        this.gameService = gameService;
    }

    @GetMapping("game_management")
    public String game_management(HttpServletRequest request,@RequestParam(value = "keyword", required = false) String keyword,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
                                  @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        page = Math.max(page -1, 0);

        if(keyword == null){
            request.setAttribute("current_page", page + 1);
            request.setAttribute("game_list", gameService.getAll(page));
            request.setAttribute("game_page", (long) Math.ceil(gameService.getCount() / 16.0));
        }else{
            //검색조건 + pageing, list로 변환해야 jsp에서 쓸 수 있음.
            Page<Game> pages = gameService.getFindByName(keyword, pageable);
            List<Game> content = pages.getContent();
            request.setAttribute("game_list", content);
            request.setAttribute("current_page", pages.getNumber() + 1);
            request.setAttribute("game_page", (long) Math.ceil(pages.getTotalElements() / 16.0));
        }

        return "admin_dashboard/game_management";
    }

    @GetMapping(value = "game_detail_manage")
    public String gameManagement(HttpSession session, HttpServletRequest request,
        @RequestParam(value = "id", defaultValue = "1") long id){
        request.setAttribute("game", gameService.getGameById(id).get());
        return "admin_dashboard/game_detail_manage";
    }

    @GetMapping("game_review")
    public String game_review(Model model) {
        model.addAttribute("gameReviews", gameReviewService.getAll());
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
    public String member_order(
        HttpServletRequest request,
        @RequestParam(value = "page", defaultValue = "1") int page
    ){
        page = Math.max(page - 1, 0);
        var payment = paymentService.getAll(page);
        request.setAttribute("payment_list", payment.getContent());
        request.setAttribute("current_page", page + 1);
        request.setAttribute("payment_page", (long) Math.ceil(paymentService.getCount() / 5.0));
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
        @RequestParam(value = "keyword", required = false) String keyword,
        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        page = Math.max(page -1, 0);
        List<User> users;
        if(keyword == null){
            users = userService.getAll(page);
            request.setAttribute("userlist", users);
            request.setAttribute("current_page", page + 1);
            request.setAttribute("user_page", (long) Math.ceil(userService.getCount() / 10.0));
        }else{
            //검색조건 + pageing, list로 변환해야 jsp에서 쓸 수 있음.
            Page<User> pages = userService.getFindByName(keyword, pageable);
            List<User> content = pages.getContent();
            request.setAttribute("userlist", content);
            request.setAttribute("current_page", pages.getNumber() + 1);
            request.setAttribute("user_page", (long) Math.ceil(pages.getTotalElements() / 10.0));
        }
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
}
