package com.alekseigrin.algos;

public class MinimalDistance {
    public MinimalDistance() {
    }

    public static void main(String[] var0) {
        minimalDistance(var0[0], var0[1]);
    }

    public static void minimalDistance(String var0, String var1) {
        int var2 = var0.length();
        int var3 = var1.length();
        int[][] var4 = new int[var2 + 1][var3 + 1];

        int var5;
        for(var5 = 0; var5 <= var2; var4[var5][0] = var5++) {
        }

        for(var5 = 0; var5 <= var3; var4[0][var5] = var5++) {
        }

        int var6;
        int var7;
        int var9;
        for(var5 = 1; var5 <= var2; ++var5) {
            for(var6 = 1; var6 <= var3; ++var6) {
                var7 = var4[var5][var6 - 1] + 1;
                int var8 = var4[var5 - 1][var6] + 1;
                var9 = var4[var5 - 1][var6 - 1] + (var0.charAt(var5 - 1) == var1.charAt(var6 - 1) ? 0 : 1);
                var4[var5][var6] = Math.min(Math.min(var7, var8), var9);
            }
        }

        var5 = var4[var2][var3];
        System.out.println(var5);
        var6 = var2;
        var7 = var3;
        String[] var12 = var1.split("");
        System.out.println(String.join("", var12));

        while(var5 > 0) {
            var9 = var4[var6][var7 - 1];
            int var10 = var4[var6 - 1][var7];
            int var11 = var4[var6 - 1][var7 - 1];
            if (var11 < var5) {
                var12[var7 - 1] = Character.toString(var0.charAt(var6 - 1));
                --var6;
                --var7;
                var5 = var11;
                System.out.println(String.join("", var12));
            } else if (var9 < var5) {
                var12[var7 - 1] = "";
                --var7;
                var5 = var9;
                System.out.println(String.join("", var12));
            } else if (var10 < var5) {
                var12 = insertIntoArray(var12, var7, Character.toString(var0.charAt(var6 - 1)));
                --var6;
                var5 = var10;
                System.out.println(String.join("", var12));
            } else {
                --var6;
                --var7;
            }
        }

    }

    public static String[] insertIntoArray(String[] var0, int var1, String var2) {
        String[] var3 = new String[var0.length + 1];

        int var4;
        for(var4 = 0; var4 < var1; ++var4) {
            var3[var4] = var0[var4];
        }

        var3[var1] = var2;

        for(var4 = var1 + 1; var4 < var3.length; ++var4) {
            var3[var4] = var0[var4 - 1];
        }

        return var3;
    }
}
