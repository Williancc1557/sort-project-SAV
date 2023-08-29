package methodologies;

public interface Methodology<T> {
    void handle();
    void increaseStep();
    T[] getArray();
    int getStep();
    boolean isOrganized();
}
