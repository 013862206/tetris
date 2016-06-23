
##Rakennekuvaus

###Käyttöliittymä

Käyttöliittymä koostuu aloitusvalikosta ja peli-ikkunasta. Aloitusvalikon kautta luodaan uusi peli-olio ja sen graafiikkaa hallinnoima peli-ikkuna. Peli-ikkunaan on liitettynä näppäinten painalluksia hallinnoiva luokka GameKeyListener, jonka tehtävänä on ohjailla pelin-olion konstruoimaa pelipalikkaa pelaajan painamien näppäinten perusteella. Jotta pelipalikkaa voidaan liikuttaa ja grafiikkaa päivittää liikkeiden mukaisesti, näppäimistön kuuntelija tuntee sekä tämän hetkisen peli-olion että peliä piirtävän peli-ikkunan. Peli-ikkuna taas tuntee sen luoneen aloitusvalikon, jotta valikkoon voidaan myöhemmin palata.

###Pelilogiikka

Pelilogiikka koostuu viidestä eri peliä hallinnoivasta luokasta: BlockLogic-, BlockRandomizer-, TableLogic-, PointStatistics- ja Game-luokasta. BlockRandomizer-luokka vastaa uusien pelipalikoiden arpomisesta ja konstruoimisesta. PointStatistics-luokka pitää kirjaa pelin tilastoista: pisteistä, tuhotuista riveistä, luoduista pelipalikoista sekä tämän hetkisestä pelin vaikeustasosta. BlockLogic-luokan avulla hallinnoidaan pelipalikan liikuttelua. Luokka sisältää metodeja, joiden avulla tarkistetaan, voiko pelipalikkaa liikuttaa tai kääntää haluttuu suunntaan. TableLogic-luokka tarkistaa pelilaudan tilannetta: etsii täydet rivit ja tuhoaa ne. Game-luokan tehtävänä on hallinnoida itse peliä. Se käyttää kaikkia edellä mainittuja luokkia apunaan pelin pyörittämiseen.

###Pelielementit

Pelipalikat ovat abstraktin luokan Block perivien luokkien ilmentymiä. Block-luokka vastaa pelipalikoiden liikuttelusta ja sen perivät luokat erilaisten pelipalikoiden ilmentymistä. Jokainen pelipalikka koostu neljästä Part-luokan oliosta. Jokainen pelipalikka koostuu neljästä palasta. Yhtä palikan palaa vastaa yksi Part-luokan olio. Jokainen pala tuntee oman sijaintinsa ja värinsä. Kun pelipalikkaa halutaan siirtää, jokaista pelipalikan palaa siirretään. Sekä Block- että Part-luokka perii rajapinnan Moveable, joka määrittelee että sen perivillä luokilla on oltava metodit moveDown(), moveRight() ja moveLeft(). Pelilaudan ilmentymänä toimii Table-luokka, johon Part-luokan olioita voi tallentaa. Teoriassa pelipalikat liikkuvat pelilaudalla, mutta käytännössä ne liitetään Table-luokan pelilautaolioon vasta niiden saavuttaessa pelilaudalla jo olevan pelipalikan tai pelilaudan alalaidan.  

###Pelielementit



##Luokkakaavio

![Luokkakaavio](TetrisClassDiagram.png)

##Sekvenssikaaviot:

![Palikan siirto] (Sekvenssikaaviot/Palikan siirtäminen oikealle.png)

![Palikan kääntö] (Sekvenssikaaviot/Palikan kääntäminen myötäpäivään.png)

Alla on avattu tarkemmin mitä BlockLogic.canRotateRight-metodin sisällä tapahtuu, kun pelipalikkaa voi kääntää oikealle. Metodin sisällä kutsutaan vielä metodeja isInTable ja CanPlace. Niiden rakenteet on jätetty pois kaaviosta, jotta kaavion luettavuus ei kärsisi.

![BlockLogic] (Sekvenssikaaviot/BlockLogic.canrotateRight.png)
