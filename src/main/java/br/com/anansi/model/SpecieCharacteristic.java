package br.com.anansi.model;

import javax.persistence.*;

@Entity
@Table(name = "RL_SPECIE_CHARACTERISTIC")
public class SpecieCharacteristic {


    @Id
    @Column(name = "CO_SEQ_SPECIE_CHARACTERISTIC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="CO_SPECIE", nullable = false)
    private Specie specie;

    @ManyToOne
    @JoinColumn(name = "CO_OPTION", nullable = false)
    private CharacteristicQuestion characteristic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public CharacteristicQuestion getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(CharacteristicQuestion characteristic) {
        this.characteristic = characteristic;
    }
}
