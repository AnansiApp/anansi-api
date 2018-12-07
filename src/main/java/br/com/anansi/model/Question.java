package br.com.anansi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_QUESTION")
public class Question {

    @Id
    @Column(name = "CO_SEQ_QUESTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<CharacteristicQuestion> options;

    @Column(name = "FIRST")
    private Boolean first;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CharacteristicQuestion> getOptions() {
        return options;
    }

    public void setOptions(List<CharacteristicQuestion> options) {
        this.options = options;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
