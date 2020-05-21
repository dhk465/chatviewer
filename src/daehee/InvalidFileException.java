package daehee;

public class InvalidFileException extends Exception {
    public InvalidFileException(String error) {
        super(error);
    }
}

class IncorrectFormatException extends InvalidFileException {
    public IncorrectFormatException (String error) {
        super(error);
    }
}

class FileNotFoundException extends InvalidFileException {
    public FileNotFoundException (String error) {
        super(error);
    }
}