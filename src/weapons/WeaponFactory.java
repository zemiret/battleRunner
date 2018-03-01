package weapons;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class WeaponFactory implements IWeaponFactory {
    private static WeaponFactory _instance = new WeaponFactory();

    public static WeaponFactory getInstance() {
        return _instance;
    }

    /**
     * WeaponTypes - name of the weapon in camelCase - deduced from file name
     * */
    private HashMap<String, Weapon> weaponsMap = new HashMap<>();

    private WeaponFactory() {
        Map<String, String> env = System.getenv();
        String projectDir = env.getOrDefault("PROJECT_DIR", env.get("PWD"));

        String weaponsResDir = projectDir + "/res/weapons";

        File[] weaponFiles = new File(weaponsResDir).listFiles();

        for (File weaponFile : weaponFiles) {
            String fileName = weaponFile.getName();
            String key = fileName.substring(0, fileName.lastIndexOf('.'));

            try {
                FileReader reader = new FileReader(weaponFile);
                Weapon weapon = this.createInstance(reader);

                weapon.load(weaponFile);
                this.weaponsMap.put(key, weapon);
            } catch (FileNotFoundException err) {
                err.printStackTrace();
            }
        }
    }

    private Weapon createInstance(FileReader reader) {
        try {
            JsonObject weaponObj = Json.parse(reader).asObject();
            WeaponTypes type = WeaponTypes.valueOf(weaponObj.getString("type", "SHORT_RANGE"));

            switch (type) {
                case LONG_RANGE:
                    return new LongRangeWeapon();
                case SHORT_RANGE:
                    return new ShortRangeWeapon();
                case MAGIC:
                    return new MagicWeapon();
            }
        } catch (IOException err) {
            err.printStackTrace();
        }

        return null;
    }

    @Override
    public Weapon getWeapon(String weaponName) {
        return this.weaponsMap.get(weaponName).copy();
    }
}
