
import java.util.ArrayList;

class Knight extends Character {

    public Knight(int level) {
        super(level);
        hp = 200;
        maxHP = 200;
        defensePower = 5;
        attackPower = 5 + 1.5 * level;
        accessoryNumMax = 3;
        role = "Knight";
        skillcount = new int[] { 6, 2, 2, 2 };
        skillList = new ArrayList<String>();
        accessoryList = new ArrayList<Accessory>();
        skillList.add("Normal Attack");
        skillList.add("Bash");
        skillList.add("Counter Attack");
        skillList.add("Block");

        S_description = new String[] {};
    }

    public void Bash(Character target) {
        if (isAlive()) {
            skillcount[1]--;
            if (skillcount[1] > 0) {
                System.out.println();
                System.out.println(role + " used bash");
                target.hp -= Math.round(attackPower * 1.5 * 5) / 5d;

                if (target.hp < 0)
                    target.hp = 0;
                displayHealthBar();
                target.displayHealthBar();
            }

        } else {
            System.out.println(role + " is dead and cannot attack!");
        }
    }

    public void CounterAttack(Character target) {
        if (isAlive()) {
            skillcount[2]--;
            if (skillcount[2] > 0) {
                System.out.println();
                System.out.println(role + " used counter attack");
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

    public void Block(Character target) {
        if (isAlive()) {

            skillcount[3]--;
            if (skillcount[3] >= 0) {
                System.out.println();
                System.out.println(role + " used block.");
            }

        } else {
            System.out.println(role + " is dead and cannot attack!");
        }
    }

}