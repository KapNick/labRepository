package Enums;

public enum Taste {
    SWEET("Сладкий"),
    SALTY("Солёный"),
    SOUR("Кислый"),
    BITTER("Горький"),
    TASTELESS("Безвкусный");

    private String taste;

    Taste(String taste) {
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }
}