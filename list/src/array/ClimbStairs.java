package array;

/**
 *
 * @author walker
 * @date 2020-07-27
 */
@SuppressWarnings("unused")
public class ClimbStairs {
    public int climbStairs(int n) {
        int i, j = 0, r = 1;
        for(int count = 0; count < n; count++){
            i = j;
            j = r;
            r = i + j;
        }
        return r;
    }
}