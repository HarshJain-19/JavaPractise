package problems;

/*
* Given three values money, price, and wrap, the task is to find the total number of chocolates you can eat.
* Here money defines the total amount of money you have, price is the cost of buying a single chocolate
* and wrap defines the number of wrappers that can be returned to get one extra chocolate.
* Input: money = 16, price = 2, wrap = 2
* Output: 15
* Explanation: The price of a chocolate is 2. You can buy 8 chocolates for the amount 16.
* Then return 8 wrappers and get 4 more chocolates. Then you can return 4 wrappers and get 2 more chocolates.
* Finally, you can return 2 wrappers to get 1 more chocolate.
* So the total chocolates you eat will be 8 + 4 + 2 + 1 = 15.
*/

public class Problem2 {

    public int totalChocolatesFromWrapper(int chocolates, int wrap) {
        if (chocolates < wrap)
            return 0;
        int wrapperLeft = chocolates / wrap;
        return wrapperLeft + totalChocolatesFromWrapper(wrapperLeft + chocolates % wrap, wrap);
    }

    public int getTotalChocolates1(int money, int price, int wrap) {
        if (money < price)
            return 0;
        int totalChocolates = money / price;
        return totalChocolates + totalChocolatesFromWrapper(totalChocolates, wrap);
    }

    public int getTotalChocolates2(int money, int price, int wrap) {
        if (money < price)
            return 0;
        int totalChocolates = money / price;
        return totalChocolates + (totalChocolates - 1) / (wrap - 1);
    }

    public static void main(String[] args) {
        Problem2 solution = new Problem2();

        int totalChocolates = solution.getTotalChocolates1(15, 1, 3);
        System.out.println("total chocolates: " + totalChocolates);

        // efficient way
        int totalChocolates2 = solution.getTotalChocolates2(15, 1, 3);
        System.out.println("total chocolates by efficient method: " + totalChocolates2);
    }
}
