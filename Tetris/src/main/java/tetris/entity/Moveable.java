package tetris.entity;

/**
 *Rajapinta liikuteltavia objekteja varten. 
 */
public interface Moveable {

    /**
     *Siirtää objectia oikealle.
     */
    public void moveRight();

    /**
     *Siirtää objectia vasemmalle.
     */
    public void moveLeft();

    /**
     *Siirtää objectia alaspäin.
     */
    public void moveDown();

}
