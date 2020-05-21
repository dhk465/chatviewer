package daehee;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class prepares a message to tokenize into different types.
 */
public class Tokenizer {

    /**
     * It checks for the front substring of a line
     * and returns the rest of the string after colon (:)
     * if the front substring matches any of the Indicators
     * otherwise throws an exception for a wrong input file.
     */
    public ArrayList<Object> tokenizeMessage(String text) throws IncorrectFormatException {
        ArrayList<Object> arrayList = new ArrayList<>();
        // limit -1 on split() makes it recognize all trailing line separators
        // therefore taking empty strings from the end of any msg files
        String[] splitText = text.split(System.getProperty("line.separator"), -1);
        if (checkValidity(splitText)) {
            for (String line : splitText) {
                if (line.startsWith("Time:")) {
                    arrayList.add(line.substring(5));
                }
                if (line.startsWith("Name:")) {
                    arrayList.add(line.substring(5));
                }
                if (line.startsWith("Message:")) {
                    arrayList.add(line.substring(8));
                }
                if (line.isEmpty()) {
                    arrayList.add("");
                }
            }
        } else {
            throw new IncorrectFormatException("Text Format Is Incorrect.");
        }
        return arrayList;
    }

    /**
     * It tokenizes a single line of message into texts and smiles.
     * @param stringObj the input string representing CONTENT that has been tokenized from a message text
     * @return ArrayList of texts and smiles to be displayed in a TextFlow
     */
    public ArrayList<Object> tokenizeContent(Object stringObj) {
        String line = (String)stringObj;
        ArrayList<Object> objList = new ArrayList<>();
        // previousIndex represents the index of the previous smile to pinpoint the substring between smiles
        int previousIndex = 0;
        for (int i = 0; i < line.length(); i++) {
            if (previousIndex >= line.length()) {
                break;
            }
            String substr = line.substring(previousIndex, i + 1);
            // if the iteration encounters happy smiley characters,
            if (line.charAt(i) == ':' && line.charAt(i+1) == ')') {
                // if the substring in front of smile is not empty, store the substring
                if (!substr.equals("")) {
                    if (substr.length() > 1) {
                        objList.add(substr.substring(0, substr.length() - 1));
                    }
                    previousIndex = i++ + 2;
                }
                // store the smile
                objList.add(new Smile(i, ":)"));
                continue;
            }
            // sad smiley
            if (line.charAt(i) == ':' && line.charAt(i+1) == '(') {
                if (!substr.equals("")) {
                    if (substr.length() > 1) {
                        objList.add(substr.substring(0, substr.length() - 1));
                    }
                    previousIndex = i ++ + 2;
                }
                objList.add(new Smile(i, ":("));
                continue;
            }
            if (i == line.length() - 1) {
                objList.add(substr);
            }
        }
        return objList;
    }

    /**
     * It checks if the message has a valid format to continue with tokenization.
     * @param splitText an array of strings split from a message text by line separator
     * @return true or false depending on the legitimacy of the format
     */
    private boolean checkValidity(String[] splitText) {
        boolean validity = true;
        int i = 0;
        // runs while the format is correct and there is any line to assess
        while (validity && i < splitText.length) {
            switch (i % 4) {
                // proof-read all timestamp, nickname, content and 'end of message' lines
                case 0:
                    validity = splitText[i].startsWith("Time:");
                    i++;
                    break;
                case 1:
                    validity = splitText[i].startsWith("Name:");
                    i++;
                    break;
                case 2:
                    validity = splitText[i].startsWith("Message:");
                    i++;
                    break;
                case 3:
                    validity = splitText[i].isEmpty();
                    i++;
                    break;
            }
        }
        // if there is a faulty line, the loop stops and returns false
        // if everything is fine, it returns true
        return validity;
    }
}