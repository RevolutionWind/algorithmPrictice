#### 动态规划概念
   - 就是穷举 + 剪枝 
   - 本质上和递归、分治、回溯无区别，只是有细节上的区别
   - 动态规划有最优子结构，中间可以淘汰次优解，动态规划存在最优解 

#### 代码
````
    // 斐波拉契问题： 在原有的递归基础上增加中间数组存储递归结果
    public int fib1(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] == 0) {
            memo[n] = fib1(n - 1, memo) + fib1(n - 2, memo);
        }
        return memo[n];
    }

    /*
    循环方式
     */
    public int fib2(int n) {
        int[] res = new int[n + 1];
        res[0] = 0; res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
        // 优化版，可以不用新建数组
//        if (n < 3) return n;
//        int i = 0, j = 1, k = 2;
//        for (int m = 3; m <= n; m++) {
//            i = j;
//            j = k;
//            k = i + j;
//        }
//        return k;
    }
````
