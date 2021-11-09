package problemSolving;

import java.util.Arrays;

/**
 * The problem Ice cream parlor.
 * You should receive a list of ice-creams and their prices as a list
 * sample [10, 2, 4, 6, 1, 6, 8]
 * You should find the indices of th two ice-creams that can fit the money ou have
 * <p>
 * the function should receive the list then the price thn return the two indices of the ice-creams
 * hint : you shouldn't get two ice-creams with th same price
 */
public class IceCreamParlor {


    public static int[] getIceCreamIndices(int[] iceCreams, int money) {
        int[] sortedArray = iceCreams.clone();
        Arrays.sort(sortedArray);  //1, 2, 4, 6, 6, 8, 10
        for (int price : sortedArray) {
            int remaining = money - price;
            int priceIndex = getIndexIfExists(iceCreams, price, -1);
            int remainingIndex = getIndexIfExists(iceCreams, remaining, price);
            if (remainingIndex != -1) {
                return new int[]{priceIndex, remainingIndex};
            }
        }
        return null;
    }

    private static int getIndexIfExists(int[] arr, int item, int excludeValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item && arr[i] != excludeValue) {
                return i;
            }
        }
        return -1;
    }


}
