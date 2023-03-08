package org.example;

import org.example.ball.*;
import org.example.ball.enums.Color;
import org.example.ball.enums.Material;
import org.example.sort.TreeSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    Basket basket;

    static Ball[] initial = {
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new TennisBall(5, Color.BLUE, Material.RUBBER)
    };

    static Ball[] sortedByDiameter = {
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new BasketballBall(12, Color.BLACK, Material.LEATHER)
    };

    static Ball[] sortedByColor = {
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new TennisBall(5, Color.BLUE, Material.RUBBER)
    };

    static Ball[] sortedByMaterial = {
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),
            new PoloBall(5, Color.RED, Material.SILICONE)
    };

    static Ball[] sortedByClass = {
            new BasketballBall(12, Color.BLACK, Material.LEATHER),
            new FootballBall(9, Color.BLACK, Material.RUBBER),
            new PoloBall(5, Color.RED, Material.SILICONE),
            new TennisBall(5, Color.BLUE, Material.RUBBER),
            new VolleyballBall(1, Color.ORANGE, Material.RUBBER),
            new VolleyballBall(4, Color.GREEN, Material.POLYESTER),

    };

    @BeforeEach
    void setUp() {
        basket = new Basket();
        basket.setBasketContent(initial);
    }

    @Test
    void testSortByDiameter() {
        basket.sortByDiameter().executeSort();
        assertArrayEquals(sortedByDiameter,basket.getArray());

    }

    @Test
    void testSortByColor() {
        basket.sortByColor().executeSort();
        assertArrayEquals(sortedByColor,basket.getArray());
    }

    @Test
    void testSortByMaterial() {
        basket.sortByMaterial().executeSort();
        assertArrayEquals(sortedByMaterial,basket.getArray());
    }

    @Test
    void testSortByClassName() {
        basket.sortByClassName().executeSort();
        assertArrayEquals(sortedByClass,basket.getArray());
    }


}