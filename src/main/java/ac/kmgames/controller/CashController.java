package ac.kmgames.controller;

import ac.kmgames.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashController{
    private final CashService cashService;

    @Autowired
    public CashController(CashService cashService){
        this.cashService = cashService;
    }

    @GetMapping("/shop")
    public String shop(){
        return "cash/shop";
    }
}
