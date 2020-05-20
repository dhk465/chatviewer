package daehee;

//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

/**
 * The class divides a single message stub
 * into time, name and text and stores them.
 */

public class MessageToken {
//    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
//    private LocalTime timeRecorded;
    private String timeRecorded;
    private String username;
    private ArrayList<Object> messageText;

    public String getTimeRecorded() {
        return timeRecorded;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Object> getMessageText() {
        return messageText;
    }
}
