package br.com.flightmanager.candidate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Table(name = "candidate_photo", schema = "fm")
@SequenceGenerator(sequenceName = "seq_candidate_photo", schema = "fm", name = "CANDIDATE_PHOTO_SEQUENCE", initialValue = 1, allocationSize = 1)
public class CandidatePhoto {

    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANDIDATE_PHOTO_SEQUENCE")
    @Column(name = "id_candidate_photo")
    private Long id;

    @Column
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    @JsonIgnore
    private Candidate candidate;

    private CandidatePhoto() {
    }
}
