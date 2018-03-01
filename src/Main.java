import character.Hero;
import weapons.WeaponFactory;

public class Main {

    public static void main(String[] args) {

        Hero player = new Hero("Ocerolion Kiss-Shot Heart Under Blade",
                100,
                2,
                WeaponFactory.getInstance().getWeapon("dagger"));

        Hero npc = new Hero("Bulbasaur",
                60,
                10,
                WeaponFactory.getInstance().getWeapon("dagger"));

        BattleRunner battleRunner = new BattleRunner(player, npc);


        battleRunner.run();
    }
}
