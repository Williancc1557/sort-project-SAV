package Interfaces;

public class TerminalInterface<T> implements Interface<T> {
    public void showStep(T[] array, int step, double miliSeconds) {
        System.out.println("------------------ STEP " + step + " -------------------");
        for (T element : array) {
            System.out.print(element + ":  ");
            try {
                int elementInt = (int) element;
                System.out.println("*".repeat(Math.max(elementInt, 0)));
            } catch (ClassCastException err){
                char elementChar = (char) element;
                System.out.println("*".repeat(elementChar - 64));
            }
        }
        System.out.println("----------------------------------------------");
    }
}
