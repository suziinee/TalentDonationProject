package dev.probono.probono.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.probono.probono.model.entity.Person;
import dev.probono.probono.model.entity.Talent;
import dev.probono.probono.model.dto.PersonDTO;
import dev.probono.probono.repository.PersonRepository;
import dev.probono.probono.repository.TalentRepository;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    PersonRepository personRepository;

    @Autowired
    TalentRepository talentRepository;

    @Override
    public void insertPerson(PersonDTO personDTO) {

        Person person = new Person();
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        person.setBenefit(personDTO.getBenefit());
        person.setDonation(personDTO.getDonation());

        personRepository.save(person);
        
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        
        List<Person> list  = personRepository.findAll();
        List<PersonDTO> result = list.stream().map(r -> new PersonDTO(r)).collect(Collectors.toList());
        
        return result;
    }


    @Override
    public PersonDTO getOnePerson(Long personId) {

        try{
            Person person = personRepository.getById(personId);
            PersonDTO result = new PersonDTO(person);

            return result;
        } catch(EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("올바른 아이디를 입력하세요.");
            return null;
        }
        
    }

    @Override
    public List<PersonDTO> getAllBeneficiaries() {

        List<Person> list = personRepository.findByBenefitNotNull();
        List<PersonDTO> result = list.stream().map(r -> new PersonDTO(r)).collect(Collectors.toList());
        
        return result;
    }

    @Override
    public List<PersonDTO> getAllDonators() {

        List<Person> list = personRepository.findByDonationNotNull();
        List<PersonDTO> result = list.stream().map(r -> new PersonDTO(r)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<PersonDTO> getAllPersonsWithTalent(Long talentId) {

        Talent talent = talentRepository.getById(talentId);
        List<Person> list = personRepository.findByBenefitOrDonation(talent.getId(), talent.getId());
        List<PersonDTO> result = list.stream().map(r -> new PersonDTO(r)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void updateBenefit(Long personId, PersonDTO personDTO) {
        Person person = personRepository.getById(personId);
        person.setBenefit(personDTO.getBenefit());
        
        personRepository.save(person);
    }

    @Override
    public void updateDonation(Long personId, PersonDTO personDTO) {
        Person person = personRepository.getById(personId);
        person.setDonation(personDTO.getDonation());
        
        personRepository.save(person);
    }

}
