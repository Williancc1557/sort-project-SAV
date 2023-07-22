import java.util.Arrays;

public abstract class Interface <T> {
    public void showStep(T[] array, int step) {
        System.out.println(Arrays.toString(array));
        System.out.println(step);
    }
}
