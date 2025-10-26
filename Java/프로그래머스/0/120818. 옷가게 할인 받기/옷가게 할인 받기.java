class Solution {
    public int solution(int price) {
        int result = price;
        double discount = 0;

        if (price >= 100_000 && price < 300_000) {
            discount= Math.round(price * 0.05);
            result -= (int) discount;
            return result;
        }
        if (price >= 300_000 && price < 500_000) {
            discount= Math.round(price * 0.1);
            result -= (int) discount;
            return result;
        }
        if (price >= 500_000) {
            discount= Math.round(price * 0.2);
            result -= (int) discount;
            return result;
        }

        return price;
    }
}