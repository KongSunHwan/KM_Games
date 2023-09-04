package ac.kmgames.controller;

import ac.kmgames.model.entity.User;
import ac.kmgames.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        if(!passwordEncoder.matches(input.getPassword(), user.getPassword())){
            return
                "<script>" +
                    "alert('아이디 혹은 비밀번호가 잘못되었습니다');" +
                    "history.back();" +
                "</script>";
        }

        session.setAttribute("user", user);
        return "<script>location.href = '/home';</script>";
    }

    @ResponseBody
    @PostMapping("/exists_user")
    public boolean isExistsEmail(String email, @RequestParam(defaultValue = "") String name){
        if(name.isEmpty()){
            return userService.existsByEmail(email);
        }else{
            var user = userService.getUserByEmail(email);
            return user.isValid() && user.getName().equals(name);
        }
    }

    @ResponseBody
    @PostMapping("/change_nickname")
    public boolean changeNickname(HttpSession session, String nickname){
        var obj = session.getAttribute("user");
        if(!(obj instanceof User user)){
            return false;
        }

        var current = userService.getUserByEmail(user.getEmail());
        current.setNickname(nickname);
        if(userService.save(current)){
            session.setAttribute("user", current);
            return true;
        }
        return false;
    }

    @ResponseBody
    @PostMapping("/change_password")
    public boolean changePassword(HttpSession session, String password){
        var obj = session.getAttribute("user");
        if(!(obj instanceof User user)){
            return false;
        }

        var current = userService.getUserByEmail(user.getEmail());
        current.setPassword(passwordEncoder.encode(password));
        if(userService.save(current)){
            session.setAttribute("user", current);
            return true;
        }
        return false;
    }

    @ResponseBody
    @PostMapping("/change_password_without_login")
    public boolean changePasswordWithoutLogin(String email, String password){
        var user = userService.getUserByEmail(email);
        if(!user.isValid()){
            return false;
        }
        user.setPassword(passwordEncoder.encode(password));
        return userService.save(user);
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

