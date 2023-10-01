package ac.kmgames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

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

    @GetMapping("member_searchs")
    public String member_searchs() {
        return "admin_dashboard/member_searchs";
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
}
