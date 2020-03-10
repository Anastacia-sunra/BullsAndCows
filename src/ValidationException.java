public class ValidationException extends Exception {

public static final String WRONG_LENGTH = "Wrong string length";
public static final String NOT_ONLY_DIGITS = "It must contain only digits";
public static final String REPEATING_DIGITS = "Repeating digits are not allowed";

    //конструктор
public ValidationException(String message) {
        super(message);
    }
}
