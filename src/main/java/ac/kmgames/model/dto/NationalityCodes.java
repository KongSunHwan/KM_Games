package ac.kmgames.model.dto;

import lombok.Data;

/**
 * KOREA: 한국
 * JAPAN: 일본
 * US: 미국
 */

@Data
public class NationalityCodes {

    private String nationalityCode;
    private String nationalityTypeName;

    public NationalityCodes(String nationalityCode, String nationalityTypeName) {
        this.nationalityCode = nationalityCode;
        this.nationalityTypeName = nationalityTypeName;
    }
}
