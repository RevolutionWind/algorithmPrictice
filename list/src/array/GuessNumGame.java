package array;


/**
 * leetcode.229
 * 猜数字游戏
 *
 * @author walker
 * @date 2020-07-29
 */
@SuppressWarnings("unused")
public class GuessNumGame {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretArr = new int[10], guessArr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) - '0' == guess.charAt(i) - '0') {
                bulls++;
            } else {
                secretArr[secret.charAt(i) - '0']++;
                guessArr[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows+= Math.min(secretArr[i], guessArr[i]);
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        String secret = "1234";
        System.out.println(secret.charAt(1));
    }
}