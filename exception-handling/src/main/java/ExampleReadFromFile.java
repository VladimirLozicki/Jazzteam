
import java.io.*;
import java.util.logging.Logger;

class ExampleReadFromFile {
    private String sourceExpression;
    private static final Logger logger = Logger.getGlobal();
    FileInputStream inputStream = null;

    public String exampleReadFile(File name) {
        try {
            inputStream = new FileInputStream(name);

            int i = -1;
            StringBuilder br = new StringBuilder();
            while ((i = inputStream.read()) != -1) {
                br.append((char) i);
            }
            sourceExpression = br.toString();
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException();
        } catch (IOException exception) {
            exception.getMessage();
        } finally {
            try {
                if (inputStream != null)
                    createStream(name).close();

            } catch (IOException ex) {
                logger.info("" + ex);
            }
            return sourceExpression;
        }
    }

    FileInputStream createStream(File name) throws FileNotFoundException {
        FileInputStream linkobject = null;
        try {
            linkobject = new FileInputStream(name);
        } catch (NullPointerException ex) {
            ex.getMessage();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        return linkobject;
    }

}
