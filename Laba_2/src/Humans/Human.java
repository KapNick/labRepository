package Humans;

import Items.Food;

import java.util.ArrayList;


class Human {

    private String name;

    public Human (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Food eat(ArrayList<Food> fl) {
        Food f = fl.get (fl.size()-1);
        fl.remove(fl.size()-1);
        return f;
    }
}