package mirea.example.learningenglishmanagementsystem.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class IntervalRepetitionKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "word_id")
    Long wordId;
}
