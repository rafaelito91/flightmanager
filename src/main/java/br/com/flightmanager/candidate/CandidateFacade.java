package br.com.flightmanager.candidate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class CandidateFacade {

    private final CandidateServices candidateService;

    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @Transactional
    public Candidate saveCandidate(Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }
}
