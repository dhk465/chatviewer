package daehee;

/**
 * a class that encompasses the file exceptions
 * which are bound to occur during the use of the application
 */

public class InvalidFileException extends Exception {
    public InvalidFileException(String error) {
        super(error);
    }
}

/**
 * The file to process contains text whose format/syntax is not allowed.
 */
class IncorrectFormatException extends InvalidFileException {
    public IncorrectFormatException (String error) {
        super(error);
    }
}

/**
 * The file to process does not exist.
 */
class FileNotFoundException extends InvalidFileException {
    public FileNotFoundException (String error) {
        super(error);
    }
}