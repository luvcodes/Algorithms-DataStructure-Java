package commonMethod;

/**
 * @author ryanw
 */
public class CalculatorWithArrayStack {
    private ArrayStack2 numStack;
    private ArrayStack2 operStack;

    public CalculatorWithArrayStack(int size) {
        numStack = new ArrayStack2(size);
        operStack = new ArrayStack2(size);
    }

    // 方法：返回运算符的优先级
    private int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;  // 假设表达式只包含 +, -, *, /
        }
    }

    // 方法：判断是不是一个运算符
    private boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    private int calculate(int num1, int num2, int oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                throw new RuntimeException("不支持的运算符");
        }
    }

    public int evaluate(String expression) {
        int index = 0;
        int num1, num2, oper, res;
        char ch;
        String keepNum = "";

        while (true) {
            ch = expression.charAt(index);
            if (isOperator(ch)) {
                if (!operStack.isEmpty()) {
                    if (priority(ch) <= priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = calculate(num1, num2, oper);
                        numStack.push(res);
                        operStack.push((int) ch); // 把当前运算符压入运算符栈中
                    } else {
                        operStack.push((int) ch); // 当前运算符优先级大于运算符栈头结点
                    }
                } else {
                    operStack.push((int) ch); // 当前运算符栈是空，所以要先压一个进去
                }
            } else {
                keepNum += ch;
                // 判断检查我们是否已经到达表达式的末尾
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断检查下一个字符是否为运算符
                    if (isOperator(expression.charAt(index + 1))) {
                        // 完成一个数字的读取后，我们将keepNum转换为整数，并压入数字栈。
                        numStack.push(Integer.parseInt(keepNum));
                        // 重置keepNum，以便于累加下一个数字
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = calculate(num1, num2, oper);
            numStack.push(res);
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        CalculatorWithArrayStack calculator = new CalculatorWithArrayStack(10);
        String expression = "3+2*6-2";
        System.out.println("计算结果是：" + calculator.evaluate(expression));
    }
}


class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组模拟栈
    private int top = -1; // 栈顶，初始化为-1

    // 构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法加入数据");
            return;
        }
        stack[++top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top--];
    }

    // 查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top];
    }
}
