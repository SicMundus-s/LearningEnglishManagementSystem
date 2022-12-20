package mirea.example.learningenglishmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PopularWordsDTO {

    private String word;

    private String translate;

    private Integer countRepetitionsOfWordsFromUsers;
}
