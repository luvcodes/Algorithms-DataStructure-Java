import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ryanw
 */
public class PolandNotation {
    public static void main(String[] args) {
        /**
         * 先定义逆波兰表达式
         * (3+4)*5-6
         * 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
         * */
        String suffixExpression = "3 4 + 5 * 6 -";
        String suffixExpression2 = "4 5 * 8 - 60 + 8 2 / +";

        // 思路:
        // 1. 先将"3 4 + 5 * 6 -" 放到ArrayList中
        // 2. 将ArrayList传递给一个方法, 遍历ArrayList, 配合栈 完成计算
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println("rpnList=" + rpnList);
//        int res = calculate(rpnList);
//        System.out.println("计算结果为=" + res);

        List<String> rpnList = getListString(suffixExpression2);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("计算结果为=" + res);
    }

    public static List<String> getListString(String suffixExpression) {
        // 将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<String>();
        for (String ele : list) {
            if (ele.matches("\\d+")) { // 匹配的是多位数
                stack.push(ele);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (ele.equals("+")) { // 匹配的是多位数
                    res = num1 + num2;
                } else if (ele.equals("-")) {
                    res = num1 - num2;
                } else if (ele.equals("*")) {
                    res = num1 * num2;
                } else if (ele.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());  // 最后留在stack中的数据就是运算结果
    }
}


