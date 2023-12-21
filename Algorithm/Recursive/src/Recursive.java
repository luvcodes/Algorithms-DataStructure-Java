public class Recursive {
    public static void main(String[] args) {
//        test(4);

        // 阶乘问题
        int result = factorial(2);
        System.out.println("result = " + result);
    }
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
             System.out.println("n = " + n);
        }
//        else { // 如果写了else
//            System.out.println("n = " + n);
//        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
