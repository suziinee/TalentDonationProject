package dev.probono.probono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.probono.probono.model.entity.Talent;

public interface TalentRepository extends JpaRepository<Talent, Long>{
    Talent getById(Long talentId);
}
