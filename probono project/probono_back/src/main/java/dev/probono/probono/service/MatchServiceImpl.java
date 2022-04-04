package dev.probono.probono.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.probono.probono.model.entity.Talent;
import dev.probono.probono.model.dto.MatchDTO;
import dev.probono.probono.model.entity.Match;
import dev.probono.probono.model.entity.Person;
import dev.probono.probono.repository.MatchRepository;
import dev.probono.probono.repository.PersonRepository;
import dev.probono.probono.repository.TalentRepository;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    TalentRepository talentRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public void insertMatch(MatchDTO matchDTO) {

        Talent talent = talentRepository.getById(matchDTO.getTalentId());
        Person beneficiary = personRepository.getById(matchDTO.getBeneficiaryId());
        Person donator = personRepository.getById(matchDTO.getDonatorId());
        
        Match match = new Match();

        match.setBeneficiary(beneficiary);
        match.setDonator(donator);
        match.setTalent(talent);

        matchRepository.save(match);
    }
}
