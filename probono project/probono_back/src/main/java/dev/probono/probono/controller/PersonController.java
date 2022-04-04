package dev.probono.probono.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.probono.probono.model.dto.PersonDTO;
import dev.probono.probono.service.PersonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/persons")
public class PersonController {
    
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public void insertPerson(@RequestBody PersonDTO personDTO) {
        System.out.println(personDTO);
        personService.insertPerson(personDTO);
    }

    @GetMapping()
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/id")
    public PersonDTO getOnePerson(@RequestParam Long personId) {

        return personService.getOnePerson(personId);
    }
    
    @GetMapping("/beneficiaries")
    public List<PersonDTO> getAllBeneficiaries() {
        return personService.getAllBeneficiaries();
    }
    
    @GetMapping("/donators")
    public List<PersonDTO> getAllDonators() {
        return personService.getAllDonators();
    }

    @GetMapping("/talent")
    public List<PersonDTO> getAllPersonsWithTalent(@RequestParam Long talentId) {
        return personService.getAllPersonsWithTalent(talentId);
    }

    @PatchMapping("/benefit/{id}")
    public void updateBenefit(@PathVariable(value="id") Long personId, @RequestBody PersonDTO personDTO) {
        personService.updateBenefit(personId, personDTO);
    }

    @PatchMapping("/donation/{id}")
    public void updateDonation(@PathVariable(value="id") Long personId, @RequestBody PersonDTO personDTO) {
        personService.updateDonation(personId, personDTO);
    }




}
