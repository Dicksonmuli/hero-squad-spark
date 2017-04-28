import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
	private Hero testHero;

	@Before
	public void instanciate() {
		testHero = new Hero("NinjaMan",  30, "Strength, speed", "cannot run");
	}
}
