package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class GamePhoto extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="game_photo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_post_id")
    private GamePost gamePost;

    @Column(name = "original_name", nullable = false, updatable = false)
    private String origFileName;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    private Long fileSize;


    @Builder
    public GamePhoto(GamePost gamePost, String origFileName, String fileName, String filePath, Long fileSize) {
        this.gamePost = gamePost;
        this.origFileName = origFileName;
        this.fileName  = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public void setGamePost(GamePost gamePost) {
        this.gamePost = gamePost;
    }
}
