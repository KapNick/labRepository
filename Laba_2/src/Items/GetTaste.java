package Items;

public class GetTaste {
    public String tasteToString(Food food) {
        switch (food.taste)
        {
            case SWEET: return "Сладкий";
            case SOUR: return "Кислый";
            case SALTY: return "Солёный";
            case BITTER: return "Горький";
        }
        return "Безвкусный";
    }
}
