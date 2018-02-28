package weapons;

public class MagicWeapon extends Weapon {
    public MagicWeapon(Weapon copyRef) {
        super(copyRef);
    }

    @Override
    public Weapon copy() {
        return new MagicWeapon(this);
    }
}
