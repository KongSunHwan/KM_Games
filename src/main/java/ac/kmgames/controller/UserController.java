package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
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
public class UserController{
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public UserController(UserService userService, GameService gameService){
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

    @GetMapping("/my_info")
    public String myInfo(){
        return "my_info";
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

    //test
    @GetMapping("/my_info2")
    public String my_page_nav(){
        return "my_page/my_info2";
    }
    //test
    @GetMapping("/change_pw")
    public String change_pw(){
        return "my_page/change_pw";
    }

    //test
    @GetMapping("/usage_detail")
    public String usage_detail(){
        return "my_page/usage_detail";
    }




}
