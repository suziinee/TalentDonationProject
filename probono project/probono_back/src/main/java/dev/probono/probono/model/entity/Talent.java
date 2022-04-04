package dev.probono.probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Talent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TALENT_ID")
    private Long id;

    private String talentType;

    public Talent() {}

    public Talent(String talentType) {
        this.talentType = talentType;
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
