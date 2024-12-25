package domain;

import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class QuestionBook {
    private List<Question> questions;

    public void print() {
        questions.forEach(System.out::println);
    }

}
