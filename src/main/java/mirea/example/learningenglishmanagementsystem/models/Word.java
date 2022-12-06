package mirea.example.learningenglishmanagementsystem.models;

// ToDo Как записать в БД два перевода слова?
// ToDo ?Записывать неправильно отвеченные слова в отдельную таблицу для дальнейшего интервального повторения?
// ToDo Добавить поле boolean - ответил правильно/неправильно 1. Ответил правильно - слову ставится true, ответил неправильно - false
//  Тогда слово переходит в раздел интервального повторения

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String word;

    private String translate;

    @OneToOne(mappedBy = "popularWordId")
    private User user;

    //private Boolean didTheUserTranslateCorrectly;

}
