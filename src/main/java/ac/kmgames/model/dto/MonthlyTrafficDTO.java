package ac.kmgames.model.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class MonthlyTrafficDTO {
    private String month;
    private Integer msa;
    private Integer pmsa;
    private Double msaip;
    private Integer cmsa;
    private Integer pcmsa;
    private Double cmsaip;
    private Integer ms;
    private Integer pms;
    private Double msip;
    private Integer cms;
    private Integer pcms;
    private Double cmsip;

    public MonthlyTrafficDTO(String month, Integer msa, Integer pmsa, Double msaip, Integer cmsa, Integer pcmsa, Double cmsaip, Integer ms, Integer pms, Double msip, Integer cms, Integer pcms, Double cmsip) {
        this.month = month;
        this.msa = Objects.requireNonNullElse(msa, 0);
        this.pmsa = Objects.requireNonNullElse(pmsa, 0);
        this.msaip = Objects.requireNonNullElse(msaip, 0.00);
        this.cmsa = Objects.requireNonNullElse(cmsa, 0);
        this.pcmsa = Objects.requireNonNullElse(pcmsa, 0);
        this.cmsaip = Objects.requireNonNullElse(cmsaip, 0.00);
        this.ms = Objects.requireNonNullElse(ms, 0);
        this.pms = Objects.requireNonNullElse(pms, 0);
        this.msip = Objects.requireNonNullElse(msip, 0.00);
        this.cms = Objects.requireNonNullElse(cms, 0);
        this.pcms = Objects.requireNonNullElse(pcms, 0);
        this.cmsip = Objects.requireNonNullElse(cmsip, 0.00);
    }
}
