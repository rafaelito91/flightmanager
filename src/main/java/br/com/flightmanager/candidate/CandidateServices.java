package br.com.flightmanager.candidate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidateServices {

    private final CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate saveCandidate(Candidate candidate) {
        candidate.adjustAssociatedIndexes();
        return candidateRepository.save(candidate);
    }
}
