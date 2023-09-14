package ac.kmgames.controller;

import ac.kmgames.service.GameService;
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

    @GetMapping("/game_add")
    public String game_add() {
        return "game_add/game_add";
    }
    @GetMapping("/game_detail")
    public String game_detail() {
        return "game_detail/game_detail";
    }

}
