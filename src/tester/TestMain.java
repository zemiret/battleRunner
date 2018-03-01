package tester;

import weapons.ShortRangeWeapon;
import weapons.Weapon;
import weapons.WeaponFactory;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("Test main");


//        Weapon weapon = WeaponFactory.getInstance().getWeapon("dagger");
//        Weapon weapon1 = WeaponFactory.getInstance().getWeapon("bow");

//        System.out.println(weapon.stats());
//        System.out.println(weapon1.stats());
//        ShortRangeWeapon weapon = new ShortRangeWeapon();


        try {
            System.out.print("Enter Username: ");
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String username = bufferedReader.readLine();

            System.out.println(username);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Map<WeaponTypes, WeaponTypes> env = System.getenv();
//        for (WeaponTypes envName : env.keySet()) {
//            System.out.format("%s=%s%n",
//                    envName,
//                    env.get(envName));
//        }
    }
}
