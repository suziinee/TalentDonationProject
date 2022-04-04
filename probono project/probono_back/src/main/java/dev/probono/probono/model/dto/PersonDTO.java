package dev.probono.probono.model.dto;

import dev.probono.probono.model.entity.Person;

public class PersonDTO {
    
    private Long id;
    private String name;
    private String email;
    private Long benefit;
    private Long donation;

    

    public PersonDTO() {}

    public PersonDTO(Person person) {
        
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.benefit = person.getBenefit();
        this.donation = person.getDonation();
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBenefit() {
        return benefit;
    }

    public void setBenefit(Long benefit) {
        this.benefit = benefit;
    }

    public Long getDonation() {
        return donation;
    }

    public void setDonation(Long donation) {
        this.donation = donation;
    }

    
}
