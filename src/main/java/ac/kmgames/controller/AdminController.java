package ac.kmgames.controller;

import ac.kmgames.model.dto.GameDTO;
import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final PaymentService paymentService;
    private final GameReviewService gameReviewService;
    private final GameService gameService;
    private final GamePostService gamePostService;

    @GetMapping("game_management")
    public String game_management(@PageableDefault(size = 16) Pageable pageable, Model model) {
        Page<GamePost> page = gamePostService.findAllByOrderByIdDesc(pageable);

        model.addAttribute("gamePosts", page.getContent());
        model.addAttribute("page", page);

        return "admin_dashboard/game_management";
    }

    @GetMapping("game_management_search")
    public String game_management_search(
            @RequestParam(name = "keyword") String keyword,
            @RequestParam(name = "keywordType") String keywordType,
            @PageableDefault(size = 16) Pageable pageable,
            Model model
    ) {
        Page<GamePost> gamePosts = gamePostService.findByKeyword(keyword, keywordType, pageable);
        model.addAttribute("gamePosts", gamePosts.getContent());
        model.addAttribute("page", gamePosts);
        model.addAttribute("keywordType", keywordType);
        model.addAttribute("keyword", keyword);

        return "admin_dashboard/game_management_search";
    }

    @GetMapping(value = "game_detail_manage")
    public String gameManagement(@RequestParam(value = "id", defaultValue = "1") long id,Model model) {

        List<GameDTO> game_info = gameService.get_game_info(id);
        List<HashMap> payment_game = paymentService.get_game_payment_l5(id);
        List<HashMap> game_review = gameReviewService.get_game_reivew_l5(id);

        model.addAttribute("id", id);
        model.addAttribute("game_info", game_info);
        model.addAttribute("payment_game", payment_game);
        model.addAttribute("game_review", game_review);
        return "admin_dashboard/game_detail_manage";
    }

    @GetMapping(value = "game_detail_payment")
    public String game_detail_payment(@RequestParam(value = "id", defaultValue = "1") long id,Model model,Criteria criteria){
        List<GameDTO> game_info = gameService.get_game_info(id);
        ResponsePageDTO.ResponsePayment payment_game = paymentService.get_payment_group_game(criteria,id);
        model.addAttribute("game_user_cnt", paymentService.get_payment_group_game_cnt(criteria,id));
        model.addAttribute("payment_game", payment_game);
        model.addAttribute("game_info", game_info);
        return "admin_dashboard/game_detail_payment";
    }

    @GetMapping(value = "game_detail_review")
    public String game_detail_review(@RequestParam(value = "id", defaultValue = "1") long id,Model model,Criteria criteria){
        List<GameDTO> game_info = gameService.get_game_info(id);
        ResponsePageDTO.ResponseReview game_review = gameReviewService.get_review_group_game(criteria,id);
        model.addAttribute("game_review_cnt", paymentService.get_review_group_game_cnt(criteria,id));
        model.addAttribute("game_review", game_review);
        model.addAttribute("game_info", game_info);
        return "admin_dashboard/game_detail_review";
    }

    @GetMapping("game_review")
    public String game_review(Model model, @PageableDefault(size = 16) Pageable pageable) {
        Page<GameReview> page = gameReviewService.findAllByOrderByIdDesc(pageable);

        model.addAttribute("gameReviews", page.getContent());
        model.addAttribute("page", page);
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

//    @GetMapping("member_order")
//    public String member_order(
//        HttpServletRequest request,
//        @RequestParam(value = "page", defaultValue = "1") int page){
//        page = Math.max(page - 1, 0);
//        var payment = paymentService.getAll(page);
//        request.setAttribute("payment_list", payment.getContent());
//        request.setAttribute("current_page", page + 1);
//        request.setAttribute("payment_page", (long) Math.ceil(paymentService.getCount() / 5.0));
//        return "admin_dashboard/member_order";
//    }

    @GetMapping("member_order")
    public String member_order(Criteria criteria,Model model){
        System.out.println(criteria.getType() + "asdfasdfasdf");
        ResponsePageDTO.ResponsePayment list = paymentService.getPaymentList(criteria);
        model.addAttribute("pageList", list);
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
    public String member_searchs(Criteria criteria, Model model, String startDate, String endDate) {
        if(endDate == null) {
            System.out.println("날짜 선택 x");
            ResponsePageDTO.ResponseUser list = userService.getUserListAdmin(criteria);
            model.addAttribute("pageList", list);
            return "admin_dashboard/member_searchs";
        }
        else{
            System.out.println("날짜 선택 on");
            ResponsePageDTO.ResponseUser list = userService.getUserListAdmin(criteria, startDate, endDate);
            model.addAttribute("pageList", list);
            model.addAttribute("startDate", startDate);
            model.addAttribute("endDate", endDate);
            return "admin_dashboard/member_searchs";
        }
    }

    //회원상세정보
    @GetMapping(value = "member_detail.do")
    public String member_detail(@RequestParam Long id, HttpServletRequest request,
                                 @RequestParam(value = "page", defaultValue = "1")int page) {
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

    @GetMapping("member_detail/{id}")
    public String member_detailGo(@PathVariable("id") Long id, Model model, @PageableDefault(size = 3) Pageable pageable) {

        Page<GameReview> gameReviews = gameReviewService.findAllByUserIdOrderByIdDesc(id, pageable);

        model.addAttribute("gameReviews", gameReviews.getContent());
        model.addAttribute("page", gameReviews);

        return "admin_dashboard/member_detail";
    }

    @GetMapping("/testt")
    public String testerMethod() {
        return "admin_dashboard/testt";
    }
}
