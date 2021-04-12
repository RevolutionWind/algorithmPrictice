package array;

/**
 * leetcode11： 盛水最多的容器
 * 1. 双重for循环
 * 2. 夹逼：只移动最小高度的指针
 *
 * @author walker
 * @date 2020-07-29
 */
@SuppressWarnings("unused")
public class MaxArea {

    /*
    双重for循环
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    /*
    夹逼
     */
    public int maxArea2(int[] height) {
        if (height.length < 2) {
            throw new IllegalArgumentException("非法数组长度");
        }
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int minHeight = height[i] >= height[j] ?
                    height[j--] : height[i++];
            max = Math.max(max, minHeight * (j - i + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
//        int area = maxArea.maxArea1(heights);
        int area = maxArea.maxArea2(heights);
        System.out.println(area);

    }
}