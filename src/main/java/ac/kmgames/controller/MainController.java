package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
import ac.kmgames.service.GameReviewService;
import ac.kmgames.service.GameService;
import ac.kmgames.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController{
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public MainController(UserService userService, GameService gameService){
        this.userService = userService;
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request,
        @RequestParam(value = "page", defaultValue = "1") int page){
        if(session.getAttribute("user") instanceof User user){
            page = Math.max(page - 1, 0);
            request.setAttribute("current_page", page + 1);
            request.setAttribute("game_list", gameService.getAll(page));
            request.setAttribute("game_page", (long) Math.ceil(gameService.getCount() / 16.0));
            return "main/index";
        }else{
            return "main/index_login";
        }
    }

    @ResponseBody
    @GetMapping("*")
    public String preparedFeature(){
        return
            "<script>" +
                "alert('현재 준비중인 기능입니다');" +
                "history.back();" +
            "</script>";
    }
}
