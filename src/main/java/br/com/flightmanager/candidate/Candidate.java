package br.com.flightmanager.candidate;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "candidate", schema = "fm")
@SequenceGenerator(sequenceName = "seq_flight", schema = "fm", name = "CANDIDATE_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Candidate {

    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANDIDATE_SEQUENCE")
    @Column(name = "id_candidate")
    private Long id;

    @Column
    private String name;

    @Column
    private Long age;

    @Column
    private Long distance;

    @Column
    private String description;

    @Column
    private String insta;

    @Column
    private String whats;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<CandidatePhoto> photos;

    private Candidate () {
    }

    public String toString() {
        return "Nome: " + name;
    }

    public void adjustAssociatedIndexes() {
        for (CandidatePhoto candidatePhoto : photos) {
            candidatePhoto.setCandidate(this);
        }
    }
}
