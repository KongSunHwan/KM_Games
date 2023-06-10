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
}
