package com.alekseigrin.algos;

public class MinimalDistance {

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

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
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
        
        
        int distance = cost[n][m];
        System.out.println(distance);
        int curI = n;
        int curJ = m;
        String[] curWord = word2.split("");

        System.out.println(String.join("", curWord));
        while (distance > 0) {
            int deletion = cost[curI][curJ - 1];
            int insertion = cost[curI - 1][curJ];
            int substitution = cost[curI - 1][curJ - 1];
            if (substitution < distance) {
                curWord[curJ - 1] = Character.toString(word1.charAt(curI - 1));
                curI--;
                curJ--;
                distance = substitution;
                System.out.println(String.join("", curWord));
            } else if (deletion < distance) {
                curWord[curJ - 1] = "";
                curJ--;
                distance = deletion;
                System.out.println(String.join("", curWord));
            } else if (insertion < distance) {
                curWord = insertIntoArray(curWord, curJ, Character.toString(word1.charAt(curI - 1)));
                curI--;
                distance = insertion;
                System.out.println(String.join("", curWord));
            } else {
                curI--;
                curJ--;
            }
        }
    }

    public static String[] insertIntoArray(String[] arr, int index, String newItem) {
        String[] result = new String[arr.length + 1];
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        result[index] = newItem;
        for (int i = index + 1; i < result.length; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }
}
