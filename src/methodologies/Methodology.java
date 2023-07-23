package methodologies;

public interface Methodology<T> {
    public void handle();
    public void increaseStep();
    public T[] getArray();
    public int getStep();
    public int getIndex();
    public boolean isOrganized();
}
