import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
	private Hero testHero;
	//executes before each test
	@Before
	public void instanciate() {
		testHero = new Hero("NinjaMan",  30, "Strength, speed", "cannot run");
	}
//executes after every test (clears instances)
	@After
	public void tearDown() {
		Hero.clear();
	}
//instantiates correctly
	public void Hero_instantiatesCorrectly_true() {
		assertTrue(testHero instanceof Hero);
	}
//getName returns hero's name
	public void getName_returnsName_NinjaMan() {
		assertEquals("NinjaMan", testHero.getName());
	}
//getAge returns hero's  age
	public void getAge_returnsAge_30 () {
		assertEquals(30, testHero.getAge());
	}
//getAbility returns hero's  ability
	public void getAbility_returnsAbility_Strength() {
		assertEquals("Strength, speed", testHero.getAbility());
	}
//getWeakness returns hero's weakness
	public void getWeakness_returnsAbility_CannotRun() {
		assertEquals("cannot run", testHero.getWeakness());
	}
//contains all the instances
	public void all_returnsAllInstancesOfHero_true() {
		Hero anotherHero =  new Hero("Commando", 35, "Fighter, use machinegun", "getting old");
		assertTrue(Hero.all().contains(testHero));
		assertTrue(Hero.all().contains(anotherHero));
	}
	@Test
	public void clear_emptiesAllHerosFromList_0() {
		Hero.clear();
		assertEquals(0, Hero.all().size());
	}
//return instance with an id
	@Test
	public void getId_returnsInstantiateWithAnId_1(){
		assertEquals(1, testHero.getId());
	}
//find method returns the hero with the give id
@Test
public void find_returnsHeroWithSameId_AnotherHero(){
	Hero anotherHero = new Hero("NinjaMan",  31, "Strength, speed", "cannot run");
	assertEquals(anotherHero, Hero.find(anotherHero.getId()));
}

}
