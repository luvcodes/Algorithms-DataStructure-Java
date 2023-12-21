import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ryanw
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 完成将一个中缀表达式转成后缀表达式的功能
        // 1. 1 + ((2+3) * 4) - 5 => 1 2 3 + 4 * 5 -
        // 2. 因为直接对str进行操作，不方便，因此先将"1 + ((2+3) * 4) - 5" => 中缀表达式对应的list
        // 3. 将得到的中缀表达式对应的list => 后缀表达式对应的list

        String expression = "1+((2+3)*4)-5";
        List<String> expressionList = toInfixExpressionList(expression);
        System.out.println(expressionList);


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

//        List<String> rpnList = getListString(suffixExpression2);
//        System.out.println("rpnList=" + rpnList);
//        int res = calculate(rpnList);
//        System.out.println("计算结果为=" + res);
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

    // 完成对逆波兰表达式的运算
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


    // 将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s) {
        // 定义一个List，存放中缀表达式对应的内容
        List<String> list = new ArrayList<String>();
        int i = 0; // 这个指针用于遍历中缀表达式字符串
        String str; // 用于拼接字符串
        char c; // 每遍历到一个字符，就放入到c
        do {
            // 如果c是一个非数字，就需要加入到list
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else { // 如果是一个数字，需要考虑多位数的问题
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    // 将得到的中缀表达式对应的List => 后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        Stack<String> s2 = new Stack<String>(); // 存储中间结果的栈
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) {
                s2.push(item);
            } else {
                if (s1.isEmpty()) {
                    s1.push(item);
                } else {
                    if (item.equals("(")) {
                        s1.push(item);
                    } else if (item.equals(")")) {
                        while (!s1.peek().equals("(")) {
                            s2.push(s1.pop());
                        }
                    }
                }
            }
        }
        return s2; // 后缀表达式的list
    }
}


