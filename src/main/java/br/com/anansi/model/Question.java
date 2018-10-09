package br.com.anansi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_QUESTION")
public class Question {

    @Id
    @Column(name = "CO_SEQ_QUESTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
