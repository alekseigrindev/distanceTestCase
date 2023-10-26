package com.alekseigrin.algos;

public class MinimalDistance {
    public MinimalDistance() {
    }

    public static void main(String[] args) {
        minimalDistance(args[0], args[1]);
    }

    public static void minimalDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            cost[0][i] = i;
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                char c1 = word1.charAt(i), c2 = word2.charAt(j);
                if (c1 == c2) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    int replace = cost[i][j];
                    int delete= cost[i][j + 1];
                    int insert = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        System.out.println(cost[m][n]);
    }
}
