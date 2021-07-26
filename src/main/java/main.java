import java.util.Arrays;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        int[] point1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        point1 = method1(point1);
        printInt(point1);

        int[] point2 = new int[8];
        point2 = method2(point2);
        printInt(point2);

        int[] point3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        point3 = method3(point3);
        printInt(point3);

        int[][] point4 = new int[3][3];
        point4 = method4(point4);
        printIntInt(point4);

        int[] point5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        method5_1(point5);
        method5_2(point5);

        int[] point6 = {1, 1, 0, 0, 0, 0, 1, 1, 0, 4};
        System.out.println("Ответ на 6 задачу - " + method6(point6));

        int[] point7 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        method7(point7, -30);
        printInt(point7);

    }

    //region вывод одномерного массива int
    public static void printInt(int[] a) {
        for (int o : a) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
    //endregion

    //region вывод двумерного массива int
    public static void printIntInt(int[][] a) {
        for (int[] b : a) {
            for (int c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    //endregion

    //region Задача 1

    /***
     * метод меняет 0 и 1 не в переменной которая в него приходит, а в копии массива (int[] a)
     * @param a int[]
     * @return
     */
    static int[] method1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) a[i] = 1;
            else a[i] = 0;
        }
        return a;
    }
    //endregion

    //region Задача 2
    static int[] method2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + 3;
        }
        return a;
    }
    //endregion

    //region Задача 3
    static int[] method3(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) a[i] = a[i] * 2;
        }
        return a;
    }
    //endregion

    //region Задача 4
    static int[][] method4(int[][] a) {
        for (int i = 0; i < a[0].length; i++) {
            a[i][i] = 1;
        }
        return a;
    }
    //endregion

    //region Задача 5.1 (это если без интернета :))
    static void method5_1(int[] a) {
        System.out.println("Минимальное значение = " + Arrays.stream(a).min());
        System.out.println("Максимальное значение = " + Arrays.stream(a).max());
    }

    //endregion
    //region Задача 5.2 (это тоже)
    static void method5_2(int[] a) {
        int min = a[0], max = 0;
        for (int b : a) {
            if (b > max) max = b;
            if (b < min) min = b;
        }
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение = " + max);
    }
    //endregion

    //region Задача 6
    static boolean method6(int[] a) {
        int b = 0;
        //могу конечно сделать цикл и просуммировать. но знал, что есть нормальная сумма
        int total = IntStream.of(a).sum();

        if (total % 2 != 0) return false;
        else System.out.println(total);
        for (int c : a) {
            b = b + c;
            if (b == total / 2) return true;
            if (b > total / 2) break;
        }
        return false;
    }
    //endregion

    //region Задача 7
    // Ощущение не покидает, что есть более красивое решение, но за 2 часа не придумал

    static int[] method7(int[] a, int b) {
        b = b % a.length;
        int c = b;
        if (b < 0) c = b * -1;
        for (int i = 0; i < c; i++) {
            if (b > 0) {
                int temp = a[0];
                for (int j = 0; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length-1] = temp;
            } else {
                int temp = a[a.length-1];
                for (int j = a.length-1; j > 0; j--) {
                    a[j] = a[j-1];
                }
                a[0] = temp;
            }
        }

        return a;
    }
    //endregion


}
