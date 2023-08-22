package Interfaces.SwingInterface;

import Interfaces.Interface;
import sav.BasicConsoleRenderer;
import sav.HorizontalConsoleRenderer;
import sav.SwingRenderer;
import sav.VerticalConsoleRenderer;

public class RenderInterface <T> implements Interface <T> {
    @Override
    public void showStep(T[] array, int step) {
        Sav
    }

    public static void runCharacterSav(int n, int freq, RendererFlavor rendererFlavor) {
        Character min = 'A';
        Character max = 'z';

        List<Character> list = Arrays.asList(ArraysHelper.getRandomCharacterArray(n));

        SavSettings<Character> savSettings = new SavSettings<>(list, freq, min, max, value -> value, true);

        SavGenerator<Character> generator = buildGenerator();

        render(rendererFlavor, savSettings, generator);
    }

    public static void runIntegerSav(int n, int freq, RendererFlavor rendererFlavor) {
        int min = -100;
        int max = 100;

        List<Integer> list = Arrays.asList(ArraysHelper.getRandomIntegerArray(n, min, max));

        SavSettings<Integer> savSettings = new SavSettings<>(list, freq, min, max, value -> value, true);

        SavGenerator<Integer> generator = buildGenerator();

        render(rendererFlavor, savSettings, generator);
    }

    private static <T> SavGenerator<T> buildGenerator() {
        return new SavGenerator<T>() {
            @Override
            public void sortItems(List<T> values, boolean isAscending, RenderOperation<T> renderOp) {
                // You need to implement your sorting algorithm here
                // for demo purposes, we will just shuffle the list at this time
                int n = values.size();
                for (int i = 0; i < n; ++i) {
                    ArraysHelper.shuffleList(values);
                    // We notify the changes on the list
                    renderOp.render(values);
                }
            }
        };
    }

    private static <T> void render(RendererFlavor rendererFlavor, SavSettings<T> savSettings, SavGenerator<T> savGenerator) {
        switch (rendererFlavor) {
            case BASIC -> {
                new BasicConsoleRenderer<T>().render(savGenerator, savSettings);
                break;
            }
            case HORIZONTAL -> {
                new HorizontalConsoleRenderer<T>().render(savGenerator, savSettings);
                break;
            }
            case VERTICAL -> {
                new VerticalConsoleRenderer<T>().render(savGenerator, savSettings);
                break;
            }
            case GRAPHICAL -> {
                new SwingRenderer<T>().render(savGenerator, savSettings);
                break;
            }
            default -> {
                return;
            }
        }
    }
}
