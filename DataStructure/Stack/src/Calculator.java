public class Calculator {
    public static void main(String[] args) {
        String expression = "3 + 2 * 6 - 2";
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        // 定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char oper = 0;
        int result = 0;
        char ch = ' '; // 将每次扫描得到的char保存到ch
        // 开始while循环地扫描expression
        while (true) {
            // 从expression的首字母开始扫描
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) { // 如果是运算符
                // 判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    // 如果符号站有操作符，就进行比较，如果当前操作符优先级小于或等于栈中的操作符，
                    // 就需要从数栈中pop出两个数
                    // 再从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peak())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = (char) operStack.pop();
                        result = numberStack.cal(num1, num2, oper);
                        // 把运算结果入数栈
                        numberStack.push(result);
                        // 把当前的操作符入符号栈
                        operStack.push(ch);
                    }
                    else {
                        // 如果当前操作符优先级大于栈中的操作符，就直接入栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果是数，则直接入数栈
                    numberStack.push(ch - 48); // "1+3" "1" => 1
                }
                // 让index + 1，并判断是否扫描到expression最后
                index++;
                if (index >= expression.length()) {
                    break;
                }
            }

            // 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
            while (true) {
                // 如果符号栈为空，则计算到最后的结果，数栈中只有一个数字 [结果]
                if (operStack.isEmpty()) {
                    break;
                }
                num1 = numberStack.pop();
                num2 = numberStack.pop();
                oper = (char) operStack.pop();
                result = numberStack.cal(num1, num2, oper);
                numberStack.push(result);
            }
            // 将数栈的最后数，pop出，就是结果
            int finalResult = numberStack.pop();
            System.out.printf("表达式 %s = %d", expression, finalResult);
        }
    }
}


class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    // 返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    // 数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


    // 返回栈顶的值，但是不是真正的pop
    public int peak() {
        return stack[top];
    }
}
