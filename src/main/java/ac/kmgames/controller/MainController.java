package ac.kmgames.controller;

import ac.kmgames.service.GameService;
import ac.kmgames.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String index(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request){
        request.setAttribute("game_list", gameService.getGameList());
        return "home";
    }

    @GetMapping("/game")
    public String game(){
        return "game_detail";
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
