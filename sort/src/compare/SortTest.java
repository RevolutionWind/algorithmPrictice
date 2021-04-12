package compare;


import sort.compare.insert.ShellSort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author sunxy
 * @date 2021/2/9 14:23
 */
@SuppressWarnings("unused")
public class SortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 4, 3};
        ShellSort sort = new ShellSort();
        sort.shellSort(arr);
        System.out.print(Arrays.stream(arr).mapToObj(i -> i + "").collect(Collectors.joining(",")));
    }

}
