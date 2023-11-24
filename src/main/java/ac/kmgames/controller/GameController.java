package ac.kmgames.controller;

import ac.kmgames.model.dto.GameGenreCodes;
import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.dto.NationalityCodes;
import ac.kmgames.model.dto.PlatformTypeCodes;
import ac.kmgames.model.entity.*;
import ac.kmgames.model.utils.ReviewStatistics;
import ac.kmgames.service.GamePostService;
import ac.kmgames.service.GameReviewService;
import ac.kmgames.service.GameService;
import ac.kmgames.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class GameController{
    private final GameService gameService;
    private final GameReviewService gameReviewService;
    private final UserService userService;
    private final GamePostService gamePostService;

    @ModelAttribute("PriceStates")
    public PriceState[] PriceStates() {
        return PriceState.values(); // 해당 ENUM의 모든 정보를 배열로 반환한다. [FORFREE, TRIAL, CHARGED]
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

    @GetMapping("/game_detail/{id}")
    public String detailPage(HttpSession session, Model model,
                             @PathVariable long id){
        // 세션에서 유저 정보 가져오기
        User user = (User) session.getAttribute("user");
        Long UserId = user.getId();

        model.addAttribute("gamePosts", gamePostService.findById(id).get());
        model.addAttribute("reviews", gameReviewService.getReviewsByGameId(id));

        // 세션에 유저 정보가 있으면 모델에 추가
        if (user != null) {
            model.addAttribute("user", user);
        }

        if (user == null) {
            return "redirect:/";
        }

        // 주석: 게임 ID에 해당하는 리뷰 통계 정보 계산 및 모델에 추가
        for (GamePost gamePost : gamePostService.findGamePostAll()) {
            ReviewStatistics gameReviewStatistics = calculateReviewStatistics(gamePost.getId());
            model.addAttribute("reviewStatistics[" + gamePost.getId() + "]", gameReviewStatistics);
        }

        // 별점 통계 정보 계산
        ReviewStatistics reviewStatistics = calculateReviewStatistics(id);
        model.addAttribute("reviewStatistics", reviewStatistics);

        // 유저 ID 보내기
        model.addAttribute("UserId", UserId);
        model.addAttribute("gameId", id);

        return "game/game_detail";
    }

    private ReviewStatistics calculateReviewStatistics(long gameId) {
        // 게임 ID에 해당하는 리뷰 정보 가져오기
        List<GameReview> reviews = gameReviewService.getReviewsByGameId(gameId);

        // ReviewStatistics 객체 생성
        ReviewStatistics reviewStatistics = new ReviewStatistics();

        // 리뷰 정보를 기반으로 통계 계산
        for (GameReview review : reviews) {
            int rating = review.getRating();
            switch (rating) {
                case 5:
                    reviewStatistics.setFiveStarCount(reviewStatistics.getFiveStarCount() + 1);
                    break;
                case 4:
                    reviewStatistics.setFourStarCount(reviewStatistics.getFourStarCount() + 1);
                    break;
                case 3:
                    reviewStatistics.setThreeStarCount(reviewStatistics.getThreeStarCount() + 1);
                    break;
                case 2:
                    reviewStatistics.setTwoStarCount(reviewStatistics.getTwoStarCount() + 1);
                    break;
                case 1:
                    reviewStatistics.setOneStarCount(reviewStatistics.getOneStarCount() + 1);
                    break;
                default:
                    break;
            }

            // 리뷰 개수를 계산
            reviewStatistics.calculateReviewCount();
        }

        // 리뷰 평균 평점을 계산
        reviewStatistics.calculateAverageRate();

        return reviewStatistics;
    }

    @PostMapping("/game_review")
    public String writeGameReview(HttpSession session, HttpServletRequest request, GameReview input){
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("user_id")));

        GamePost gamePost = new GamePost();
        gamePost.setId(Long.parseLong(request.getParameter("game_id")));

        input.setUser(user);
        input.setGamePost(gamePost);
        gameReviewService.save(input);
        return "redirect:/game_detail";
    }

    @PostMapping("/write")
    public String writeReview(
            @RequestParam String gameId,
            @RequestParam String userId,
            @RequestParam int rating,
            @RequestParam String comment
    ) {
        Long gameIdLong = Long.parseLong(gameId);

        // 게임 포스트와 사용자 정보를 찾아옴
        Optional<GamePost> gamePostOptional = gamePostService.findById(gameIdLong);
        Optional<User> userOptional = userService.getUserById(getUserIdFromUserString(userId));

        if (gamePostOptional.isPresent() && userOptional.isPresent()) {
            GamePost gamePost = gamePostOptional.get();
            User user = userOptional.get();

            // 리뷰 추가
            gameReviewService.writeReview(gamePost, user, rating, comment);

            // 리뷰 통계 업데이트
            gameReviewService.updateReviewStatistics(gamePost);

            // 리다이렉트할 때 게임의 ID를 함께 전달
            return "redirect:/game_detail/" + gameIdLong;
        } else {
            return "redirect:/error-page"; // 적절한 에러 페이지로 리다이렉트 또는 처리
        }
    }


    private Long getUserIdFromUserString(String userString) {
        int startIndex = userString.indexOf("id=");
        int endIndex = userString.indexOf(",");

        // 콤마가 없는 경우를 처리
        if (endIndex == -1) {
            endIndex = userString.length();
        }

        String userIdSubstring = userString.substring(startIndex + 3, endIndex);
        return Long.parseLong(userIdSubstring);
    }


}
