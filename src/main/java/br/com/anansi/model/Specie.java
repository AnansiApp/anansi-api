package br.com.anansi.model;

public class Specie {

    public Specie(String name, String distribution, Boolean medicalImportance) {
        this.name = name;
        this.distribution = distribution;
        this.medicalImportance = medicalImportance;
    }

    private String name;
    private String distribution;
    private Boolean medicalImportance;

    public String getName() {
        return name;
    }

    public String getDistribution() {
        return distribution;
    }

    public Boolean getMedicalImportance() {
        return medicalImportance;
    }
}
