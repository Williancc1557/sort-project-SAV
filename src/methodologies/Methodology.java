package methodologies;

public interface Methodology<T> {
    void handle();
    void increaseStep();
    T[] getArray();
    int getStep();
    int getIndex();
    boolean isOrganized();
}
