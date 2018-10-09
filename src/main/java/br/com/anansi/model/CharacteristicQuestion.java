package br.com.anansi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CHARACTERISTIC_QUESTION")
public class CharacteristicQuestion {

    @Id
    @Column(name = "CO_SEQ_OPTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CO_QUESTION")
    private Question question;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
