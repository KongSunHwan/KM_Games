package ac.kmgames.controller;

import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.entity.GamePost;
//import ac.kmgames.model.entity.QGamePost;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.utils.ReviewStatistics;
import ac.kmgames.service.GamePostService;
import ac.kmgames.service.GameReviewService;
import ac.kmgames.service.GameService;
import ac.kmgames.service.UserService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController{
    private final UserService userService;
    private final GameService gameService;
    private final GamePostService gamePostService;
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

    @GetMapping("/main")
    public String main(@PageableDefault(size = 16) Pageable pageable, Model model) {
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

    @ResponseBody
    @GetMapping("*")
    public String preparedFeature(){
        return
            "<script>" +
                "alert('현재 준비중인 기능입니다');" +
                "history.back();" +
            "</script>";
    }
}
