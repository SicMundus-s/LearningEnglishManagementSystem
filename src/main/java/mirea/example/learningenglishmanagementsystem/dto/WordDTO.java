package mirea.example.learningenglishmanagementsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class WordDTO {

    @Id
    private String word;

    private String translation;

}
