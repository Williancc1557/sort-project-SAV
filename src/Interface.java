import java.util.Arrays;

public abstract class Interface <T> {
    public void showStep(T[] array, int step) {
        System.out.println("------------------ STEP " + step + " -------------------");
        for (T element : array) {
            System.out.print(element + ":  ");
            try {
                System.out.println("*".repeat((int) element));
            } catch (ClassCastException err){
                char elementChar = (char) element;
                System.out.println("*".repeat(elementChar - decreaseCharElement(elementChar)));
            }
        }
        System.out.println("----------------------------------------------");
    }

    public int decreaseCharElement(char letter) {
        if (letter > 64 && letter < 91) return 64;
        else if (letter > 96 && letter < 123) return 96;
        throw new RuntimeException("Invalid char");
    }
}
