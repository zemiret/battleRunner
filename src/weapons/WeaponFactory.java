package weapons;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WeaponFactory {
    private static WeaponFactory _instance = new WeaponFactory();

    public static WeaponFactory getInstance() {
        return _instance;
    }

    /**
     * String - name of the weapon in camelCase - deduced from file name
     * */
    private HashMap<String, IWeapon> weaponsMap;

    private WeaponFactory() {
        Map<String, String> env = System.getenv();
        String projectDir = env.getOrDefault("PROJECT_DIR", env.get("PWD"));

        String resDirectory = projectDir + "/res";

        File[] weaponFiles = new File(resDirectory).listFiles();

        for (File weaponFile : weaponFiles) {
            String fileName = weaponFile.getName();
            String key = fileName.substring(0, fileName.lastIndexOf('.'));

            // TODO: Waaaait... How do I exactly create a proper class here? Rethink it once you're fresh!
            /*
            * Maybe sth like a mixed approach to factories? Like checking types while loading and creating
            * proper classes and using prototype map for creating instances...
            * Or maybe it is possible to hold constructor functions in map? or get them dynamically somehow?
            * Look into getClass() or sth.
            * */
        }
    }
}
