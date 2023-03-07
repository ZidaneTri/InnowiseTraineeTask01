package org.example.ball;

import org.example.ball.enums.Color;
import org.example.ball.enums.Material;

public abstract class Ball {

    private int diameter;
    private Color color;
    private Material material;

    public Ball(int diameter, Color color, Material material) {
        this.diameter = diameter;
        this.color = color;
        this.material = material;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (ball.diameter != diameter) return false;
        if (color != ball.color) return false;
        return material == ball.material;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(diameter);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        result = 31 * result + material.hashCode();
        return result;
    }
}
