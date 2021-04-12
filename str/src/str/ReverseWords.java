package str;

/**
 * @author sunxy
 * @date 2020/9/28
 */
@SuppressWarnings("unused")
public class ReverseWords {
    public String reverseWords(String s) {
        if (s.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) {
                    result.append(reverse(sb.toString()));
                    sb.setLength(0);
                }
                result.append(" ");
            }
        }
        result.append(reverse(sb.toString()));
        return result.toString();
    }

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
