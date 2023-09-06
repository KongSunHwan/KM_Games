package ac.kmgames.controller;

import ac.kmgames.service.GameService;
import ac.kmgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController{
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/janggi")
    public String janggi(){
        return "game/janggi";
    }

    @GetMapping("/2048")
    public String game_2048(){
        return "web_game/2048_ingame";
    }

    @GetMapping("/game_add")
    public String game_add() {
        return "game_add/game_add";
    }
    @GetMapping("/game_detail")
    public String game_detail() {
        return "game_detail/game_detail";
    }

    @GetMapping("/introl_main")
    public String introl_main() {
        return "introl_main/introl_main";
    }

    @GetMapping("/main_list")
    public String main_list() {
        return "main/main_list";
    }

    @GetMapping("/order_detail")
    public String order_detail() {
        return "order_detail/order_detail";
    }
}
