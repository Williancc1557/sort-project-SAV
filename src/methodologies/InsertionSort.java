package methodologies;

import java.util.Arrays;

public class InsertionSort <T extends Comparable<T>> implements Methodology {
    private T[] array;
    private int step = 0;
    private int index = 0;
    private boolean invertOrder;

    public InsertionSort(T[] array) {
        this.array = array;
        this.invertOrder = false;
    }

    public InsertionSort(T[] array, boolean invertOrder) {
        this.array = array;
        this.invertOrder = invertOrder;
    }

    @Override
    public void handle() {
        if (index == array.length)  this.index = 0;

        T key = array[index];

        int j = index - 1;

        if (!invertOrder) {
            while (j >= 0 && key.compareTo(array[j]) > 0) {
                array[j + 1] = array[j];
                --j;
            }
        } else {
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                --j;
            }
        }

        array[j + 1] = key;

        increaseStep();
        index++;
    }

    @Override
    public T[] getArray() {
        return array;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void increaseStep() {
        this.step++;
    }

    @Override
    public int getStep() {
        return step;
    }

    public boolean isOrganized() {
        for (int i = 0; i < array.length - 1; i++) {
            T firstElement = array[i];
            T secondElement = array[i + 1];

            boolean validation = invertOrder ?
                    firstElement.compareTo(secondElement) > 0 :
                    secondElement.compareTo(firstElement) > 0;

            if (validation) return false;
        }

        return true;
    }
}
