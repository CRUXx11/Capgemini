package assignments.assignment2;

import assignments.assignment2.classes.Question;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:src/main/java/assignments/assignment2/assignment2-config.xml");
        Question question1 = applicationContext.getBean("question1", Question.class);

        System.out.println();
        System.out.println("Calling Bean : Question1..");
        System.out.println("Question Id: "+question1.getQuestionId());
        System.out.println("Question : "+question1.getQuestion());
        System.out.println("Answer List : "+question1.getAnswerList().toString());
        System.out.println("Answer Set : "+question1.getAnswerSet().toString());
        System.out.println("Answer Map : "+question1.getAnswerMap().toString());

    }

}
