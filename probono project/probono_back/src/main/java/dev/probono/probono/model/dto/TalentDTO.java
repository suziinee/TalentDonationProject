package dev.probono.probono.model.dto;

import dev.probono.probono.model.entity.Talent;

public class TalentDTO {

    private Long id;
    private String talentType;

    public TalentDTO() {}

    public TalentDTO(Talent talent) {
        this.id = talent.getId();
        this.talentType = talent.getTalentType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTalentType() {
        return talentType;
    }

    public void setTalentType(String talentType) {
        this.talentType = talentType;
    }

    
}
