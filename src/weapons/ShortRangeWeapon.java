package weapons;

public class ShortRangeWeapon extends Weapon {

    private ShortRangeWeapon(Weapon copyRef) {
        super(copyRef);
    }

    @Override
    public Weapon copy() {
        return new ShortRangeWeapon(this);
    }
}
