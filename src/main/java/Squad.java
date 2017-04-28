import java.util.ArrayList;
import java.util.List;

public class Squad {
	// defining private variables
	private String mName;
	private int mMaxSize;
	private String mReason;
	private static List<Squad> instances = new ArrayList<Squad>();
	private int mId;
	private List<Hero> mHeros;

//constructor that accepts name, maximum size, ability and weakness as input
	public Squad(String name, int maxSize, String reason) {
		mName = name;
		mMaxSize = maxSize;
		mReason = reason;
		instances.add(this);
		mId = instances.size();
		mHeros = new ArrayList<Hero>();

	}
//returns the name
	public String getName() {
		return mName;
	}
//returns the maximum size
	public int getMaximumSize() {
		return mMaxSize;
	}
//returns reason to join a squad
	public String getReason() {
		return mReason;
	}
//returns all instances
	public static List<Squad> all() {
		return instances;
	}
//clears instances
	public static void clear() {
			instances.clear();
	}
//returns the id of the Squad
	public int getId() {
		return mId;
	}
//finds a hero with id
public static Squad find(int id) {
	try {
		return instances.get(id - 1);
	} catch (IndexOutOfBoundsException exception) {
		return null;
	}
}
//returns heroes found in a certain Squad
	public List<Hero> getHeros() {
		return mHeros;
	}
// adds heroes to a Squad
	public void addHero(Hero hero) {
		for(int i =1; i < getMaximumSize(); i++) {
			mHeros.add(hero);
		}
			System.out.println("The maximum size reached!");

	}

}
