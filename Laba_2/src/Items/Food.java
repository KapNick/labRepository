package Items;


public class Food extends Item {

    public Taste taste;

   public Food(Taste taste, String ItemName){
        super(ItemName);
        this.taste = taste;
    }
}
