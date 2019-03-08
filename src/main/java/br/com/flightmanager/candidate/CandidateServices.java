package br.com.flightmanager.candidate;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidateServices {

    private final CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return IterableUtils.toList(candidateRepository.findAll());
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}
