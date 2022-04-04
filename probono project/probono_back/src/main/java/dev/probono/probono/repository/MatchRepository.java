package dev.probono.probono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.probono.probono.model.entity.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{
    
}
