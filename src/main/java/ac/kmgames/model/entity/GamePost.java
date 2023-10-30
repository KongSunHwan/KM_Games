package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class GamePost{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    private AgeLimit age_limit; // 이용 등급을 나타내는 필드 [FREE, TWOWELL, FIFTEEN, NINETEEN]
    private String game_title; // 게임 제목
    private String nationality; // 원작 국적
    private String company; // 개발사
    private String game_genre; // 게임 장르
    private String game_version; // 게임 버전
    private String platform_type; // 게임 플랫폼 타입
    private int game_price; // 게임 가격

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_tags_id")
    private GameTag gameTag;// 게임 포함 태그

    private String detail_title; // 상세 제목
    private String detail_content; // 상세 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_picture_id")
    private GamePicture game_picture; // GamePicture 단방향 매핑


}
