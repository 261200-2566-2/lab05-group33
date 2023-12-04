class Amulet extends Accessory {

    public Amulet(int level) {
        super(level);
        bonusDefencePower = 10 + level * 2;
        name = "Amulet";
    }

}