package daehee;

// prepares a line to tokenize into different types
public class Tokenizer {

    private String line;

    public Tokenizer(String line) {
        this.line = line;
    }

    // checks for the front substring of a line
    // and returns the rest of the string after colon (:)
    // if the front substring matches any of the Indicators
    // otherwise throws an exception for a wrong input file
    public Tokens getIndicator() {
        Tokens ind = Tokens.EOI;
        if (line.trim().isEmpty()) {
            ind = Tokens.EOL;
        } else {
            if (line.startsWith("Time")) {
                ind = Tokens.TIMESTAMP;
            }
            if (line.startsWith("Name")) {
                ind = Tokens.NICKNAME;
            }
            if (line.startsWith("Message")) {
                ind = Tokens.CONTENT;
            }
        }
        return ind;
    }

    // checks if the indicator is equivalent to any of Tokens
    // and returns the rest of the string after colon (:)
    public String getContext(Tokens indicator) {
        if (indicator == Tokens.TIMESTAMP || indicator == Tokens.NICKNAME) {
            return line.substring(5);
        } else if (indicator == Tokens.CONTENT) {
            return line.substring(8);
        } else {
            return "";
        }
    }

    public void setLine(String line) {
        this.line = line;
    }
}