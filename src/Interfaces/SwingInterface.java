package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class SwingInterface <T> extends JFrame implements Interface<T> {
    private JPanel graphPanel;

    public SwingInterface() {
        super("Gráfico Atualizado");
        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        getContentPane().add(graphPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void showStep(T[] array, int step) {
            graphPanel.removeAll();
            graphPanel.add(new Graphic<>(array), BorderLayout.CENTER);
            graphPanel.revalidate();
            graphPanel.repaint();
    };
}

class Graphic<T> extends JPanel {
    private T[] array;

    public Graphic(T[] array) {
        this.array = array;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.RED);

        int spacement = (width / array.length) / array.length;
        int barWidth = width / array.length - spacement;
        int maxHeight = height / getMaxValue(array);

        for (int i = 0; i < array.length; i++) {
            int barHeight = (Integer) array[i] + maxHeight / 2 ;
            int x = i * (barWidth + spacement);
            int y = height - barHeight;
            g.fillRect(x, y, barWidth, barHeight);
        }
    }

    private Integer getMaxValue(T[] array) {
        Integer number = -1;
        for (T t : array) {
            if ((Integer) t > number) number = (Integer) t;
        }

        return number;
    }
}
