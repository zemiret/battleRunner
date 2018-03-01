package weapons;

public class MagicWeapon extends Weapon {

    private MagicWeapon(Weapon copyRef) {
        super(copyRef);
    }

    MagicWeapon() {
        super();
    }

    @Override
    public Weapon copy() {
        return new MagicWeapon(this);
    }
}
