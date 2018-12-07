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

    @Column(name = "POPULAR_NAME")
    private String popularName;

    @Column(name = "HABIT_LIFE", columnDefinition="TEXT")
    private String habitLife;

    @Column(name = "BODY_SIZE")
    private String size;

    @Column(name = "EYES",  columnDefinition="TEXT")
    private String eyes;

    @Column(name = "OTHER_CHARACTERISTICS", columnDefinition="TEXT")
    private String othersCharacteristics;

    @Column(name = "TIME_YEAR")
    private String timeYear;

    @Column(name = "MEDICAL_IMPORTANCE", columnDefinition="TEXT")
    private String medicalImportance;

    @ElementCollection
    @CollectionTable(name= "TB_IMAGE_FAMILY", joinColumns = @JoinColumn(name = "CO_SEQ_FAMILY"))
    @Column(name = "ADDRESS")
    private List<String> imageAddresses;

    private String principalImage;

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

    public String getMedicalImportance() {
        return medicalImportance;
    }

    public void setMedicalImportance(String medicalImportance) {
        this.medicalImportance = medicalImportance;
    }

    public List<String> getImageAddresses() {
        return imageAddresses;
    }

    public String getPrincipalImage(){
        for (String address :
                imageAddresses) {
            if(address.contains("P.jpg")){
                this.principalImage = address;
            }
        }
        return  principalImage;
    }

    public void setImageAddresses(List<String> imageAddresses) {
        this.imageAddresses = imageAddresses;
    }

    public String getPopularName() {
        return popularName;
    }

    public void setPopularName(String popularName) {
        this.popularName = popularName;
    }

    public String getHabitLife() {
        return habitLife;
    }

    public void setHabitLife(String habitLife) {
        this.habitLife = habitLife;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getOthersCharacteristics() {
        return othersCharacteristics;
    }

    public void setOthersCharacteristics(String othersCharacteristics) {
        this.othersCharacteristics = othersCharacteristics;
    }

    public String getTimeYear() {
        return timeYear;
    }

    public void setTimeYear(String timeYear) {
        this.timeYear = timeYear;
    }

}


