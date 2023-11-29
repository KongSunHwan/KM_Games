package ac.kmgames.controller;

import ac.kmgames.model.entity.CashHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.service.CashService;
import ac.kmgames.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@RequiredArgsConstructor
@Controller
public class CashController{
    private final CashService cashService;
    private final UserService userService;

    @GetMapping("/shop")
    public String shop(){
        return "cash/shop";
    }

    @ResponseBody
    @PostMapping("/purchase_cash")
    public boolean purchaseCash(HttpSession session, @RequestParam(defaultValue = "0") int amount, String method){
        var obj = session.getAttribute("user");
        if(!(obj instanceof User user)){
            return false;
        }

        var cash = new CashHistory();
        cash.setUser(user);
        cash.setAmount(amount);
        cash.setMethod(method);

//        var users = new User();
//        users.setCash(amount);
//
//        // 사용자 정보를 데이터베이스에 업데이트
//        userService.updateUser(user);

        if(cashService.save(cash)){
            user.addCash(amount);
            return true;
        }
        return false;
    }
}
