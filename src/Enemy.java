import org.junit.jupiter.api.Test;
import javafx.scene.image.Image;
/**
 * The Enemy Class which all enemies inherit from
 * @version 1.0
 * @author Edward Tickle
 */
public abstract class Enemy extends Entity{

    protected Enemy(int row, int column, Image image) {
        super(row,column,image);

    }

    /**
     * Moves the enemy
     */
    public abstract void move();
    /**
     * A Test method designed to be used inside moveTo to test your movement is working correctly
     */
    @Test
    public abstract void movementTests();
    

    /**
     * Performs any actions done when an enemy dies by a hazard and returns what they should drop on their death
     * @return int representing a particular item or set of items to be dropped on enemy death
     * Performs any actions done when an enemy dies by a falling object and executes any on death actions
     * they should do on their death.
     * @return nothing as it executes the actions needed itself
     */
    public abstract void onDeath(Entity below);
}
