import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mName;
    private String mAge;
    private String mSuperpower;
    private String mWeakness;
    private  String mCause;
    private static List<Hero> instances = new ArrayList<Hero>();

    public Hero(String name, String age, String superpower, String weakness ,String cause) {
        mName = name;
        mAge = age;
        mSuperpower = superpower;
        mWeakness = weakness;
        mCause= cause;
        instances.add(this);
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

    public String getmCause() {
        return mCause;
    }

    public static List<Hero> all() {
        return instances;
    }

}

