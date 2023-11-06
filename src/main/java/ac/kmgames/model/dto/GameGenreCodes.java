package ac.kmgames.model.dto;

import lombok.Data;

/**
 * ACTION : 액션
 * ADVENTURE : 어드밴처
 * RPG : 알피지
 * PUZZLE : 퍼즐
 * SPORTS : 스포츠
 * HORROR : 호러
 * MUSIC : 음악
 */
@Data
public class GameGenreCodes {
    private String genreCode;
    private String genreTypeName;

    public GameGenreCodes(String genreCode, String genreTypeName) {
        this.genreCode = genreCode;
        this.genreTypeName = genreTypeName;
    }
}
