package mirea.example.learningenglishmanagementsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IntervalRepetition {

    @EmbeddedId
    private IntervalRepetitionKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @MapsId("wordId")
    @JoinColumn(name = "word_id", referencedColumnName = "id")
    private Word word;

    @Column(name = "count_correct_translation")
    private int countCorrectTranslation;

    @Column(name = "last_translation")
    private Date lastTranslation;
}
