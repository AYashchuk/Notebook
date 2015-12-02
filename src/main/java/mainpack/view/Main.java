package mainpack.view;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.Locale;

/**
 * @author Yashchuk A.F.
 */
@Component
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mainpack/springnotes/transactionalContext.xml");
        MainFrame frame = context.getBean("mainFrame", MainFrame.class);
    }
}
