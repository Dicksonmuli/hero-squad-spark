import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
//runs before every test to instantiate an object of squad;
	Squad testSquad;

	@Before
	public void instantiateSquad() {
		testSquad = new Squad("NinjaSquad", 4, "computer illiteracy");
	}
	//clears after every test
  @After
  public void tearDown() {
    Squad.clear();
  }
//instances
  @Test
  public void Squad_instantiatesCorrectly_true() {
    assertTrue(testSquad instanceof Squad);
  }
//squad name
  @Test
  public void getName_teamInstantiatesWith_NinjaSquad() {
    assertEquals("NinjaSquad", testSquad.getName());
  }
//maximum size of the squad
	@Test
	public void getMaximumSize_teamInstantiatesWithTeam_4() {
		assertEquals(4, testSquad.getMaximumSize());
	}
//reason for joining the team
	@Test
	public void getReason_teamInstantiatesWithTeam_ComputerIlliteracy() {
		assertEquals("computer illiteracy", testSquad.getReason());
	}
//all instances
  @Test
  public void all_returnsAllInstancesOfSquad_true() {
    Squad testSquadTwo = new Squad("X-men", 5, "computer illiteracy");
    assertEquals(true, Squad.all().contains(testSquad));
    assertEquals(true, Squad.all().contains(testSquadTwo));
  }

  // @Test
  // public void clear_emptiesAllSquadsFromList_0() {
  //   Squad testSquad = new Squad("Avengers");
  //   Squad.clear();
  //   assertEquals(Squad.all().size(), 0);
  // }
	//
  // @Test
  // public void getId_squadInstantiatesWithAnId_1() {
  //   Squad testSquad = new Squad("Avengers");
  //   assertEquals(1, testSquad.getId());
  // }
	//
  // @Test
  // public void find_returnsSquadWithSameId_testSquadTwo() {
  //   Squad testSquadOne = new Squad("Avengers");
  //   Squad testSquadTwo = new Squad("X-men");
  //   assertEquals(Squad.find(testSquadTwo.getId()), testSquadTwo);
  // }
	//
  // @Test
  // public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
  //   Squad testSquad = new Squad("Avengers");
  //   assertEquals(0, testSquad.getHeroes().size());
  // }
	//
  // @Test
  // public void addHeroes_addHeroToList_true(){
  //   Squad.clear();
  //   Hero testHero = new Hero("Superman", "Strength, Flight, Laser Eyes", "DC");
  //   Squad testSquad = new Squad("Avengers");
  //   testSquad.addHero(testHero);
  //   assertTrue(testSquad.getHeroes().contains(testHero));
  // }
}
