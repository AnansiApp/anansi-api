package br.com.anansi.model;

import javax.persistence.*;

@Entity
@Table(name = "RL_FAMILY_CHARACTERISTIC")
public class FamilyCharacteristic {


    @Id
    @Column(name = "CO_SEQ_FAMILY_CHARACTERISTIC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="CO_FAMILY", nullable = false)
    private Family family;

    @ManyToOne
    @JoinColumn(name = "CO_OPTION", nullable = false)
    private CharacteristicQuestion characteristic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public CharacteristicQuestion getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(CharacteristicQuestion characteristic) {
        this.characteristic = characteristic;
    }
}
