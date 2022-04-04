package dev.probono.probono.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.probono.probono.model.dto.MatchDTO;
import dev.probono.probono.service.MatchService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

    private final MatchService matchService;
    
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    
    @PostMapping()
    public void insertMatch(@RequestBody MatchDTO matchDTO) {
        System.out.println(matchDTO);
        matchService.insertMatch(matchDTO);
    }
}
