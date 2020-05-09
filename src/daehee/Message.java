package daehee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static daehee.Tokens.*;

public class Message {

    private String wholeText;
    private String[] lines;
    private Path msgPath;
    private ArrayList<MessageToken> msgArray;
    private MessageToken messageToken;
    private Tokenizer tokenizer;

    public Message(Path path) {
        this.msgPath = path;
    }

    public void getTextFromFile() throws IOException {
        wholeText = Files.readString(msgPath);
        lines = wholeText.split(System.getProperty("line.separator"));
    }

    // tokenize and store a single message containing information about time, user and message content
    public void convertMsg() {
        messageToken = new MessageToken();
        for (String line : lines) {
            tokenizer = new Tokenizer(line);
            messageToken.parseLine(tokenizer);
            if (tokenizer.getIndicator() == EOL) {
                msgArray.add(messageToken);
            }
        }
    }

    public Path getMsgPath() {
        return msgPath;
    }

}
