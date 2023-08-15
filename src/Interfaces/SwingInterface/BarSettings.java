package Interfaces.SwingInterface;

class BarSettings<T> {
    private T value;
    private int x;
    private int y;
    private int barWidth;
    private int barHeight;

    public BarSettings(T value, int x, int y, int barWidth, int barHeight) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
    }

    public T getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBarWidth() {
        return barWidth;
    }

    public int getBarHeight() {
        return barHeight;
    }
}
