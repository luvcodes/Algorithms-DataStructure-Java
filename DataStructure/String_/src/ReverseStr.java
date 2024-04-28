/**
 * @author ryanw
 */
public class ReverseStr {
    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o'};
        reverseStr(str);
        for (char c : str) {
            System.out.print(c + " ");
        }
    }

    public static void reverseStr(char[] str) {
        if (str.length <= 1) {
            return;
        }

        // 双指针解法
        int i = 0;
        int j = str.length - 1;
        char temp;
        while (i < j) {
            temp = str[j];
            str[j] = str[i];
            str[i] = temp;
            i++;
            j--;
        }
    }
}
