package org.example.design;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeGame {
    private int width;
    private int height;
    private int[][] food;
    private int foodPtr;
    private int score;
    private int curR;
    private int curC;

    private Queue<Pair<Integer, Integer>> snake;
    private int snakeSize;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodPtr = 0;
        this.score = 0;
        this.curR = 0;
        this.curC = 0;
        this.snake = new LinkedList<>();
        this.snake.add(new Pair<>(0, 0));
        this.snakeSize = 1;
    }

    public int move(String direction) {
        calculatePosition(direction);

        if (curR < 0 || curR >= height || curC < 0 || curC >= width) {
            return -1;
        }

        checkFood();

        if (snake.contains(new Pair<>(curR, curC))){
            return -1;
        }

        snake.add(new Pair<>(curR, curC));
        while (snake.size() > snakeSize){
            snake.poll();
        }

        return score;
    }

    private void checkFood() {
        if (foodPtr >= food.length){
            return;
        }

        int[] curFood = food[foodPtr];

        if (curFood[0] == curR && curFood[1] == curC){
            score++;
            foodPtr++;
            snakeSize++;
        }
    }

    private void calculatePosition(String direction) {
        switch (direction) {
            case "U":
                curR--;
                break;
            case "D":
                curR++;
                break;
            case "L":
                curC--;
                break;
            case "R":
                curC++;
                break;
        }
    }
}
