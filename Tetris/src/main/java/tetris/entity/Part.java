package tetris.entity;

import java.awt.Color;

/**
 * Pelipalikan yksi rakennuspala. Pelipalikka koostuu kaiken kaikkiaan neljästä
 * erillisestä palasta.
 */
public class Part implements Moveable {

    private int x;
    private int y;
    private Color color;

    /**
     * Luo uuden palan.
     *
     * @param x Uuden palan x-koordinaatti
     * @param y Uuden palan y-koordinaatti
     * @param color UUden palan väri
     */
    public Part(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Siirtää palaa taulukossa parametrien mukaisesti.
     *
     * @param dx Määrittää x-koordinaatin muutoksen suuruuden
     * @param dy Määrittää y-koordinaatin muutoksen suuruuden
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Liikuttaa palaa taulukossa yhden pykälän alaspäin.
     */
    @Override
    public void moveDown() {
        y += 1;
    }

    /**
     * Liiikuttaa palaa taulukossa yhden pykälän oikealle.
     */
    @Override
    public void moveRight() {
        x += 1;
    }

    /**
     * Liikuttaa palaa taulukossa yhden pykälän vasemmalle.
     */
    @Override
    public void moveLeft() {
        x -= 1;
    }

    /**
     * Asettaa palalle uudet koordinaatit.
     *
     * @param x Uusi x-koordinaatti
     * @param y UUsi y-koordinaatti
     */
    public void newCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return Palan tämän hetkinen x-koordinaatti
     */
    public int getXCoordinate() {
        return x;
    }

    /**
     * @return Palan tämän hetkinen y-koordinaatti
     */
    public int getYCoordinate() {
        return y;
    }

    /**
     * @return Palan väri
     */
    public Color getColor() {
        return color;
    }
}
