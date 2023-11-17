package ac.kmgames.controller.restApi;

import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.entity.*;
import ac.kmgames.model.utils.FileUtilities;
import ac.kmgames.service.GamePostService;
import ac.kmgames.validation.form.GamePostSaveForm;
import com.google.gson.JsonObject;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@Slf4j
public class GamePostRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GamePostRestController.class);

    private final GamePostService gamePostService;


    /**
     * 게시물 삭제
     *
     * @param GamePostId
     */
    @PostMapping("/gallery/delete")
    public void deleteGallery(@RequestParam("GamePostId") Long GamePostId){

        // 관리자 or 작성자가 아닐 경우 삭제 불가 로직

        gamePostService.delete(GamePostId);
    }

    /**
     * 게시물 저장
     *
     * @param multiRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/gallery")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveGallery(MultipartHttpServletRequest multiRequest ,
                              @Validated @ModelAttribute("form") GamePostSaveForm form,
                              BindingResult bindingResult)
            throws Exception {

        //검증에 실패
        if (bindingResult.hasErrors()) {
            log.info("Validation errors={}", bindingResult);
            return "<script>location.href = '/game_add';</script>";
        }

//        LOGGER.debug(multiRequest.getParameter("id"));
        LOGGER.debug(() -> multiRequest.getParameter("id"));
        JsonObject jsonObject = new JsonObject();

        // 작성자 정보 확인
//        Optional<Member> optMember = memberService.getMemberRepository().findByName(multiRequest.getParameter("memberName"));
//        if (!optMember.isPresent()) {
//            jsonObject.addProperty("response", "error");
//            jsonObject.addProperty("errorMsg", "사용자 정보를 찾을 수 없습니다.");
//
//            return jsonObject.toString();
//        }


        GamePost gamePost = new GamePost();
        List<Long> deleteFileList = new ArrayList<>();

        // 신규 등록
        if (multiRequest.getParameter("id") == null) {
            gamePost.setAgeLimit(AgeLimit.valueOf(multiRequest.getParameter("ageLimit")));
            gamePost.setGameTitle(multiRequest.getParameter("gameTitle"));
            gamePost.setNationalityCode(multiRequest.getParameter("nationalityCode"));
            gamePost.setCompany(multiRequest.getParameter("company"));
            gamePost.setGenreCode(multiRequest.getParameter("genreCode"));
            gamePost.setGameVersion(multiRequest.getParameter("gameVersion"));
            gamePost.setPlatformCode(multiRequest.getParameter("platformCode"));
            if (multiRequest.getParameter("gamePrice") != null) {
            gamePost.setGamePrice(Integer.parseInt(multiRequest.getParameter("gamePrice")));
            } else {
                gamePost.setGamePrice(null);
            }
            gamePost.setPriceState(PriceState.valueOf(multiRequest.getParameter("priceState")));

            // HTTP 요청에서 선택한 게임 태그 값을 배열로 받아옴
            String[] selectedGameTags = multiRequest.getParameterValues("gameTags");

            // 선택한 게임 태그를 담을 Set을 생성
            Set<String> gameTagsSet = new HashSet<>();

            // 선택한 게임 태그 배열이 null이 아니고 비어 있지 않으면 Set에 추가
            if (selectedGameTags != null && selectedGameTags.length > 0) {
                Collections.addAll(gameTagsSet, selectedGameTags);
            }

            // GamePost 엔티티에 게임 태그 설정
            gamePost.setGameTags(gameTagsSet);

            gamePost.setDetailContent(multiRequest.getParameter("detailContent"));
            gamePost.setGameOs(multiRequest.getParameter("gameOs"));
            gamePost.setGameProcess(multiRequest.getParameter("gameProcess"));
            gamePost.setGameMemory(multiRequest.getParameter("gameMemory"));
            gamePost.setGameGraphic(multiRequest.getParameter("gameGraphic"));
            gamePost.setGameDirectX(multiRequest.getParameter("gameDirectX"));
            gamePost.setGameStorage(multiRequest.getParameter("gameStorage"));
        }
        // 수정
        else {
            Optional<GamePost> optGallery = gamePostService.getGamePostRepository().findById(Long.parseLong(multiRequest.getParameter("id")));
            if (!optGallery.isPresent()) {
                jsonObject.addProperty("response", "error");
                jsonObject.addProperty("errorMsg", "게시물 정보를 찾을 수 없습니다.");

                return jsonObject.toString();
            }

            gamePost = optGallery.get();
            gamePost.setAgeLimit(AgeLimit.valueOf(multiRequest.getParameter("ageLimit")));
            gamePost.setGameTitle(multiRequest.getParameter("gameTitle"));
            gamePost.setNationalityCode(multiRequest.getParameter("nationalityCode"));
            gamePost.setCompany(multiRequest.getParameter("company"));
            gamePost.setGenreCode(multiRequest.getParameter("genreCode"));
            gamePost.setGameVersion(multiRequest.getParameter("gameVersion"));
            gamePost.setPlatformCode(multiRequest.getParameter("platformCode"));
            gamePost.setGamePrice(Integer.parseInt(multiRequest.getParameter("gamePrice")));
            gamePost.setPriceState(PriceState.valueOf(multiRequest.getParameter("priceState")));

            // HTTP 요청에서 선택한 게임 태그 값을 배열로 받아옴
            String[] selectedGameTags = multiRequest.getParameterValues("gameTags");

            // 선택한 게임 태그를 담을 Set을 생성
            Set<String> gameTagsSet = new HashSet<>();

            // 선택한 게임 태그 배열이 null이 아니고 비어 있지 않으면 Set에 추가
            if (selectedGameTags != null && selectedGameTags.length > 0) {
                Collections.addAll(gameTagsSet, selectedGameTags);
            }

            // GamePost 엔티티에 게임 태그 설정
            gamePost.setGameTags(gameTagsSet);

            gamePost.setDetailContent(multiRequest.getParameter("detailContent"));
            gamePost.setGameOs(multiRequest.getParameter("gameOs"));
            gamePost.setGameProcess(multiRequest.getParameter("gameProcess"));
            gamePost.setGameMemory(multiRequest.getParameter("gameMemory"));
            gamePost.setGameGraphic(multiRequest.getParameter("gameGraphic"));
            gamePost.setGameDirectX(multiRequest.getParameter("gameDirectX"));
            gamePost.setGameStorage(multiRequest.getParameter("gameStorage"));


            if (!"".equals(multiRequest.getParameter("deleteFiles"))) {
                deleteFileList = Arrays.asList(multiRequest.getParameter("deleteFiles").split(",")).stream()
                        .map(s -> Long.parseLong((String) s)).collect(Collectors.toList());
            }
        }

        Long id = gamePostService.save(gamePost, multiRequest.getFiles("files"), deleteFileList);

        jsonObject.addProperty("response", "OK");
        jsonObject.addProperty("gamePostId", id);

        String gamePostString = "GamePost 정보:\n" +
                "Age Limit: " + gamePost.getAgeLimit() + "\n" +
                "게임 제목: " + gamePost.getGameTitle() + "\n" +
                "국가 코드: " + gamePost.getNationalityCode() + "\n" +
                "개발사 : " + gamePost.getCompany() + "\n" +
                "장르 코드: " + gamePost.getGenreCode() + "\n" +
                "게임 버전: " + gamePost.getGameVersion() + "\n" +
                "플랫폼 코드: " + gamePost.getPlatformCode() + "\n" +
                "게임 가격: " + gamePost.getGamePrice() + "\n" +
                "가격 상태: " + gamePost.getPriceState() + "\n" +
                "게임 태그: " + gamePost.getGameTags() + "\n" +
                "상세 내용: " + gamePost.getDetailContent() + "\n" +
                "운영 체제: " + gamePost.getGameOs() + "\n" +
                "프로 세스: " + gamePost.getGameProcess() + "\n" +
                "메모리 : " + gamePost.getGameMemory() + "\n" +
                "그래픽 : " + gamePost.getGameGraphic() + "\n" +
                "DirectX: " + gamePost.getGameDirectX() + "\n" +
                "저장 공간: " + gamePost.getGameStorage() + "\n";

        System.out.println(gamePostString);

        return jsonObject.toString();
    }

    /**
     * 첨부 파일 다운로드
     *
     * @param id
     * @param response
     */
    @GetMapping("/gallery/download/{id}")
    public void downloadAttach(@PathVariable Long id, HttpServletResponse response){

        Optional<GamePhoto> optGamePhoto = gamePostService.getGamePhotoRepository().findById(id);
        if (!optGamePhoto.isPresent()) {
            throw new RuntimeException("파일을 찾을 수 없습니다.");
        }

        GamePhoto gamePhoto = optGamePhoto.get();
        File file = FileUtilities.getDownloadFile(gamePhoto);

        try {
            byte[] data = FileUtils.readFileToByteArray(file);

            response.setContentType(FileUtilities.getMediaType(gamePhoto.getOrigFileName()).toString());
            response.setContentLength(data.length);
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(gamePhoto.getOrigFileName(), "UTF-8") + "\";");

            response.getOutputStream().write(data);
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (IOException e) {
            throw new RuntimeException("파일 다운로드에 실패하였습니다.");
        } catch (Exception e) {
            throw new RuntimeException("시스템에 문제가 발생하였습니다.");
        }
    }

    // GamePost 엔티티를 Response DTO로 변환하는 메서드
    public GamePostDTO.Response convertToResponse(GamePost gamePost) {
        return new GamePostDTO.Response(
                gamePost
        );
    }

    // GamePost 엔티티 목록을 ListResponse DTO 목록으로 변환하는 메서드
    public List<GamePostDTO.ListResponse> convertToListResponse(List<GamePost> gamePostList) {
        return gamePostList.stream()
                .map(gamePost -> new GamePostDTO.ListResponse(
                        gamePost
                ))
                .collect(Collectors.toList());
    }

    //메인페이지 + (페이징)
    @GetMapping("/api/main")
    public Page<GamePost> apiMain(@PageableDefault(size = 5) Pageable pageable) {
        Page<GamePost> page = gamePostService.findAllByOrderByIdDesc(pageable);
        Page<GamePostDTO.Response> mappedPage = page.map(gamePost -> convertToResponse(gamePost));
        return page;
    }

}
