package mirea.example.learningenglishmanagementsystem.models;

// ToDo Как записать в БД два перевода слова?
// ToDo ?Записывать неправильно отвеченные слова в отдельную таблицу для дальнейшего интервального повторения?
// ToDo Добавить поле boolean - ответил правильно/неправильно 1. Ответил правильно - слову ставится true, ответил неправильно - false
//  Тогда слово переходит в раздел интервального повторения

import lombok.Data;

@Data
public class Word {
    private int id;
    private String word;
    private String[] wordTranslation;
    //private Boolean didTheUserTranslateCorrectly;
    //private User user;
}
