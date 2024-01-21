package oop.model.loot;

import java.util.Random;

public class BinomialDistribution {
    private static Random random = new Random();
    public static int getRandomBinomial(int n, float p) {
        float rand = random.nextFloat();
        float cdf = 0;

        int current_value = 0;
        while (cdf<=rand){
            float probability = binomial_theorem(n, current_value);
            cdf += probability;
        }

        return current_value;

    }

    private static int factorial(int n){
        int result = 1;
        for (int i = 2; i<=n; i++){
            result *= i;
        }
        return result;
    }

    private static float binomial_theorem(int n, int k){
        return factorial(n)/factorial(k)/factorial(n-k);
    }
}
