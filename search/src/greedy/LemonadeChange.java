package greedy;

/**
 * leetcode860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 输入：[5,5,5,10,20]
 * 输出：true
 * <p>
 * 输入：[10,10]
 * 输出：false
 *
 * @author sunxy
 * @date 2020/8/20
 */
@SuppressWarnings("unused")
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0, tenNum = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fiveNum++;
                    break;
                case 10: {
                    if (fiveNum == 0) return false;
                    fiveNum--;
                    tenNum++;
                    break;
                }
                case 20: {
                    if (tenNum > 0 && fiveNum > 0) {
                        tenNum--;
                        fiveNum--;
                    } else if (fiveNum >= 3) {
                        fiveNum -= 3;
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(l.lemonadeChange(bills));
    }
}
