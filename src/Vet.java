import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vet {
    private List<char[]> variants = new ArrayList<>();
    {
        for(int i = 100; i < 10000; i++) {
            String number = String.valueOf(i);
            if (i < 1000) {
                number = "0" + number;
            }
            try {
                char[] code = Validator.validateString(number);
                variants.add(code);
            } catch (ValidationException e) {
                continue;
            }
        }
    }

    public void deleteWrong(char[] last, Herd herd){
        //создаем копию листа
        List<char[]> copy = new ArrayList<>(variants);
        for(char[] c: copy){
            if (!isPossible(c, last, herd)){
                variants.remove(c);
            }
        }
        System.out.println("Number of left variants: " + variants.size());
    }

    private boolean isPossible(char[] c, char[] last, Herd herd) {
        Shepherd shepherd = new Shepherd(c);
        if(herd.equals(shepherd.countHerd(last))){
            return true;
        }
        return false;
    }

    public List<char[]> getVariants() {
        return variants;
    }

    public char[] guessCode(){
        Random random = new Random();
        int rnd = random.nextInt(variants.size());
        return variants.get(rnd);
    }
}
