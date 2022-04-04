package dev.probono.probono.model.dto;


public class MatchDTO {
    
    private Long id; 
    private Long beneficiaryId;
    private Long donatorId;
    private Long talentId;
    
    public MatchDTO() {}
    
    public MatchDTO(Long id, Long beneficiaryId, Long donatorId, Long talentId) {
        this.id = id;
        this.beneficiaryId = beneficiaryId;
        this.donatorId = donatorId;
        this.talentId = talentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(Long donatorId) {
        this.donatorId = donatorId;
    }

    public Long getTalentId() {
        return talentId;
    }

    public void setTalentId(Long talentId) {
        this.talentId = talentId;
    }
    
}
