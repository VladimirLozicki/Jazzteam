import java.io.*;
import java.util.logging.Logger;

class ReadToFile {
    private String sourceExpression;
    private static final Logger logger = Logger.getGlobal();

    public String ReadToFile(String name) throws Exception {
        FileInputStream inputStream = null;
        try {
            getSourceExpression(inputStream, name);
        } catch (FileNotFoundException exception) {
            logger.info("FileNotFound" + exception);
        } catch (IOException ex) {
            logger.info("exception" + ex);
        } catch (Exception exception) {
            if (inputStream == null) {
                throw new Exception("file empty");
            }
        } finally {
            try {
                if (inputStream != null)
                    closeStream(name);
            } catch (IOException ex) {
                //System.out.println(ex.getMessage());
                logger.info("" + ex);
            }
        }
        return sourceExpression;
    }
    String getSourceExpression(FileInputStream inputStream, String name) throws IOException {
        inputStream = new FileInputStream(name);
        int i = -1;
        StringBuilder br = new StringBuilder();
        while ((i = inputStream.read()) != -1) {
            addItem(br, i);
        }
        return sourceExpression = br.toString();
    }

    StringBuilder createStringBuilder() {
        StringBuilder br = new StringBuilder();
        return br;
    }

    StringBuilder addItem(StringBuilder br, int i) {
        return br.append((char) i);
    }

    String returnInputExpression() {
        return sourceExpression;
    }

    FileInputStream createStream(String name) throws FileNotFoundException {
        FileInputStream linkobject = new FileInputStream(name);
        return linkobject;
    }

    FileInputStream closeStream(String name) throws IOException {
        createStream(name).close();
        return null;
    }
}
