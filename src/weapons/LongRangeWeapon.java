package weapons;

public class LongRangeWeapon extends Weapon {

    public LongRangeWeapon(Weapon copyRef) {
        super(copyRef);
    }

    @Override
    public Weapon copy() {
        return new LongRangeWeapon(this);
    }
}
