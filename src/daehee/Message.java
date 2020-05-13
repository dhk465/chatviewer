package daehee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * The class provides a method to read a file text
 * and stores the whole message stub tokenized from
 * the class MessageToken.
 */

public class Message {

    private String wholeText;
    private String[] lines;
    private Path msgPath;
    private ArrayList<MessageToken> msgArray = new ArrayList<>();
    private MessageToken messageToken;
    private Tokenizer tokenizer;

    /**
     * The constructor of a Message object takes a path of a file as an argument.
     * @param path a Path object of a file to get the message text from.
     */

    public Message(Path path) {
        this.msgPath = path;
    }

    /**
     * It reads strings from the text and stores line by line.
     * @throws IOException may occur when the file reader is interrupted or not permitted by the file system.
     */
    public void getTextFromFile() throws IOException {
        wholeText = Files.readString(msgPath);
        lines = wholeText.split(System.getProperty("line.separator"));
    }

    /**
     * It creates and stores the tokenized messages in an ArrayList of the Message object.
     */
    public void convertMsg() {
        messageToken = new MessageToken();
        for (String line : lines) {
            tokenizer = new Tokenizer(line);
            messageToken.parseLine(tokenizer);
            if (tokenizer.getIndicator() == Tokens.EOL) {
                msgArray.add(messageToken);
            }
        }
    }

    /**
     * It returns the path of the file.
     * @return a Path that was input during the instantiation of the object.
     */
    public Path getMsgPath() {
        return msgPath;
    }

}
