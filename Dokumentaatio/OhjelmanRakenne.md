
##Rakennekuvaus

###Käyttöliittymä

Käyttöliittymä koostuu aloitusvalikosta ja peli-ikkunasta. Aloitusvalikon kautta luodaan uusi peli-olio ja sen graafiikkaa hallinnoima peli-ikkuna. Peli-ikkunaan on liitettynä näppäinten painalluksia hallinnoiva luokka GameKeyListener, jonka tehtävänä on ohjailla pelin-olion konstruoimaa pelipalikkaa pelaajan painamien näppäinten perusteella. Jotta pelipalikkaa voidaan liikuttaa ja grafiikkaa päivittää liikkeiden mukaisesti, näppäimistön kuuntelija tuntee sekä tämän hetkisen peli-olion että peliä piirtävän peli-ikkunan. Peli-ikkuna taas tuntee sen luoneen aloitusvalikon, jotta valikkoon voidaan myöhemmin palata.

###Pelielementit



##Luokkakaavio

![Luokkakaavio](TetrisClassDiagram.png)

##Sekvenssikaaviot:

![Palikan siirto] (Sekvenssikaaviot/Palikan siirtäminen oikealle.png)

![Palikan kääntö] (Sekvenssikaaviot/Palikan kääntäminen myötäpäivään.png)

Alla on avattu tarkemmin mitä BlockLogic.canRotateRight-metodin sisällä tapahtuu, kun pelipalikkaa voi kääntää oikealle. Metodin sisällä kutsutaan vielä metodeja isInTable ja CanPlace. Niiden rakenteet on jätetty pois kaaviosta, jotta kaavion luettavuus ei kärsisi.

![BlockLogic] (Sekvenssikaaviot/BlockLogic.canrotateRight.png)
