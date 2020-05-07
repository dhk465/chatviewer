package daehee;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MessageToken {

    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalTime timeRecorded;
    private String username;
    private String messageText;

    public void parseLine(Tokenizer tokenizer) throws Exception {
        Tokens indicator = tokenizer.getIndicator();
        String token = tokenizer.getContext(indicator);
        switch (indicator) {
            case TIMESTAMP:
                timeRecorded = LocalTime.parse(token, timeFormat);
                break;
            case NICKNAME:
                username = token;
                break;
            case CONTENT:
                messageText = token;
                break;
            case EOL:
                break;
        }
    }

}
