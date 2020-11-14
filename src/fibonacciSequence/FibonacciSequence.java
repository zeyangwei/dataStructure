package fibonacciSequence;

/**
 * @author 魏泽阳
 * @date 2020/11/14 9:38
 * 斐波那契数列，一共有两种方式
 */
public class FibonacciSequence {
    /**
     * 第一种，递归实现
     * @param n
     * @return
     */
    private int recursion(int n){
        if (n<=1){
            return n;
        }
        return recursion(n-1)+recursion(n-2);
    }

    /**
     * 第二种，动态扩容实现
     * @param n
     * @return
     */
    private int dynamicExpansion(int n){
        if (n<=1){
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first+second;
            first = second;
            second = sum;
        }
        return second;
    }

}
