package Humans;

import Items.Food;
import Items.Taste;

import java.util.ArrayList;
import java.util.Random;

public class Cook extends Human {

    public Cook (String name) {
        super (name);
    }

    public void cook(ArrayList<Food> fl, String ItemName) {
        Random rand = new Random();
        int r = rand.nextInt(4);
        Taste t = null;
        switch (r)
        {
            case 0: t = Taste.SWEET; break;
            case 1: t = Taste.SOUR; break;
            case 2: t = Taste.SALTY; break;
            case 3: t = Taste.BITTER; break;
        }
        Food f = new Food(t, ItemName);
        fl.add (fl.size(), f);
    }
}