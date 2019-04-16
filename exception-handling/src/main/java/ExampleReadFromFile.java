import java.io.*;
import java.util.logging.Logger;

class ExampleReadFromFile {
    private String sourceExpression;
    private static final Logger logger = Logger.getGlobal();
    FileInputStream inputStream = null;

    public String exampleReadFile(String name) {
        try {
            inputStream = new FileInputStream(name);
            int i = -1;
            StringBuilder br = new StringBuilder();
            while ((i = inputStream.read()) != -1) {
                addItem(br, i);
            }
            sourceExpression = br.toString();
        } catch (FileNotFoundException exception) {
            //exception.getMessage();
            getFileNotFoundException(exception);
        } finally {
            try {
                if (inputStream != null)
                    closeStream(name);
            } catch (IOException ex) {
                logger.info("" + ex);
            }
            return sourceExpression;
        }
    }

    StringBuilder addItem(StringBuilder br, int i) {
        return br.append((char) i);
    }

    FileInputStream createStream(String name) {
        FileInputStream linkobject = null;
        try {
            linkobject = new FileInputStream(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return linkobject;
    }


    void closeStream(String name) throws IOException {
        createStream(name).close();
    }

    String getFileNotFoundException(FileNotFoundException ex) {
        return ex.toString();
    }

}
