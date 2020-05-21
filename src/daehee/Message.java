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

    public void read(File file) throws IncorrectFormatException {
        tokenizer = new Tokenizer();
        try {
            text = Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.iterateText();
    }

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

    public ArrayList<Object> getMsgTokens() {
        return msgTokens;
    }
}
