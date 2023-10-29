package ac.kmgames.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GamePicture {
    @Id
    @GeneratedValue
    @Column(name = "game_picture_id")
    private Long id;
    private String original_name; // 오리지널 파일명
    private String save_name; // 저장된 파일명

    private String filePath; // 파일 경로
    private String size; // 파일 사이즈

    @OneToMany(mappedBy = "game_picture")
    private List<GamePost> gamePosts = new ArrayList<>(); // GamePost와 양방향 매핑 or 연관관계 주인 설정

}
