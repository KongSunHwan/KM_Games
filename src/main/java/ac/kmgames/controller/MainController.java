package ac.kmgames.controller;

import ac.kmgames.model.dto.GameGenreCodes;
import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.dto.PlatformTypeCodes;
import ac.kmgames.model.entity.GamePost;
//import ac.kmgames.model.entity.QGamePost;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.PriceState;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.utils.ReviewStatistics;
import ac.kmgames.service.*;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.core.types.dsl.Expressions;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController{
    private final UserService userService;
    private final GameService gameService;
    private final GamePostService gamePostService;
    private final CartItemService cartItemService;
    private final GameReviewService gameReviewService;

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request,
        @RequestParam(value = "page", defaultValue = "1") int page){
        if(session.getAttribute("user") instanceof User user){
            page = Math.max(page - 1, 0);
            var startPage = (page / 5) * 5 + 1;
            var pageCount = (int) Math.ceil(gameService.getCount() / 16.0);
            request.setAttribute("page", page + 1);
            request.setAttribute("start_page", startPage);
            request.setAttribute("page_count", pageCount);
            request.setAttribute("end_page", Math.min(startPage + 4, pageCount));
            request.setAttribute("game_list", gameService.getAll(page));
            return "index";
        }else{
            return "index_login";
        }
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

    @ModelAttribute("PriceStates")
    public PriceState[] PriceStates() {
        return PriceState.values(); // 해당 ENUM의 모든 정보를 배열로 반환한다. [FORFREE, TRIAL, CHARGED]
    }

    @GetMapping("/main")
    public String main(@PageableDefault(size = 16) Pageable pageable,Model model) {
        Page<GamePost> page = gamePostService.findAllByOrderByIdDesc(pageable);

        model.addAttribute("gamePosts", page.getContent());
        model.addAttribute("page", page);
        return "main/main";
    }


    @GetMapping("/search")
    public String searchGamePosts(
            @RequestParam(name = "keyword") String keyword,
            @RequestParam(name = "keywordType") String keywordType,
            @PageableDefault(size = 16) Pageable pageable,
            Model model
    ) {
        Page<GamePost> gamePosts = gamePostService.findByKeyword(keyword, keywordType, pageable);
        model.addAttribute("gamePosts", gamePosts.getContent());
        model.addAttribute("page", gamePosts);
        model.addAttribute("keywordType", keywordType);
        model.addAttribute("keyword", keyword);

        return "search/search_results";
    }

    // 가격 상태(priceState)에 따라 게시물 검색
    @GetMapping("/searchByPriceState")
    public String searchByPriceState(
            @RequestParam(name = "priceState") PriceState priceState,
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page - 1, 16);
        Page<GamePost> gamePosts = gamePostService.findByPriceState(priceState, pageable);

        model.addAttribute("gamePosts", gamePosts.getContent());
        model.addAttribute("page", gamePosts);
        model.addAttribute("priceState", priceState);

        return "search/search_results";
    }

    // 게임 장르(genreCode)에 따라 게시물 검색
    @GetMapping("/searchByGenreCode")
    public String searchByGenreCode(
            @RequestParam(name = "genreCode") String genreCode,
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page - 1, 16);
        Page<GamePost> gamePosts = gamePostService.findByGenreCode(genreCode, pageable);

        model.addAttribute("gamePosts", gamePosts.getContent());
        model.addAttribute("page", gamePosts);
        model.addAttribute("genreCode", genreCode);

        return "search/search_results";
    }

//    @ResponseBody
//    @GetMapping("*")
//    public String preparedFeature(){
//        return
//            "<script>" +
//                "alert('현재 준비중인 기능입니다');" +
//                "history.back();" +
//            "</script>";
//    }
}
