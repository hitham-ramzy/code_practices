package designPatterns.behavioural;

public class StrategyPattern {

    interface DiscountStrategy {
        Double calculateBillAmount(Double amount);
    }

    static class HightDiscountStrategy implements DiscountStrategy {
        @Override
        public Double calculateBillAmount(Double amount) {
            return amount - (amount * 0.5);
        }
    }

    static class LowDiscountStrategy implements DiscountStrategy {
        @Override
        public Double calculateBillAmount(Double amount) {
            return amount - (amount * 0.1);
        }
    }

    static class NoDiscountStrategy implements DiscountStrategy {
        @Override
        public Double calculateBillAmount(Double amount) {
            return amount;
        }
    }


    // CONTEXT
    private DiscountStrategy discountStrategy;

    StrategyPattern(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    Double applyDiscount(Double amount) {
        return discountStrategy.calculateBillAmount(amount);
    }

}
