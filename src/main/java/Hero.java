// importing java libraries to be used
import java.util.ArrayList;
import java.util.List;

public class Hero {
	// defining private variables
	private String mName;
	private int mAge;
	private String mAbility;
	private String mWeakness;
	private static List<Hero> instances = new ArrayList<Hero>();
	private int mId;

//constructor that accepts name, age, ability and weakness as input
	public Hero(String name, int age, String ability, String weakness) {
		mName = name;
		mAge = age;
		mAbility = ability;
		mWeakness = weakness;
		instances.add(this);
		mId = instances.size();

	}
//returns the name
	public String getName() {
		return mName;
	}
//returns the age
	public int getAge() {
		return mAge;
	}
//returns ability of the hero
	public String getAbility() {
		return mAbility;
	}
//returns weakness of the hero
	public String getWeakness() {
		return mWeakness;
	}
//returns all instances
	public static List<Hero> all() {
		return instances;
	}
//clears instances
	public static void clear() {
			instances.clear();
	}
//returns the id of the hero
	public int getId() {
		return mId;
	}
//finds a hero with id
	public static Hero find(int id) {
		return instances.get(id-1);
	}

}
