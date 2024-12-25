package factorybean;

import domain.QuestionBook;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import service.QuestionBookService;

@AllArgsConstructor
public class QuestionBookFactoryBean extends AbstractFactoryBean<QuestionBook> {

    private QuestionBookService service;

    @Override
    public Class<QuestionBook> getObjectType() {
        return QuestionBook.class;
    }

    @Override
    protected QuestionBook createInstance() throws Exception {
        return new QuestionBook(service.loadQuestions());
    }
}
