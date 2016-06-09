package tetris.entity;

/**
 * Luokka kuvastaa pelilautaa, jossa palikoita voi liikutella ja johon
 * pelipalikan paloja voi tallentaa. Pelilauta on toteutettu kaksiulotteisena
 * taulukkona.
 */
public class Table {

    private Part[][] table;

    /**
     * Luo uuden parametrien kokoisen pelilautataulukon.
     *
     * @param width Uuden pelilautataulukon leveys
     * @param height UUden pelilautataulukon korkeus
     */
    public Table(int width, int height) {
        this.table = new Part[height][width];
    }

    /**
     * Kiinnittää pelipalikan palat pelilautataulukkoon. Palikan y-koordinaatti
     * kuvastaa riviä ja x-koordinaatti saraketta taulukossa.
     *
     * @param block Kiinnitettävä pelipalikka
     */
    public void addBlock(Block block) {
        for (Part part : block.getParts()) {
            table[part.getYCoordinate()][part.getXCoordinate()] = part;
        }
    }

    /**
     * Tarkistaa onko parametrien osoittama paikka pelitaulukossa vapaana.
     *
     * @param x taulukon sarake
     * @param y taulukon rivi
     * @return Totuusarvo siitä, onko paikka vapaana
     */
    public boolean isFree(int x, int y) {
        if (table[y][x] == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return Pelilautataulukko
     */
    public Part[][] getTable() {
        return this.table;
    }

    /**
     * @return Pelilautataulukon korkeus
     */
    public int getHeight() {
        return table.length;
    }

    /**
     * @return Pelilautataulukon leveys
     */
    public int getWidth() {
        return table[0].length;
    }

}
