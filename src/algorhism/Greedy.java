package algorhism;

import java.util.ArrayList;
import java.util.Arrays;

public class Greedy {

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500,100,50,10,1));

        int result = coinFunc(4755, coinList);

        System.out.println(result);
    }

    public static int coinFunc(Integer price, ArrayList<Integer> coinList) {
        int totalCoinCount = 0;
        int recentCoinCount = 0;
        System.out.println("price : " + price);
        for(int coin : coinList) {
            recentCoinCount = price / coin;

            price = price - coin * recentCoinCount;
            System.out.println("price : " + price + ", " + "coin : " + coin);
            totalCoinCount += recentCoinCount;

        }
        return totalCoinCount;
    }
}
