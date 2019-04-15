import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_instantiateCorrectly_true() {
        Hero myHero = new Hero("Batman", "45", "Batarangs", "catwoman", "Domination");
        assertTrue(myHero instanceof Hero); //to instantiate an object for the class
    }

    @Test
    public void getName_getNameForHeroes_String() {
        Hero myHero = new Hero("Batman", "45", "Batarangs", "catwoman", "Domination");
        String expected = "Batman";
        assertEquals(expected, myHero.getmName());
    }

    @Test
    public void getAge_getAgeForHeroes_int() {
        Hero myHero = new Hero("Batman", "45", "Batarangs", "catwoman", "Domination");
        String expected = "45";
        assertEquals(expected, myHero.getmAge());
    }

    @Test
    public void getPower_getPowerForHeroes_String() {
        Hero myHero = new Hero("Batman", "45", "Batarangs", "catwoman", "Domination");
        String expected = "Batarangs";
        assertEquals(expected, myHero.getmSuperpower());
    }

    @Test
    public void getWeakness_getWeaknessForHeroes_String() {
        Hero myHero = new Hero("Batman", "45", "Batarangs", "catwoman", "Domination");
        String expected = "catwoman";
        assertEquals(expected, myHero.getmWeakness());
    }
    @Test
    public void getWeakness_getCauseForHeroes_String() {
        Hero myHero = new Hero("Batman", "45", "Batarangs", "catwoman", "Domination");
        String expected = "Domination";
        assertEquals(expected, myHero.getmCause());
    }
}