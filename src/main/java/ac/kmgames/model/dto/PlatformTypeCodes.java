package ac.kmgames.model.dto;

import lombok.Data;

/**
 * MOBILE : 모바일용
 * PC : PC용
 */
@Data
public class PlatformTypeCodes {

    private String platformCode;
    private String platformTypeName;

    public PlatformTypeCodes(String platformCode, String platformTypeName) {
        this.platformCode = platformCode;
        this.platformTypeName = platformTypeName;
    }
}
