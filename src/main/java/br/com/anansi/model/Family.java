package br.com.anansi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_FAMILY")
public class Family {

    @Id
    @Column(name = "CO_SEQ_FAMILY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

//    @Column(name = "POPULAR_NAME")
//    private String popularName;
//
//    @Column(name = "HABIT_LIFE")
//    private String habitLife;
//
//    @Column(name = "SIZE")
//    private String size;
//
//    @Column(name = "EYES")
//    private String eyes;
//
//    @Column(name = "OTHER_CHARACTERISTICS")
//    private String othersCharacteristics;
//
//    @Column(name = "TIME_YEAR")
//    private String timeYear;

    @ElementCollection
    @CollectionTable(name= "TB_IMAGE_FAMILY", joinColumns = @JoinColumn(name = "CO_SEQ_FAMILY"))
    @Column(name = "ADDRESS")
    private List<String> families;

    @Column(name = "DISTRIBUTION", nullable = false)
    private String distribution;

    @Column(name = "MEDICAL_IMPORTANCE", nullable = false)
    private Boolean medicalImportance;

    @ElementCollection
    @CollectionTable(name= "TB_IMAGE_FAMILY", joinColumns = @JoinColumn(name = "CO_SEQ_FAMILY"))
    @Column(name = "ADDRESS")
    private List<String> imageAddresses;


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

    public List<String> getImageAddresses() {
        return imageAddresses;
    }

    public void setImageAddresses(List<String> imageAddresses) {
        this.imageAddresses = imageAddresses;
    }
}
