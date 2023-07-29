package Interfaces;

import javax.swing.*;
import java.awt.*;


public class SwingInterface <T> extends JFrame implements Interface<T> {
    private JPanel graphPanel;

    public SwingInterface() {
        super("Gráfico Atualizado");
        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        getContentPane().add(graphPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void showStep(T[] array, int step) {
            graphPanel.removeAll();
            graphPanel.add(new Graphic<>(array, step), BorderLayout.CENTER);
            graphPanel.revalidate();
            graphPanel.repaint();
    };
}

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
        g.setColor(Color.RED);

        int spacement = (width / array.length) / array.length + 20;
        int barWidth = width / array.length - spacement;

        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] instanceof Integer ? (Integer) array[i] : (Character) array[i] ;
            int x = i * (barWidth + spacement);
            int y = height - barHeight;

            // Adicionando cor diferente para cada barra
            Color barColor = new Color(50, 100, 200);
            g.setColor(barColor);

            g.fillRect(x, y, barWidth, barHeight);

            // Adicionando rótulo na barra
            g.setColor(Color.BLACK);
            String valueLabel = String.valueOf(array[i]);
            int labelX = x + barWidth / 2 - g.getFontMetrics().stringWidth(valueLabel) / 2;
            int labelY = y - 5;
            g.drawString(valueLabel, labelX, labelY);
        }
    }


    private Integer getMaxValue(T[] array) {
        int number = -1;
        for (T t : array) {
            if (t instanceof Integer) {
                if ((Integer) t > number) number = (Integer) t;
            } else {
                if ((Character) t > number) number = (Character) t;
            }
        }

        return number;
    }
}
