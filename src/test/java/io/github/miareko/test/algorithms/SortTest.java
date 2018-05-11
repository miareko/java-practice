package io.github.miareko.test.algorithms;

import io.github.miareko.samples.algorithms.sort.Context;
import io.github.miareko.samples.algorithms.sort.impl.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by miareko on 2018/5/12.
 */
public class SortTest {

    @Test
    public void test() {

        int[] arr = randomArray(10000);

        Context context = new Context();

        context.setStrategy(new BubbleSort());
        context.sort(copyArray(arr));

        context.setStrategy(new SimpleSelectionSort());
        context.sort(copyArray(arr));

        context.setStrategy(new DirectInsertionSort());
        context.sort(copyArray(arr));

        context.setStrategy(new ShellSort());
        context.sort(copyArray(arr));

        context.setStrategy(new HeapSort());
        context.sort(copyArray(arr));

        context.setStrategy(new QuickSort());
        context.sort(copyArray(arr));

        context.setStrategy(new MergeSort());
        context.sort(copyArray(arr));

        context.setStrategy(new RadixSort());
        context.sort(copyArray(arr));
    }

    private int[] copyArray(int[] srcArr) {
        return Arrays.copyOf(srcArr, srcArr.length);
    }

    private int[] randomArray(int size) {
        int[] arr = new int[size];

        Random r = new Random();
        while (size > 0) {
            arr[--size] = r.nextInt(100);
        }
        return arr;
    }
}
