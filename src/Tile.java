

/**
 *
 * @author Valeria
 */
public class Tile {
    
    private int orderNumber;
    
    public Tile(int orderNumber) {
        if (orderNumber < 1 || orderNumber > 99) {
            throw new IllegalArgumentException("The order number must be between 1 "
                    + "and 99. Received: " + orderNumber);
        }
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
