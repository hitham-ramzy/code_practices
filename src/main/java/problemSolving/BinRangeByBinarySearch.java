package problemSolving;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;


class BinRangeByBinarySearch {

    /**
     * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that
     * mark the boundaries of the range which is maped to other bin range properties such
     * as a card type. The range boundaries are inclusive.
     */
    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }

    /**
     * The type Bin range as long.
     *  An entity same as BinRange but with long value types in start and end to take advantage of the comparison of numbers
     *
     */
    static final class BinRangeAsLong {
        final Long start;
        final Long end;
        final String cardType;

        BinRangeAsLong(Long start, Long end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }

        @Override
        public String toString() {
            return "BinRangeAsLong{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cardType='" + cardType + '\'' +
                    '}';
        }
    }

    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         * @return the card type for this cardNumber or null if the card number does not
         * fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }

    static class AdyenCardTypeCache implements CardTypeCache {
        List<BinRangeAsLong> binRanges;

        public AdyenCardTypeCache(List<BinRangeAsLong> binRanges) {
            this.binRanges = binRanges;
        }

        @Override
        public String get(String cardNumber) {
            int startIndex = 0;
            int endIndex = binRanges.size() - 1;
            long cardNumberAsLong;
            while (startIndex <= endIndex) {
                int midIndex = startIndex + ((endIndex - startIndex) / 2);
                BinRangeAsLong midBinRange = binRanges.get(midIndex);
                cardNumberAsLong = Long.parseLong(cardNumber.substring(0, midBinRange.start.toString().length()));

                if (cardNumberAsLong >= midBinRange.start && cardNumberAsLong <= midBinRange.end) {
                    return midBinRange.cardType;
                } else if (cardNumberAsLong < midBinRange.start) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            }
            return null;
        }
    }

    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        // TODO return a new instance of CardTypeCache
        List<BinRangeAsLong> binRangesAsLong = binRanges.stream()
                .map(binRange -> new BinRangeAsLong(Long.parseLong(binRange.start), Long.parseLong(binRange.end), binRange.cardType))
                .sorted(Comparator.comparingLong(value -> value.start))
                .collect(toList());
        return new AdyenCardTypeCache(binRangesAsLong);
    }

}

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(buildCache(List.of(new Result.BinRange("400000000000", "499999999999", "visa"),
                        new Result.BinRange("500000000000", "599999999999", "mc"),
                        new Result.BinRange("300000000000", "399999999999", "amex")

                )).get("4111111111111111")
        );
    }
}*/
