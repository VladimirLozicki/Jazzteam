public abstract class MessagePrinter {

    MessagePrinter nextMessagePrinter;

    void setNextMessagePrinter(MessagePrinter messagePrinter) {
        nextMessagePrinter = messagePrinter;
    }

    String print(String message) {
        printMessage(message);
        if (nextMessagePrinter != null) {
            nextMessagePrinter.print(message);
            return nextMessagePrinter.print(message);
        }
        return message;
    }

    abstract String printMessage(String message);
}
