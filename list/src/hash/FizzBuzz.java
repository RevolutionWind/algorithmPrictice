package hash;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode412.fizz buzz
 *
 * @author walker
 * @date 2020-08-05
 */
@SuppressWarnings("unused")
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                StringBuilder stb = new StringBuilder();
                if (i % 3 == 0)
                    stb.append("Fizz");
                if (i % 5 == 0)
                    stb.append("Buzz");
                if (!"".equals(stb.toString()))
                    list.add(stb.toString());
                else list.add("" + i);
            }
            return list;
    }
}