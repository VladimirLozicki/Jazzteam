package prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.logging.Logger;


public class MessagePrototypeTest {

    private static final Logger logger = Logger.getGlobal();

    @Autowired
    private MessagePrototype message;

    @Autowired
    private MessagePrototype newMessage;

    @Test
    public void testGetMessage() {

        ApplicationContext context =
                new FileSystemXmlApplicationContext("classpath:message-bean.xml");
        message = (MessagePrototype) context.getBean("printMessagePrototype");
        message.setMessage("This is first object.");
        newMessage = (MessagePrototype) context.getBean("printMessagePrototype");
        logger.info(message.getMessage());
        logger.info(newMessage.getMessage());
    }
}