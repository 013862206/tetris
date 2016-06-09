package tetris.entity;

import java.util.*;

/**
 * Abstrakti-luokka pelipalikoiden ilmentymiä varten. Pelipalikoiden
 * tarvitsemien metodien toteutus on suoritettu jo tässä luokassa. Vain
 * erilaisten pelipalikoiden ilmentymien konstruointi on jätetty luokan
 * aliluokkien tehtäväksi.
 */
public abstract class Block implements Moveable {

    /**
     * Taulukko palikan paloja varten.
     */
    protected Part[] parts;

    /**
     * Palikan x-koordinaatti.
     */
    protected int x;

    /**
     * Palikan y-koordinaatti.
     */
    protected int y;

    /**
     * Konstruktori luo uuden palikan annettuihin koordinaatteihin ja alustaa
     * taulukon aliluokkaa varten.
     *
     * @param x Palikan x-koordinaatti
     * @param y Palikan y-koordinaatti
     */
    public Block(int x, int y) {
        this.parts = new Part[4];
        this.x = x;
        this.y = y;
    }

    /**
     * Siirtää palikkaa parametrien mukaisesti. Siirtäminen tapahtuu siirtämällä
     * jokaista palikan koostavaa palaa parametrien mukaisesti.
     *
     * @param dx Määrittää x-koordinaatin muutoksen suuruuden
     * @param dy Määrittää y-koordinaatin muutoksen suuruuden
     *
     * @see tetris.entity.Part#move(int, int)
     */
    public void move(int dx, int dy) {
        for (Part part : this.parts) {
            part.move(dx, dy);
        }
        this.x += dx;
        this.y += dy;
    }

    /**
     * Siirtää palikkaa yhden pykälän alaspäin siirtämällä jokaista palaa yhden
     * alaspäin.
     *
     * @see tetris.entity.Part#moveDown()
     */
    @Override
    public void moveDown() {
        for (Part part : this.parts) {
            part.moveDown();
        }
        this.y++;
    }

    /**
     * Siirtää palikkaa yhden pykälän vasemmalle siirtämällä jokaista palaa
     * yhden pykälän vasemmalle.
     *
     * @see tetris.entity.Part#moveLeft()
     */
    @Override
    public void moveLeft() {
        for (Part part : this.parts) {
            part.moveLeft();
        }
        this.x--;
    }

    /**
     * Siirtää palikkaa yhden pykälän oikealle siirtämällä jokaista palaa yhden
     * pykälän oikealle.
     *
     * @see tetris.entity.Part#moveRight()
     */
    @Override
    public void moveRight() {
        for (Part part : this.parts) {
            part.moveRight();
        }
        this.x++;
    }

    /**
     * Kääntää palikkaa vastapäivään. Ensin palikka siirretään origokeskeiseksi.
     * Tämän jälkeen jokaisen palan koordinaatteja muutetaan
     * matriisikertolaskulla. Lopuksi palikka siirretään takaisin entiseen
     * paikkaansa.
     *
     * @see tetris.entity.Block#move(int, int)
     * @see tetris.entity.Part#newCoordinates(int, int)
     */
    public void rotateLeft() {
        int dx = this.x;
        int dy = this.y;
        move(-dx, -dy);
        int newX, newY;
        for (Part part : parts) {
            newX = part.getYCoordinate();
            newY = -part.getXCoordinate();
            part.newCoordinates(newX, newY);
        }
        move(dx, dy);
    }

    /**
     * Kääntää palikkaa myötäpäivään. Ensin palikka siirretään origokeskeiseksi.
     * Tämän jälkeen jokaisen palan koordinaatteja muutetaan
     * matriisikertolaskulla. Lopuksi palikka siirretään takaisin entiseen
     * paikkaansa.
     *
     * @see tetris.entity.Block#move(int, int)
     * @see tetris.entity.Part#newCoordinates(int, int)
     */
    public void rotateRight() {
        int dx = this.x;
        int dy = this.y;
        move(-dx, -dy);
        int newX, newY;
        for (Part part : parts) {
            newX = -part.getYCoordinate();
            newY = part.getXCoordinate();
            part.newCoordinates(newX, newY);
        }
        move(dx, dy);
    }

    /**
     * @return Taulukko palikan paloista
     */
    public Part[] getParts() {
        return parts;
    }

    /**
     * @return Palikan x-koordinaatti
     */
    public int getX() {
        return x;
    }

    /**
     * @return Palikan y-koordinaatti
     */
    public int getY() {
        return y;
    }

}
