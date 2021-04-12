package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author sunxy
 * @date 2020/11/23 14:28
 */
@SuppressWarnings("unused")
public class LetterCombinations {

    private final Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    private final List<String> res = new ArrayList<>();
    private int n = 0;

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) return res;
        StringBuilder builder = new StringBuilder();
        n = digits.length();
        dfs(digits, 0, builder);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder builder) {
        // end
        if (builder.length() == n) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            dfs(digits, index + 1, builder.append(str.charAt(i)));
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
