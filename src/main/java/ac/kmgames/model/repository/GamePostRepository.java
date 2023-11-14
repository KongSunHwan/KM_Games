package ac.kmgames.model.repository;


import ac.kmgames.model.dto.GameSearch;
import ac.kmgames.model.entity.GamePhoto;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.GameReview;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GamePostRepository extends JpaRepository<GamePost, Long> {


    GamePost save(GamePost gamePost);

    List<GamePost> findAllByOrderByIdDesc();

    // 메인페이지 페이징 + 리스트
    Page<GamePost> findAll(Pageable pageable);

    // 게임 제목에 대한 검색
    Page<GamePost> findByGameTitleContaining(String gameTitle, Pageable pageable);

    // 게임 태그에 대한 검색
    Page<GamePost> findByGameTagsContaining(String gameTags, Pageable pageable);

}
