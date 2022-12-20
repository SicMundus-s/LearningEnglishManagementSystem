package mirea.example.learningenglishmanagementsystem.models;

// ToDo Как записать в БД два перевода слова?
// ToDo ?Записывать неправильно отвеченные слова в отдельную таблицу для дальнейшего интервального повторения?
// ToDo Добавить поле boolean - ответил правильно/неправильно 1. Ответил правильно - слову ставится true, ответил неправильно - false
//  Тогда слово переходит в раздел интервального повторения

import lombok.*;
import mirea.example.learningenglishmanagementsystem.dto.PopularWordsDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "words")
@NamedNativeQuery(name = "FindPopularWordsDTO", query = "select w.id, w.word, w.translate, count(d.word_id) as countRepetitionsOfWordsFromUsers " +
        "from dictionary d left join words w on d.word_id = w.id " +
        "group by w.id, w.word, w.translate " +
        "order by countRepetitionsOfWordsFromUsers desc " +
        "LIMIT 1000",
        resultSetMapping = "PopularWordsDTO")
@SqlResultSetMapping(
        name = "PopularWordsDTO",
        classes = {
                @ConstructorResult(
                        targetClass = PopularWordsDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "word", type = String.class),
                                @ColumnResult(name = "translate", type = String.class),
                                @ColumnResult(name = "countRepetitionsOfWordsFromUsers", type = Integer.class )
                        }
                )
        }
)
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String word;

    private String translate;

    @ManyToMany(mappedBy = "words",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> users;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "categories_words",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "word_id", referencedColumnName = "id"))
    private Set<Categories> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (id != word1.id) return false;
        if (word != null ? !word.equals(word1.word) : word1.word != null) return false;
        return translate != null ? translate.equals(word1.translate) : word1.translate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (translate != null ? translate.hashCode() : 0);
        return result;
    }


}
