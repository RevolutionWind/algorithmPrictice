package str;

/**
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * @author sunxy
 * @date 2021/6/26 15:46
 */
@SuppressWarnings("unused")
public class StrMultiply {

    public String multiply(String num1, String num2) {
        if (num1.length() < 1 || num2.length() < 1) return "";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int cur = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 加低位判断是否有新的进位
                cur += res[i + j + 1];

                res[i + j] += cur / 10;
                res[i + j + 1] = cur % 10;
            }
        }

        StringBuilder sb = new StringBuilder(num1.length() + num2.length());
        // 去掉多余的0
        int i = 0;
        while (i < res.length - 1 && res[i] == 0) {
            i++;
        }
        for (; i < num1.length() + num2.length(); i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
