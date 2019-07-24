import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MessagePrinterTest {

    MessagePrinter messagePrinter = new ConsoleMessagePrinter();
    FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();

    @Test
    public void testPrintConsoleMessage() {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        assertEquals(messagePrinter.print("Print"), "Print");
    }


    @Test
    public void testPrintFileMessage() {
        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        assertEquals(fileMessagePrinter.print("Print"), "Print");
    }


    @Test
    public void testOnEqualsOtherClass() {
        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        assertEquals(messagePrinter.print("Print"), fileMessagePrinter.printMessage("Print"));
    }

}