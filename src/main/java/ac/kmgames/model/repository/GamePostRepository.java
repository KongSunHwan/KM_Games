package ac.kmgames.model.repository;


import ac.kmgames.model.dto.GameSearch;
import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.GamePhoto;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.GameReview;
//import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GamePostRepository extends JpaRepository<GamePost, Long> {

    // 게임 등록
    GamePost save(GamePost gamePost);

    // 리스트 아이디 내림차순 조회
    List<GamePost> findAllByOrderByIdDesc();

    // 메인페이지 페이징 + 리스트
    Page<GamePost> findAllByOrderByIdDesc(Pageable pageable);

    // 게임 제목에 대한 검색
    Page<GamePost> findByGameTitleContainingOrderByIdDesc(String gameTitle, Pageable pageable);

    // 게임 태그에 대한 검색
    Page<GamePost> findByGameTagsContainingOrderByIdDesc(String gameTags, Pageable pageable);

    // 등록된 게임 아이디 find
    Optional<GamePost> findById(long id);

    // 게임 전체 리스트
    List<GamePost> findAll();

}
