package br.com.flightmanager.restapi;

import br.com.flightmanager.candidate.Candidate;
import br.com.flightmanager.candidate.CandidateFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("candidates")
public class CandidateController {

    private final CandidateFacade facade;

    @GetMapping(produces = "application/json" )
    public List<Candidate> getAllCandidates() {
        return facade.getAllCandidates();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Candidate save(@RequestBody Candidate candidate) {
        return facade.saveCandidate(candidate);
    }
}
