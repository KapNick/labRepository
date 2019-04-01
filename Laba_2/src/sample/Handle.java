package sample;

import Humans.Cook;
import Humans.Programmer;
import Items.Food;

import java.lang.String;
import java.util.ArrayList;


public class Handle {
    private Programmer programmer = new Programmer("Василий");
    private Cook cook = new Cook("Иван");
    private ArrayList<Food> foodList = new ArrayList<>();

    public void cook(String ItemName){
        cook.cook(foodList, ItemName);
    }
    public String coding() {
        return programmer.coding();
    }
    public Food eatProger() {
        return programmer.eat(foodList);
    }
    public Food eatCook() {
        return cook.eat(foodList);
    }
    public ArrayList<Food> getStackList() {
        return foodList;
    }
    public String getnameProg(){
        return programmer.getName();
    }
    public String getnameCook(){
        return cook.getName();
    }
}
