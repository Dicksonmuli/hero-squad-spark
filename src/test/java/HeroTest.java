import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
	private Hero testHero;
	//executes before each test
	@Before
	public void instanciate() {
		testHero = new Hero("NinjaMan",  30, "Strength, speed", "cannot run");
	}
//executes after every test
	// @After
	// public void tearDown() {
	// 	Hero.clear();
	// }
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

}
