abstract class Accessory {
    protected String name;
    protected int level;
    protected int bonusAttackPower;
    protected int bonusDefencePower;

    public Accessory(int level) {
        this.level = level;
    }

    public void levelUp() {
        level++;
    }

    public void levelUp(int l) {
        level = level + l;
    }

}