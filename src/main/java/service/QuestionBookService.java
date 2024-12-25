package service;

import domain.Answer;
import domain.Question;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class QuestionBookService {
    String path;

    public List<Question> loadQuestions() throws IOException {
        List<Question> result = new ArrayList<>();
        try (InputStream input = getClass().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String question = parts[0];
                List<Answer> answers = Arrays.stream(parts)
                        .filter(str -> !str.contains("?"))
                        .map(Answer::new)
                        .collect(Collectors.toList());
                Question questionObj = new Question(question, answers);
                result.add(questionObj);
            }
        }
        return result;
    }

}
