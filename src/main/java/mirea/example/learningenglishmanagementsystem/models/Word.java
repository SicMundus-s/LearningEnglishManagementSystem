package mirea.example.learningenglishmanagementsystem.models;

// ToDo Как записать в БД два перевода слова?
// ToDo ?Записывать неправильно отвеченные слова в отдельную таблицу для дальнейшего интервального повторения?
// ToDo Добавить поле boolean - ответил правильно/неправильно 1. Ответил правильно - слову ставится true, ответил неправильно - false
//  Тогда слово переходит в раздел интервального повторения

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
public class Word {

    @Id
    private String word;

    private String translation;


    //private Boolean didTheUserTranslateCorrectly;
    //private User user;
}
