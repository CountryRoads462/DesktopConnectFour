class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (num1, num2, num3) -> num1 != num3 && num2 != num3 && num1 != num2;

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int num1, int num2, int num3);
    }
}