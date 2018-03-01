package weapons;

public class LongRangeWeapon extends Weapon {

    private LongRangeWeapon(Weapon copyRef) {
        super(copyRef);
    }

    LongRangeWeapon() {
        super();
    }

    @Override
    public Weapon copy() {
        return new LongRangeWeapon(this);
    }
}
