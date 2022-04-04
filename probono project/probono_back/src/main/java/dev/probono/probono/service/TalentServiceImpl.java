package dev.probono.probono.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.probono.probono.model.dto.TalentDTO;
import dev.probono.probono.model.entity.Talent;
import dev.probono.probono.repository.TalentRepository;

@Service
public class TalentServiceImpl implements TalentService {
    
    @Autowired
    private TalentRepository talentRepository;

    @Override
    public List<TalentDTO> getAllTalents() {
        List<Talent> list  = talentRepository.findAll();
        List<TalentDTO> result = list.stream().map(r -> new TalentDTO(r)).collect(Collectors.toList());
        
        return result;
    }
}
