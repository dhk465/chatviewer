package daehee;

/**
 * The class defines the range and types of tokens.
 */

public abstract class Token {

    public abstract Tokens getType();

}

enum Tokens {
    TIMESTAMP,
    NICKNAME,
    CONTENT,
    EOL,
    EOI
}

class TimeToken extends Token {

    @Override
    public Tokens getType() {
        return Tokens.TIMESTAMP;
    }

}

class NameToken extends Token {

    @Override
    public Tokens getType() {
        return Tokens.NICKNAME;
    }

}

class ContentToken extends Token {

    @Override
    public Tokens getType() {
        return Tokens.CONTENT;
    }

}

class EOLToken extends Token {

    @Override
    public Tokens getType() {
        return Tokens.EOL;
    }

}

class EOIToken extends Token {

    @Override
    public Tokens getType() {
        return Tokens.EOI;
    }

}