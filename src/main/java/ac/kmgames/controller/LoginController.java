package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.UserRepository;
import ac.kmgames.service.UserService;
import ac.kmgames.util.WebUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class LoginController{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserService userService, PasswordEncoder pwEncoder){
        this.userService = userService;
        this.passwordEncoder = pwEncoder;
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(){
        return "login/register";
    }

    @ResponseBody
    @PostMapping("/request_login")
    public String requestLogin(HttpSession session, User input){
        var user = userService.getUserByEmail(input.getEmail());
        if(
            user == null ||
            !passwordEncoder.matches(input.getPassword(), user.getPassword())
        ){
            return
                "<script>" +
                    "alert('아이디 혹은 비밀번호가 잘못되었습니다');" +
                    "history.back();" +
                "</script>";
        }

        session.setAttribute("user", user);
        return "<script>location.href = '/';</script>";
    }

    @ResponseBody
    @PostMapping("/exists_email")
    public boolean isExistsEmail(String email){
        return userService.existsByEmail(email);
    }

    @ResponseBody
    @PostMapping("/request_register")
    public String requestRegister(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userService.save(user)){
            return
                "<script>" +
                    "alert('회원가입이 완료되었습니다');" +
                    "location.href = '/';" +
                "</script>";
        }else{
            return
                "<script>" +
                    "alert('알 수 없는 이유로 회원가입에 실패했습니다');" +
                    "history.back();" +
                "</script>";
        }
    }
}

