package org.example.sort.parallel;

import org.example.ball.*;
import org.example.ball.enums.Color;
import org.example.ball.enums.Material;
import org.example.sort.MergeSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ParallelMergeSortTest {
    ParallelMergeSort sort;
    Comparator<Ball> comparator;

    static Ball[] actual;
    static Ball[] expected = {
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new BasketballBall(12, Color.BLACK, Material.LEATHER)
    } ;
    static Ball[] expectedReverse = {
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
    };

    @BeforeEach
    void setUp() {
        sort = new ParallelMergeSort();
        comparator = Comparator.comparingInt(Ball::getDiameter);
        actual = new Ball[]{
                new BasketballBall(12, Color.BLACK, Material.LEATHER),
                new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
                new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
                new PoloBall(5, Color.RED, Material.SILICONE),
                new FootballBall(9, Color.BLACK, Material.RUBBER),
                new TennisBall(5, Color.BLUE, Material.RUBBER)

        };
    }

    @Test
    void testParallelMergeSort() {
        sort.sort(actual,comparator);
        assertArrayEquals(expected, actual);
    }

    @RepeatedTest(5)
    void testParallelMergeSortStability() {
        sort.sort(actual,comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testParallelMergeSortReverse() {
        comparator = comparator.reversed();
        sort.sort(actual,comparator);
        assertArrayEquals(expectedReverse, actual);
    }

}