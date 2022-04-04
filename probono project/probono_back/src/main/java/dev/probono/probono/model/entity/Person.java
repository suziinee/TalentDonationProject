package dev.probono.probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERSON_ID")
    private Long id;

    @Column
    private String name;
    
    private String email;

    private Long benefit;

    private Long donation;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email, Long benefit, Long donation) {
        this.name = name;
        this.email = email;
        this.benefit = benefit;
        this.donation = donation;
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
