package org.example;

import org.example.ball.*;
import org.example.ball.enums.Color;
import org.example.ball.enums.Material;
import org.example.service.SortService;
import org.example.sort.*;
import org.example.sort.parallel.ParallelMergeSort;
import org.example.sort.parallel.ParallelQuickSort;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {10, 80, 30, 90, 40, 50, 70};
        QuickSort sort = new QuickSort();
        sort.sort(arr, Integer::compare);
        Basket basket = new Basket();
        basket.add(new BasketballBall(12, Color.BLACK, Material.LEATHER));
        basket.add(new VolleyballBall(4, Color.GREEN, Material.POLYESTER));
        basket.add(new VolleyballBall(1, Color.ORANGE, Material.RUBBER));
        basket.add(new PoloBall(5, Color.RED, Material.SILICONE));
        basket.add(new TennisBall(5, Color.RED, Material.RUBBER));
        basket.add(new BasketballBall(12, Color.VIOLET, Material.LEATHER));
        basket.add(new VolleyballBall(2, Color.GREEN, Material.RUBBER));
        basket.add(new TennisBall(7, Color.INDIGO, Material.SYNTHETIC_LEATHER));
        basket.add(new PoloBall(1, Color.RED, Material.LEATHER));
        basket.add(new BasketballBall(8, Color.YELLOW, Material.POLYESTER));
        basket.add(new FootballBall(13, Color.YELLOW, Material.LEATHER));
        basket.add(new VolleyballBall(6, Color.MIXED, Material.SYNTHETIC_LEATHER));
        basket.add(new FootballBall(14, Color.ORANGE, Material.SILICONE));
        basket.add(new FootballBall(9, Color.BLACK, Material.RUBBER));
        basket.add(new TennisBall(5, Color.BLUE, Material.RUBBER));

      /*  Ball[] balls = basket.getBasketContent().toArray(new Ball[0]);
        Comparator<Ball> comparator1 = Comparator.comparingInt(Ball::getDiameter);
        comparator1 = comparator1.reversed();
        SortService<Ball> sortService = new SortService<>();
        sortService.setComparator(comparator1);
        sortService.sort(balls);
        sort.sort(balls, comparator1.reversed());*/
        basket.setSorter("treesort").reverseOrder().sortByDiameter().executeSort();
        System.out.println("lol");
      /*  Comparator<Ball> comparator2 = Comparator.comparing(Ball::getColor);
        sort.sort(balls, comparator2);*/





    }
}