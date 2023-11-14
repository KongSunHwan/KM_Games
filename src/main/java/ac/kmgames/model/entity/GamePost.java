package ac.kmgames.model.entity;

import com.querydsl.core.types.dsl.StringExpression;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class GamePost extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_post_id")
    private long id;

    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit; // 이용 등급을 나타내는 필드 [FREE, TWOWELL, FIFTEEN, NINETEEN]
    private String gameTitle; // 게임 제목
    private String nationalityCode; // 원작 국적
    private String company; // 개발사
    private String genreCode; // 게임 장르
    private String gameVersion; // 게임 버전
    private String platformCode; // 게임 플랫폼 타입
    private int gamePrice; // 게임 가격

    @Enumerated(EnumType.STRING)
    private PriceState priceState; // 가격 상태를 나타내는 필드 [FREE, TRIAL]


    @ElementCollection
    @CollectionTable(name = "game_tags",
            joinColumns = @JoinColumn(name = "game_post_id")
    )
    @Column(name = "tagName")
    private Set<String> gameTags = new HashSet<>();

    private String detailContent; // 상세 내용

    @OneToMany(mappedBy="gamePost", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<GamePhoto> gamePhotos = new ArrayList<>(); // 게임 사진

}
