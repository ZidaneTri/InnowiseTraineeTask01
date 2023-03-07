package org.example.sort;

import org.example.ball.*;
import org.example.ball.enums.Color;
import org.example.ball.enums.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    HeapSort sort;
    Comparator<Ball> comparator;

    static Ball[] actual;
    static Ball[] expected = {
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new BasketballBall(12, Color.BLACK, Material.LEATHER)
    };
    static Ball[] expectedVariant = {
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new BasketballBall(12, Color.BLACK, Material.LEATHER)
    };
    static Ball[] expectedReverse = {
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
    };
    static Ball[] expectedReverseVariant = {
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
    };

    @BeforeEach
    void setUp() {
        sort = new HeapSort();
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
    void testHeapSort() {
        sort.sort(actual,comparator);
        assertThat(actual, anyOf(is(expected), is(expectedVariant)));
    }


    @Test
    void testHeapSortReverse() {
        comparator = comparator.reversed();
        sort.sort(actual,comparator);
        assertThat(actual, anyOf(is(expectedReverse), is(expectedReverseVariant)));
    }
}