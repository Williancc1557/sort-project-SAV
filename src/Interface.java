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
                System.out.println("*".repeat(elementChar - 64));
            }
        }
        System.out.println("----------------------------------------------");
    }
}
