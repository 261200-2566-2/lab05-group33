import java.util.ArrayList;

class Archer extends Character {

    public Archer(int level) {
        super(level);
        hp = 200;
        maxHP = 200;
        defensePower = 2;
        attackPower = 15 + 1.0 * level;
        accessoryNumMax = 3;
        role = "Archer";
        skillcount = new int[] {6,2,2,2};
        skillList = new ArrayList < String > ();
        accessoryList = new ArrayList < Accessory > ();
        skillList.add("Normal Attack");
        skillList.add("Double Shot");
        skillList.add("Piercing Arrow");
        skillList.add("Evasion");
    }

    public void doubleShot(Character target) {
        if (isAlive()) {
            skillcount[1]--;
            if (skillcount[1] > 0) {
                System.out.println();
                System.out.println(role + " shoots two arrows at " + target.role);
                target.hp -= Math.round(attackPower * 2 * 5) / 5d;
                if (target.hp < 0)
                    target.hp = 0;
                displayHealthBar();
                target.displayHealthBar();
            }
        } else {
            System.out.println(role + " is dead and cannot attack!");
        }
    }

    public void piercingArrow(Character target) {
        if (isAlive()) {
            skillcount[2]--;
            if (skillcount[2] > 0) {
                System.out.println();
                System.out.println(role + " shoots a piercing arrow at " + target.role);
                target.hp -= Math.round(attackPower * 1.3 * 5) / 5d;
                if (target.hp < 0)
                    target.hp = 0;
                System.out.println("The arrow pierce thru " + target.role + " shield");
                target.displayHealthBar();
            }

        } else {
            System.out.println(role + " is dead and cannot attack!");
        }

    }

    public void evation(Character target) {
        if (isAlive()) {
            skillcount[3]--;
            if (skillcount[3] > 0) {
                System.out.println();
                System.out.println(role + " evades " + target.role + "'s attack");
                displayHealthBar();
                target.displayHealthBar();
            }

        } else {
            System.out.println(role + " is dead and cannot attack!");
        }

    }

}