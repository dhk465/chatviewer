package daehee;

//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;

/**
 * The class divides a single message stub
 * into time, name and text and stores them.
 */

public class MessageToken {

//    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
//    private LocalTime timeRecorded;
    private String timeRecorded;
    private String username;
    private String messageText;

    /**
     * for each line caught in Tokenizer,
     * the string is stored in the variable
     * depending on the type of the token
     */
    public void parseLine(Tokenizer tokenizer) {
        Tokens indicator = tokenizer.getIndicator();
        String token = tokenizer.getContext(indicator);
        switch (indicator) {
            case TIMESTAMP:
                // timeRecorded = LocalTime.parse(token, timeFormat);
                timeRecorded = token;
                break;
            case NICKNAME:
                username = token;
                break;
            case CONTENT:
                messageText = token;
                break;
            case EOL:
                System.out.println(timeRecorded + username + messageText);
                break;
        }
    }

}
