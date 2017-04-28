public class Hero {
	private String mName;
	private int mAge;
	private String mAbility;
	private String mWeakness;

	public Hero(String name, int age, String ability, String weakness) {
		mName = name;
		mAge = age;
		mAbility = ability;
		mWeakness = weakness;
	}

	public String getName() {
		return mName;
	}

	public int getAge() {
		return mAge;
	}

	public String getAbility() {
		return mAbility;
	}

	public String getWeakness() {
		return mWeakness;
	}
}
