package dp;

/**
 * 翻转灯泡
 * <p>
 * 4 * 4 的二维数组 标识灯泡的状态 1 0
 * 0 1 1 0
 * 1 1 0 0
 * 1 0 1 1
 * 0 0 1 0
 * <p>
 * 翻转自身也会翻转上、下、左、右五个灯的状态
 * <p>
 * 通过若干次操作，使得所有状态全部转化为0或者1
 *
 * @author sunxy
 * @date 2021/8/31 10:03
 */
@SuppressWarnings("unused")
public class ReverseLight {

    int min = Integer.MAX_VALUE;

    int reverseLight(int[][] lights) {
        int rowLen = lights.length, colLen = lights[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int[][] clone = lights.clone();
                boolean[][] visited = new boolean[rowLen][colLen];
                bfs(i, j, lights, visited, 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    void bfs(int i, int j, int[][] lights, boolean[][] visited, int times) {
        // end
        if (i < 0 || i >= lights.length || j < 0 || j >= lights[0].length || visited[i][j]) {
            return;
        }
        // 翻转自身、上下左右
        lights[i][j] = reverseNumber(lights[i][j]);
        if (i - 1 > 0) {
            // 上
            lights[i - 1][j] = reverseNumber(lights[i - 1][j]);
        }
        if (i + 1 < lights.length) {
            // 下
            lights[i + 1][j] = reverseNumber(lights[i + 1][j]);
        }
        if (j - 1 > 0) {
            // 左
            lights[i][j - 1] = reverseNumber(lights[i][j - 1]);
        }
        if (j + 1 < lights.length) {
            // 右
            lights[i][j + 1] = reverseNumber(lights[i][j + 1]);
        }
        if (isSame(lights)) {
            min = Math.min(min, times);
            return;
        }
        visited[i][j] = true;
        bfs(i + 1, j, lights, visited, times + 1);
        bfs(i - 1, j, lights, visited, times + 1);
        bfs(i, j + 1, lights, visited, times + 1);
        bfs(i, j - 1, lights, visited, times + 1);
        visited[i][j] = false;
    }

    private int reverseNumber(int num) {
        return num == 1 ? 0 : 1;
    }

    /*
       判断所有的灯光是否相同
     */
    private boolean isSame(int[][] lights) {
        int rowLen = lights.length, colLen = lights[0].length;
        Integer last = null;
        for (int[] light : lights) {
            for (int j = 0; j < colLen; j++) {
                if (last == null) {
                    last = light[j];
                    continue;
                }
                if (last != light[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] lights = {{0, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 1}, {0, 0, 1, 0}};
        ReverseLight obj = new ReverseLight();
        System.out.println(obj.reverseLight(lights));
    }

}
