package ac.kmgames.controller;

import ac.kmgames.model.dto.GameGenreCodes;
import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.dto.NationalityCodes;
import ac.kmgames.model.dto.PlatformTypeCodes;
import ac.kmgames.model.entity.*;
import ac.kmgames.service.GamePostService;
import ac.kmgames.service.GameReviewService;
import ac.kmgames.service.GameService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GameController{
    private final GameService gameService;
    private final GameReviewService gameReviewService;
    private final GamePostService gamePostService;

    @Autowired
    public GameController(GameService gameService, GameReviewService gameReviewService, GamePostService gamePostService){
        this.gameService = gameService;
        this.gameReviewService = gameReviewService;
        this.gamePostService = gamePostService;
    }

    @ModelAttribute("PriceStates")
    public PriceState[] PriceStates() {
        return PriceState.values(); // 해당 ENUM의 모든 정보를 배열로 반환한다. [FORFREE, TRIAL]
    }

    @ModelAttribute("AgeLimits")
    public AgeLimit[] AgeLimits() {
        return AgeLimit.values(); // 해당 ENUM의 모든 정보를 배열로 반환한다. [FREE, TWOWELL, FIFTEEN, NINETEEN]
    }

    @ModelAttribute("gameTags")
    public Map<String, String> gameTags() {
        Map<String, String> gametags = new LinkedHashMap<>();
        gametags.put("Indy", "인디");
        gametags.put("Action", "액션");
        gametags.put("Advantage", "어드밴처");
        gametags.put("casual", "캐주얼");
        gametags.put("Rpg", "RPG");
        gametags.put("Simulation", "시뮬레이션");
        gametags.put("Strategy", "전략");
        gametags.put("SinglePlay", "싱글플레이");
        gametags.put("FreePlay", "무료플레이");
        gametags.put("2d", "2D");
        gametags.put("3d", "3D");
        gametags.put("Mood", "분위기있는");
        gametags.put("Story", "풍부한스토리");
        gametags.put("Exploration", "탐험");
        return gametags;
    }

    @ModelAttribute("NationalityCodes")
    public List<NationalityCodes> nationalityCodes() {
        List<NationalityCodes> nationalityCodes = new ArrayList<>();
        nationalityCodes.add(new NationalityCodes("KOREA", "한국"));
        nationalityCodes.add(new NationalityCodes("JAPAN", "일본"));
        nationalityCodes.add(new NationalityCodes("US", "미국"));
        return nationalityCodes;
    }

    @ModelAttribute("GameGenreCodes")
    public List<GameGenreCodes> gameGenreCodes() {
        List<GameGenreCodes> gameGenreCodes = new ArrayList<>();
        gameGenreCodes.add(new GameGenreCodes("ACTION", "액션"));
        gameGenreCodes.add(new GameGenreCodes("ADVENTURE", "어드벤처"));
        gameGenreCodes.add(new GameGenreCodes("RPG", "알피지"));
        gameGenreCodes.add(new GameGenreCodes("PUZZLE", "퍼즐"));
        gameGenreCodes.add(new GameGenreCodes("SPORTS", "스포츠"));
        gameGenreCodes.add(new GameGenreCodes("HORROR", "호러"));
        gameGenreCodes.add(new GameGenreCodes("MUSIC", "음악"));
        return gameGenreCodes;
    }

    @ModelAttribute("PlatformTypeCodes")
    public List<PlatformTypeCodes> platformTypeCodes() {
        List<PlatformTypeCodes> platformTypeCodes = new ArrayList<>();
        platformTypeCodes.add(new PlatformTypeCodes("MOBILE", "모바일용"));
        platformTypeCodes.add(new PlatformTypeCodes("PC", "PC용"));
        return platformTypeCodes;
    }

    @GetMapping("/game_add")
    public String game_add(Model model) {
        model.addAttribute("gameForm", new GamePostDTO.Response());

        return "game_add/game_add";
    }

//    @ResponseBody
//    @PostMapping("/game_add")
//    public String game_create(GamePostDTO gamePostDTO, BindingResult result) {
////        if(result.hasErrors()) {
////            return "game_add/game_add";
////        }
//
//        GamePost gamePost = new GamePost();
//        gamePost.setAgeLimit(gamePostDTO.getAgeLimit());
//        gamePost.setGameTitle(gamePostDTO.getGameTitle());
//        gamePost.setNationalityCode(gamePostDTO.getNationalityCode());
//        gamePost.setCompany(gamePostDTO.getCompany());
//        gamePost.setGenreCode(gamePostDTO.getGenreCode());
//        gamePost.setGameVersion(gamePostDTO.getGameVersion());
//        gamePost.setPlatformCode(gamePostDTO.getPlatformCode());
//        gamePost.setGamePrice(gamePostDTO.getGamePrice());
//        gamePost.setPriceState(gamePostDTO.getPriceState());
//        gamePost.setGameTag(gamePostDTO.getGameTag());
//        gamePost.setDetailContent(gamePostDTO.getDetailContent());
//
//        if(gamePostService.save(gamePost)){
//            return
//                    "<script>" +
//                            "alert('게임등록이 완료되었습니다');" +
//                            "location.href = '/';" +
//                            "</script>";
//        }else{
//            return "<script>history.back()</script>";
//        }
//    }

//    @PostMapping("/game_add")
//    public ResponseEntity<String> addGame(@RequestBody GamePostDTO.Response gamePostDTO, BindingResult result) {
////        if(result.hasErrors()) {
////            return "game_add/game_add";
////        }
//
//        GamePost gamePost = new GamePost();
//        gamePost.setAgeLimit(gamePostDTO.getAgeLimit());
//        gamePost.setGameTitle(gamePostDTO.getGameTitle());
//        gamePost.setNationalityCode(gamePostDTO.getNationalityCode());
//        gamePost.setCompany(gamePostDTO.getCompany());
//        gamePost.setGenreCode(gamePostDTO.getGenreCode());
//        gamePost.setGameVersion(gamePostDTO.getGameVersion());
//        gamePost.setPlatformCode(gamePostDTO.getPlatformCode());
//        gamePost.setGamePrice(gamePostDTO.getGamePrice());
//        gamePost.setPriceState(gamePostDTO.getPriceState());
//        gamePost.setGameTag(gamePostDTO.getGameTag());
//        gamePost.setDetailContent(gamePostDTO.getDetailContent());
//
//        // GamePostService를 사용하여 게임 정보를 저장
//        if (gamePostService.save(gamePost)) {
//            return new ResponseEntity<>("게임 정보가 성공적으로 저장되었습니다.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("게임 정보 저장에 실패하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/game_detail")
    public String detailPage(HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "id", defaultValue = "1") long id){
        request.setAttribute("game", gameService.getGameById(id).get());
        request.setAttribute("review_list", gameReviewService.getAllByGameId(id));
        request.setAttribute("review_count", gameReviewService.getCountByGameId(id));
        request.setAttribute("average_rate", gameReviewService.getAverageRateByGameId(id));
        return "game/game_detail";
    }

    @PostMapping("/game_review")
    public String writeGameReview(HttpSession session, HttpServletRequest request, GameReview input){
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("user_id")));
        Game game = new Game();
        game.setId(Long.parseLong(request.getParameter("game_id")));
        input.setUser(user);
        input.setGame(game);
        gameReviewService.save(input);
        return "redirect:/game_detail";
    }

}
