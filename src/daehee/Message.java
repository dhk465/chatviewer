package daehee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Message {

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    private String wholeText;
    private Date timeRecorded;
    private String username;
    private String messageText;
    private Path msgPath;

    public Message(Path path) {
        this.msgPath = path;
    }

    private void parseText(Path path) throws IOException {
        wholeText = Files.readString(path);
    }

    public Date getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(Date timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}