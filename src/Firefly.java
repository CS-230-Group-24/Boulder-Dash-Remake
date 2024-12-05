import javafx.scene.image.Image;

// TODO - javadoc class comment
// TODO - javadoc comments in general don't seem to be particularly coherent

public class Firefly extends Enemy {

    /**
     * Talk to james about image
     *
     * @return Image of Firefly
     *
     * // TODO - has this been done, can this comment be removed?
     */

    public Firefly(int x, int y) {
        super(x, y, new Image("./sprites/firefly.png"));
    }

    //to be used by butterfly inheritance to carry its sprite up the chain
    protected Firefly(int x, int y, Image image) {
        super(x, y, image);
    }

    /**
     *
     */
    @Override
    public void move() {

    }

    // TODO - this comment doesn't seem relevant to the method it was placed above, maybe needs moving?
    /**
     * Performs any actions done when an enemy dies by a hazard and returns what they should drop on their death
     * @return int representing a particular item or set of items to be dropped on enemy death
     */

    @Override
    public void movementTests() {

    }

    /**
     * Performs any actions done when an enemy dies by a hazard and returns what they should drop on their death
     * @return int representing a particular item or set of items to be dropped on enemy death
     */

    @Override
    public int onDeathByFallingObject(Entity below) {
        int positionX = below.getX();
        int positionY= below.getY();
        if(checker(positionX, positionY) == true){
            Game.getGame().updateLevel(positionX, positionY, below);
            positionX= positionX+1;
        }else{
            positionX= positionX+1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionY= positionY+1;
        }else{
            positionY= positionY+1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionX= positionX-1;
        }else{
            positionX= positionX-1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionX= positionX-1;
        }else{
            positionX= positionX-1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionY= positionY-1;
        }else{
            positionY= positionY-1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionY= positionY-1;
        }else{
            positionY= positionY-1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionX= positionX+1;
        }else{
            positionX= positionX+1;
        }
        if(checker(positionX, positionY) == true){
            Entity replaced =Game.getGame().getEntity(positionX, positionY);
            Game.getGame().updateLevel(positionX, positionY, replaced);
            positionX= positionX+1;
        }else{
            positionX= positionX+1;
        }
        return 0;
    }

    @Override
    public boolean checker(int x, int y) {
        Entity check = Game.getGame().getEntity(x, y);
        if (check instanceof Exit ){
            return false;
        } else if(check instanceof Wall){
            WallType notUnbreakable =((Wall)check).getWallType();
            if (notUnbreakable == WallType.TITANIUM_WALL){
                return false;
            }else{
                return true;
            }  
        } else if (check instanceof Butterfly){
            Diamond dropedDiamond = new Diamond(x, y);
            Game.getGame().replaceEntity(x, y, dropedDiamond);
            return false;
        } else{
            return true;
        }
    }
    
    /**
     * Getter for Position
     * @return Int[] Position
     */

    @Override
    public int onDeathByFallingObject() {
        return 0;
    }
}
