package dev.probono.probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MATCHING")
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATCHING_ID")
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "BENEFICIARY_ID")
    private Person beneficiary;
    // private Long beneficiaryId;

    @ManyToOne
    @JoinColumn(name = "DONATOR_ID")
    private Person donator;
    // private Long donatorId;

    @ManyToOne
    @JoinColumn(name = "TALENT_ID")
    private Talent talent;

    public Match() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Person beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Person getDonator() {
        return donator;
    }

    public void setDonator(Person donator) {
        this.donator = donator;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    
    
}
