package singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.*;

public class MessageTest {

    private static final Logger logger = Logger.getGlobal();

    @Autowired
    private Message message;

    @Autowired
    private Message newMessage;

    @Test
    public void testGetMessage() {

        ApplicationContext context =
                new FileSystemXmlApplicationContext("classpath:message-bean.xml");

        message = (Message) context.getBean("printMessage");
        message.setMessage("This is first object.");

        logger.info(message.getMessage());
        newMessage = (Message) context.getBean("printMessage");
        logger.info(newMessage.getMessage());
    }
}