package assignments.assignment7;

import assignments.assignment7.classes.BookRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test7 {

    public static void main(String[] args) {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(assignment7Config.class);
            BookRecord bookRecord = context.getBean("bookRecord1", BookRecord.class);
            System.out.println();
            System.out.println("BookID : "+bookRecord.getBookId());
            System.out.println("BookName : "+bookRecord.getBookName());
            System.out.println("BookPrice : Rs "+bookRecord.getBookPrice());
            System.out.println();
            Expression expression = new SpelExpressionParser().parseExpression("9*2-(2^3)+100");
            Long value = expression.getValue(Long.class);
            System.out.println("Value By ExpressionParser : "+value);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
