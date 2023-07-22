package methodologies;

public class BobbleSort <T extends Comparable<T>> implements Methodology {
    private T[] array;
    private int step = 0;
    private int index = 0;

    public BobbleSort(T[] array) {
        this.array = array;
    }

    @Override
    public void handle() {
        if (index + 1 == array.length)  this.index = 0;

        T firstElement = array[index];
        T secondElement = array[index + 1];

        boolean validation = firstElement.compareTo(secondElement) > 0;

        if (validation) {
            array[index] = secondElement;
            array[index + 1] = firstElement;
        }

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
}
