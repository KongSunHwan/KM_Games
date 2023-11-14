package ac.kmgames.model.dto;

import ac.kmgames.model.entity.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
public class GamePostDTO {

    @Getter
    @NoArgsConstructor
    public static class Response {
        private long id;
        private AgeLimit ageLimit;
        private String gameTitle;
        private String nationalityCode;
        private String company;
        private String genreCode;
        private String gameVersion;
        private String platformCode;
        private int gamePrice;
        private PriceState priceState;
        private Set<String> gameTags;
        private String detailContent;
        private String gameOs;
        private String gameProcess;
        private String gameMemory;
        private String gameGraphic;
        private String gameDirectX;
        private String gameStorage;
        private List<GamePhoto> gamePhotos;
        private LocalDateTime createdDateTime;

        public Response(GamePost gamePost) {
            this.id = gamePost.getId();
            this.ageLimit = gamePost.getAgeLimit();
            this.gameTitle = gamePost.getGameTitle();
            this.nationalityCode = gamePost.getNationalityCode();
            this.company = gamePost.getCompany();
            this.genreCode = gamePost.getGenreCode();
            this.gameVersion = gamePost.getGameVersion();
            this.platformCode = gamePost.getPlatformCode();
            this.gamePrice = gamePost.getGamePrice();
            this.priceState = gamePost.getPriceState();
            this.gameTags = gamePost.getGameTags();
            this.detailContent = gamePost.getDetailContent();
            this.gameOs = gamePost.getGameOs();
            this.gameProcess = gamePost.getGameProcess();
            this.gameMemory = gamePost.getGameMemory();
            this.gameGraphic = gamePost.getGameGraphic();
            this.gameDirectX = gamePost.getGameDirectX();
            this.gameStorage = gamePost.getGameStorage();
            this.gamePhotos = gamePost.getGamePhotos();
            this.createdDateTime = gamePost.getCreatedDateTime();
        }
    }

    @Getter
    public static class ListResponse {
        private Long id;
        private String gameTitle;
        private String nationalityCode;
        private String company;
        private String genreCode;
        private String gameVersion;
        private String platformCode;
        private int gamePrice;
        private PriceState priceState;
        private Set<String> gameTags;
        private String detailContent;
        private String gameOs;
        private String gameProcess;
        private String gameMemory;
        private String gameGraphic;
        private String gameDirectX;
        private String gameStorage;
        private List<GamePhoto> gamePhotos;
        private LocalDateTime createdDateTime;

        public ListResponse(GamePost gamePost) {
            this.id = gamePost.getId();
            this.gameTitle = gamePost.getGameTitle();
            this.nationalityCode = gamePost.getNationalityCode();
            this.company = gamePost.getCompany();
            this.genreCode = gamePost.getGenreCode();
            this.gameVersion = gamePost.getGameVersion();
            this.platformCode = gamePost.getPlatformCode();
            this.gamePrice = gamePost.getGamePrice();
            this.priceState = gamePost.getPriceState();
            this.gameTags = gamePost.getGameTags();
            this.detailContent = gamePost.getDetailContent();
            this.gameOs = gamePost.getGameOs();
            this.gameProcess = gamePost.getGameProcess();
            this.gameMemory = gamePost.getGameMemory();
            this.gameGraphic = gamePost.getGameGraphic();
            this.gameDirectX = gamePost.getGameDirectX();
            this.gameStorage = gamePost.getGameStorage();
            this.gamePhotos = gamePost.getGamePhotos();
            this.createdDateTime = gamePost.getCreatedDateTime();
        }
    }
}
