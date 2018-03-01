package character;

import weapons.Weapon;

public class Character {

    private String name;
    private int hp;
    private int strength;

    private Weapon weapon;

    public Character(String name, int hp, int strength, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isDead() {
        return this.getHp() <= 0;
    }

    public String stats() {
        return this.name + "\n" +
                "HP: " + this.hp + "\n" +
                "strength: " + this.strength + "\n";
    }
}
