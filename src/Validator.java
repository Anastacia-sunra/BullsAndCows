import java.util.HashSet;
import java.util.Set;
;

public class Validator {

    // метод выбрасывает исключения, если строка не соответствует формату
    public static char[] validateString(String s) throws ValidationException{

        if (s.length() != 4){
            throw new ValidationException(ValidationException.WRONG_LENGTH);
        }
        //перевожу введенную строку в массив символов
        char[] guess = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c: guess){
            //Character.isDigit(c) статический метод
            if (!Character.isDigit(c)){
                throw new ValidationException(ValidationException.NOT_ONLY_DIGITS);
            }
            set.add(c);
        }
        if (set.size() != 4){
            throw new ValidationException(ValidationException.REPEATING_DIGITS);
        }

        return guess;
    }
}
