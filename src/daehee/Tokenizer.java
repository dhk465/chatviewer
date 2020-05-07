package daehee;

// prepares a line to tokenize into different types
public class Tokenizer {

    private final String line;

    public Tokenizer(String line) {
        this.line = line;
    }

    // checks for the front substring of a line
    // and returns the rest of the string after colon (:)
    // if the front substring matches any of the Indicators
    // otherwise throws an exception for a wrong input file
    public Tokens getIndicator() throws Exception {
        String nextStr = line.substring(0, 1);
        if (nextStr.equals("\n")) {
            return Tokens.EOL;
        } else {
            nextStr = line.substring(0, 5);
            if(nextStr.equals(Indicators.Time.toString())) {
                return Tokens.TIMESTAMP;
            } else if (nextStr.equals(Indicators.Name.toString())) {
                return Tokens.NICKNAME;
            } else {
                nextStr = line.substring(0, 7);
                if (nextStr.equals(Indicators.Message.toString())) {
                    return Tokens.CONTENT;
                } else {
                    throw new Exception();
                }
            }
        }
    }

    // checks if the indicator is equivalent to any of Tokens
    // and returns the rest of the string after colon (:)
    public String getContext(Tokens indicator) {
        if (indicator == Tokens.TIMESTAMP || indicator == Tokens.NICKNAME) {
            return line.substring(6);
        } else if (indicator == Tokens.CONTENT) {
            return line.substring(8);
        } else {
            return "";
        }
    }
}

enum Indicators {
    Time,
    Name,
    Message
}