package Interfaces.SwingInterface;

import javax.swing.*;
import java.awt.*;

class Graphic<T> extends JPanel {
    private T[] array;

    public Graphic(T[] array, int step) {
        this.array = array;
        setBackground(Color.WHITE);

        JLabel label = new JLabel("STEP: " + step);

        Font font = label.getFont();
        int tamanhoFonte = 24; // Tamanho da fonte desejado
        label.setFont(new Font(font.getName(), font.getStyle(), tamanhoFonte));

        add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int spacement = (width / array.length) / (array.length - 1);
        int barWidth = width / array.length - spacement;

        for (int i = 0; i < array.length; i++) {
            int barHeight = getBarHeight(i);

            int x = i * (barWidth + spacement);
            int y = height - barHeight;

            BarSettings<T> barSettings = new BarSettings<T>(array[i], x, y, barWidth, barHeight);
            setBar(g, barSettings);
            setLabel(g, barSettings);
        }
    }

    private int getBarHeight(int i) {
        int barHeight;

        if (array[i] instanceof Integer) {
            int intValue = (Integer) array[i];
            return (intValue + Math.abs(getMinValue(array))) / 2;
        }

        int charValue = ((Character) array[i] - 64) * 4;
        barHeight = Math.abs(charValue);

        return barHeight;
    }

    private Integer getMinValue(T[] array) {
        int number = Integer.MAX_VALUE;
        for (T t : array) {
            if (t instanceof Integer) {
                if ((Integer) t < number) number = (Integer) t;
            }
        }
        return number;
    }

    private Color getColor(T element) {
        return element instanceof Integer ? new Color(50, 100, 200) : new Color(255, 0, 0);
    }

    private void setBar(Graphics g, BarSettings<T> bar) {
        Color barColor = getColor(bar.getValue());
        g.setColor(barColor);
        g.fillRect(bar.getX(), bar.getY(), bar.getBarWidth(), bar.getBarHeight());
    }

    private void setLabel(Graphics g, BarSettings<T> bar) {
        g.setColor(Color.BLACK);
        String valueLabel = String.valueOf(bar.getValue());
        int labelX = bar.getX() + bar.getBarWidth() / 2 - g.getFontMetrics().stringWidth(valueLabel) / 2;
        int labelY = bar.getY() - 5;
        g.drawString(valueLabel, labelX, labelY);
    }
}
