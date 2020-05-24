package daehee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * The class provides a method to read a file text
 * and stores the whole message stub tokenized from
 * the class MessageToken.
 */

public class Message {

    private String text;
    private Tokenizer tokenizer;
    private ArrayList<Object> msgTokens = new ArrayList<>();

    /**
     * It reads the file and further processes it using iterateText().
     * @param file the file to extract the text from
     * @throws IncorrectFormatException an exception caught when the file does not have correct syntax
     */
    public void read(File file) throws IncorrectFormatException {
        try {
            text = Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.iterateText();
    }

    /**
     * It initializes a Tokenizer class to store string into message tokens
     * and further processes the CONTENTs of the message.
     * @throws IncorrectFormatException an exception caught when the file does not have correct syntax
     */
    private void iterateText() throws IncorrectFormatException {
        tokenizer = new Tokenizer();
        // first, tokenize each message stub into timestamp, nickname, content and "end of stub"
        msgTokens = tokenizer.tokenizeMessage(text);
        for (int i = 0; i < msgTokens.size(); i++) {
            if (i % 4 == 2) {
                // then tokenize each content into smiles and strings
                msgTokens.set(i, tokenizer.tokenizeContent(msgTokens.get(i)));
            }
        }
    }

    /**
     * It gives other classes public access to the msgTokens.
     * @return an array of message tokens
     */
    public ArrayList<Object> getMsgTokens() {
        return msgTokens;
    }
}
