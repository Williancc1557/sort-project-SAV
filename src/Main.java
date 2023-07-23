import methodologies.BobbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(args));
        Integer[] array1 = {3, 2, 5, 4, 1};

        BobbleSort bobbleSort = new BobbleSort<>(array1);


        Character[] array2 = {'a', 'c', 'b', 'A', 'e'};

        BobbleSort bobbleSortChar = new BobbleSort<>(array2);


        ArrayOrganizer organizer = new ArrayOrganizer(bobbleSortChar, 1000);
        organizer.sort();
    }
}