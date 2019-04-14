package Enums;

public enum Color {
    RED("Красный"),
    GREEN("Зелёный"),
    BLUE("Голубой"),
    PURPLE("Фиолетовый"),
    YELLOW("Жёлтый"),
    VIOLET("Сиреневый"),
    BROWN("Коричневый"),
    CYAN("Бирюзовый"),
    PINK("Розовый");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}