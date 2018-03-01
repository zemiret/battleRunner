package weapons;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import utils.ICopyable;
import utils.ILoadable;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.lang.String;

public abstract class Weapon implements IWeapon, ILoadable, ICopyable<Weapon> {
    private String name;
    private int baseDamage;
    private WeaponTypes type;
    private int speed;

    static private HashMap<WeaponTypes, String> weaponTypesNames = new HashMap<>();

    static {
        weaponTypesNames.put(WeaponTypes.SHORT_RANGE, "Short range");
        weaponTypesNames.put(WeaponTypes.LONG_RANGE, "Long range");
        weaponTypesNames.put(WeaponTypes.MAGIC, "Magic");
    }

    Weapon(Weapon copyRef) {
        this.name = copyRef.name;
        this.baseDamage = copyRef.baseDamage;
        this.type = copyRef.type;
        this.speed = copyRef.speed;
    }

    Weapon() {}

    @Override
    public void load(File file) {
        try {
            FileReader reader = new FileReader(file);
            JsonObject weaponObj = Json.parse(reader).asObject();

            this.name = weaponObj.getString("name", "Unknown Weapon");
            this.baseDamage = weaponObj.getInt("baseDamage", 0);
            this.type = WeaponTypes.valueOf(weaponObj.getString("type", "SHORT_RANGE"));
            this.speed = weaponObj.getInt("speed", 10);     // 10 - penalty for not existing. XD

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public String stats() {
        return name + "\n" +
                "Type: " + Weapon.weaponTypesNames.get(this.type) + "\n" +
                "Base damage: " + this.baseDamage + "\n" +
                "Speed: " + this.speed + "\n";
    }

    /**
     * @return int baseDamage + 1k4
     * */
    @Override
    public int lightAttack() {
        return (int)(Math.round(Math.random() * 4) + baseDamage);
    }

    /**
     * @return int baseDamage + 1k6
     * */
    @Override
    public int mediumAttack() {
        return (int)(Math.round(Math.random() * 6) + baseDamage);
    }

    /**
     * @return int baseDamage + 1k8
     * */
    @Override
    public int heavyAttack() {
        return (int)(Math.round(Math.random() * 8) + baseDamage);
    }
}
