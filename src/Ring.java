class Ring extends Accessory{

    public Ring(int level){
        super(level);
        bonusAttackPower = 10 + level * 2;
        name = "Ring";

    }

}