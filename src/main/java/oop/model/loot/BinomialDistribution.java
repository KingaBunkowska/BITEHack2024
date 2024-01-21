package oop.model.loot;

import java.util.Random;

public class BinomialDistribution {
    private static Random random = new Random();
    public static int getRandomBinomial(int n, float p) {

        int result = 0;
        for(int i=0; i<n; i++){
            float rand = random.nextFloat();
            if(rand<=p){
                result++;
            }
        }
        return result;
    }

    private static double factorial(int n){
        int result = 1;
        for (int i = 2; i<=n; i++){
            result *= i;
        }
        return result;
    }

    private static double binomial_theorem(int n, int k){
        return  factorial(n) / factorial(k)/factorial(n-k);
    }
}
