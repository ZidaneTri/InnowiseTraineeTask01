package org.example;

import org.example.ball.Ball;
import org.example.service.SortService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Basket {

    private ArrayList<Ball> basketContent;
    private SortService<Ball> sortService;
    private boolean reverseFlag = false; // while flag is true, any comparator will have reversed order
    public Basket() {
        basketContent = new ArrayList<>();
        sortService = new SortService<>();
    }

    public Basket(ArrayList<Ball> basketContent) {
        this.basketContent = basketContent;
        sortService = new SortService<>();
    }

    public ArrayList<Ball> getBasketContent() {
        return basketContent;
    }

    public void setBasketContent(ArrayList<Ball> basketContent) {
        this.basketContent = basketContent;
    }

    public void setBasketContent(Ball[] array) {
        ListIterator<Ball> iterator = basketContent.listIterator();
        for (Ball ball : array) {
            iterator.next();
            iterator.set(ball);
        }
    }

    public void add(Ball ball) {
        basketContent.add(ball);
    }

    public void add(List<Ball> ballList) {
        basketContent.addAll(ballList);
    }

    public void delete(Ball ball){
        basketContent.remove(ball);
    }

    public Ball[] getArray() {
        return getBasketContent().toArray(new Ball[0]);
    }

    public Basket setSorter(String sorter) {
        sortService.setSorter(sorter);
        return this;
    }

    public Basket reverseOrder(){
        reverseFlag = !reverseFlag;
        return this;
    }

    public Basket sortByDiameter() {
        sortService.setComparator(Comparator.comparingInt(Ball::getDiameter));
        return this;
    }

    public Basket sortByColor() {
        sortService.setComparator(Comparator.comparing(Ball::getColor));
        if (reverseFlag) {
            sortService.reverseComparator();
        }
        return this;
    }

    public Basket sortByMaterial() {
        sortService.setComparator(Comparator.comparing(Ball::getMaterial));
        if (reverseFlag) {
            sortService.reverseComparator();
        }
        return this;
    }

    public void executeSort() {
        Ball[] balls = this.getArray();
        if (reverseFlag) {
            sortService.reverseComparator();
        }
        sortService.sort(balls);
        this.setBasketContent(balls);

    }









}
