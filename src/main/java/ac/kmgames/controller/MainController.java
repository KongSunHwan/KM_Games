package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController{
    @GetMapping("/")
    public String index(HttpSession session){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpSession session){
        var userData = session.getAttribute("user");
        return userData instanceof User user && user.getEmail().length() > 4 ? "home-login" : "home";
    }
}
