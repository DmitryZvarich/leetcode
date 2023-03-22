package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0){
            return false;
        }

        int candidateCount = 0;

        if(flowerbed.length % 2 == 0){
            candidateCount = flowerbed.length / 2;
        } else {
            candidateCount = (int) ((flowerbed[0] == 1) ? Math.ceil((double)flowerbed.length / 2) : Math.floor((double)flowerbed.length / 2));
        }


        return n <= candidateCount;
    }
}