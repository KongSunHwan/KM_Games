package ac.kmgames.controller;

import ac.kmgames.service.GameReviewService;
import ac.kmgames.service.GameService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController{
    private final GameService gameService;
    private final GameReviewService gameReviewService;

    @Autowired
    public GameController(GameService gameService, GameReviewService gameReviewService){
        this.gameService = gameService;
        this.gameReviewService = gameReviewService;
    }

    @GetMapping("/game_add")
    public String game_add() {
        return "game_add/game_add";
    }

    @GetMapping("/game_detail")
    public String detailPage(HttpSession session, HttpServletRequest request,
        @RequestParam(value = "id", defaultValue = "1") long id){
        request.setAttribute("review_list", gameReviewService.getAllByGameId(id));
        request.setAttribute("review_count", gameReviewService.getCountByGameId(id));
        request.setAttribute("average_rate", gameReviewService.getAverageRateByGameId(id));
        return "game_detail/game_detail";
    }

}
