public class Hero {
    private String mName;
    private String mAge;
    private String mSuperpower;
    private String mWeakness;

    public Hero(String name, String age, String superpower, String weakness) {
        mName = name;
        mAge = age;
        mSuperpower = superpower;
        mWeakness = weakness;
    }

    public String getmName() {
        return mName;
    }

    public String getmAge() {
        return mAge;
    }

    public String getmSuperpower() {
        return mSuperpower;
    }

    public String getmWeakness() {
        return mWeakness;
    }
}
