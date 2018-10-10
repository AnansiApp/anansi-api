package br.com.anansi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_NEXT_QUESTION")
public class NextQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID_NEXT_QUESTION")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CO_CURRENT_QUESTION")
    private Question currentQuestion;

    @ManyToOne
    @JoinColumn(name = "CO_RESPONSE")
    private CharacteristicQuestion response;

    @ManyToOne
    @JoinColumn(name = "CO_NEXT_QUESTION")
    private Question nextQuestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public CharacteristicQuestion getResponse() {
        return response;
    }

    public void setResponse(CharacteristicQuestion response) {
        this.response = response;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }
}
