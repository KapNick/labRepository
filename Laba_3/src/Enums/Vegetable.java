package Enums;

public enum Vegetable {
    CARROT("Морковь"),
    CORN("Кукуруза"),
    POTATO("Картофель"),
    TOMAT("Помидор"),
    CUCUMBER("Огурец");

    private String vegetable;

    Vegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getVegetable() {
        return vegetable;
    }
}
