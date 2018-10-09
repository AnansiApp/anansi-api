package br.com.anansi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_SPECIE")
public class Specie {

    @Id
    @Column(name = "CO_SEQ_SPECIE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DISTRIBUTION", nullable = false)
    private String distribution;

    @Column(name = "MEDICAL_IMPORTANCE", nullable = false)
    private Boolean medicalImportance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public Boolean getMedicalImportance() {
        return medicalImportance;
    }

    public void setMedicalImportance(Boolean medicalImportance) {
        this.medicalImportance = medicalImportance;
    }
}
