

/**
 *
 * @author Valeria
 */
public class Tile {
    
    private int orderNumber;
    
    public Tile(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "" + orderNumber;
    }
    
    
    
}
