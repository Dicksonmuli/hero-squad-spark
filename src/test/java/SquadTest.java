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

  @Test
  public void clear_emptiesAllSquadsFromList_0() {
    Squad.clear();
    assertEquals(Squad.all().size(), 0);
  }
// the first squad instantiates with id 1
  @Test
  public void getId_squadInstantiatesWithAnId_1() {
    assertEquals(1, testSquad.getId());
  }
//finds a squad with a certain id
  @Test
  public void find_returnsSquadWithSameId_testSquadTwo() {
		Squad testSquadTwo = new Squad("X-men", 5, "computer illiteracy");
    assertEquals(Squad.find(testSquadTwo.getId()), testSquadTwo);
  }
//heroes list is empty innitally
  @Test
  public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
    assertEquals(0, testSquad.getHeroes().size());
  }
//adds heros to a squad
  @Test
  public void addHeroes_addHeroToList_true(){
    Squad.clear();
    Hero testHero = new Hero("NinjaMan",  30, "Strength, speed", "cannot run");
    testSquad.addHero(testHero);
    assertTrue(testSquad.getHeroes().contains(testHero));
  }
}
