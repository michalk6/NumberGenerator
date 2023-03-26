package pl.lotto.winningnumbergenerator;

class NoSuchDrawException extends RuntimeException {
    public NoSuchDrawException(String message) {
        super(message);
    }
}
