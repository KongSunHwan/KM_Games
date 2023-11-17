package ac.kmgames.validation.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class GamePostSaveForm {

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameTitle; // 게임 제목

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String nationalityCode; // 원작 국적

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String company; // 개발사

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String genreCode; // 게임 장르

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameVersion; // 게임 버전

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String platformCode; // 게임 플랫폼 타입

//    @NotNull
//    @Range(min = 1000, max = 1000000)
    private int gamePrice; // 게임 가격

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String detailContent; // 상세 내용

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameOs; // 운영체제

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameProcess; // 프로세스

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameMemory; // 메모리

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameGraphic; // 그래픽

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameDirectX; // DirectX

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String gameStorage; // 저장공간
}
