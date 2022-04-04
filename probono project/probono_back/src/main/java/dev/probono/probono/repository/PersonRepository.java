package dev.probono.probono.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.probono.probono.model.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
    List<Person> findByBenefitNotNull();
    List<Person> findByDonationNotNull();
    List<Person> findByBenefitOrDonation(Long talentId1, Long talentId2);
}
