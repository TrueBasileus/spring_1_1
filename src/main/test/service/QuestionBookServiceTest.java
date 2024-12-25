package service;


import domain.Question;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class QuestionBookServiceTest {
    private QuestionBookService service;

    @BeforeEach
    public void setUp() {
        service = new QuestionBookService("/test.csv");
    }

    @Test
    @SneakyThrows
    public void testLoadQuestionsSuccess() {

        List<Question> list = service.loadQuestions();

        Assertions.assertEquals(2, list.size());

        Assertions.assertEquals("What is your name?", list.get(0).getTextQuestion());
        Assertions.assertEquals(3, list.get(0).getAnswers().size());
        Assertions.assertEquals("Alice", list.get(0).getAnswers().get(0).getTextAnswer());
        Assertions.assertEquals("Bob", list.get(0).getAnswers().get(1).getTextAnswer());
        Assertions.assertEquals("Charlie", list.get(0).getAnswers().get(2).getTextAnswer());

        Assertions.assertEquals("What is your favorite color?", list.get(1).getTextQuestion());
        Assertions.assertEquals(3, list.get(1).getAnswers().size());
        Assertions.assertEquals("Red", list.get(1).getAnswers().get(0).getTextAnswer());
        Assertions.assertEquals("Green", list.get(1).getAnswers().get(1).getTextAnswer());
        Assertions.assertEquals("Blue", list.get(1).getAnswers().get(2).getTextAnswer());
    }
}
