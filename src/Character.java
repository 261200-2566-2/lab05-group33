import java.util.ArrayList;
import java.util.Scanner;

abstract class Character {
    protected String role;
    protected int level;
    protected double hp;
    protected double maxHP;
    protected double attackPower;
    protected double defensePower;
    protected int accessoryNumMax;
    public ArrayList<Accessory> accessoryList;
    protected int[] skillcount;
    public ArrayList<String> skillList;

    protected String[] S_description;
    protected int[] S_Dmg;

    public Character(int level) {
        this.level = level;
    }

    public void attack(Character target) {
        if (this.isAlive()) {
            skillcount[0]--;
            if (skillcount[0] > 0) {
                System.out.println(this.role + " attacked " + target.role + "!");
                double damage = Math.max((this.attackPower - target.defensePower), 0);
                target.hp -= damage;
                if (target.hp < 0) {
                    target.hp = 0;
                }
                displayHealthBar();
                target.displayHealthBar();
            }
        } else {
            System.out.println(this.role + " is dead and cannot attack!");
        }
    }

    public boolean isAlive() {
        if (hp < 0)
            hp = 0;
        return hp > 0;
    }

    public void equipAccessory(Accessory accessory) {
        if (accessoryNumMax > 0) {
            accessoryNumMax -= 1;
            accessoryList.add(accessory);
            System.out.println(role + " equipped " + accessory.name);
            if(accessory.name.equals("Ring")){

                attackPower += accessory.bonusAttackPower;
            }
            if(accessory.name.equals("Amulet")){

                defensePower += accessory.bonusDefencePower;
            }
        } else {
            System.out.println(role + " is full of accessory, can't equip" + accessory.name);
        }
    };

    public void showStatus() {
        System.out.println("     " + role + "'s status " + (hp == 0 ? "(dead)" : ""));
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Defense Power: " + defensePower);
        System.out.println();
    }

    public void LevelUp() {
        level++;
        if (level % 2 == 0) {
            accessoryNumMax++;
        }
    }

    public static Character chooseCharacter() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select class (1: Knight, 2: Archer): ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);

        if (choice == 1) {
            return new Knight(10);
        } else {
            return new Archer(10);
        }
    }

    public void displayHealthBar() {
        int barLength = 20;
        int currentBarLength = (int) ((hp / maxHP) * barLength);
        System.out.print(role + "'s Health Bar: [");
        for (int i = 0; i < currentBarLength; i++) {
            System.out.print("|");
        }
        for (int i = currentBarLength; i < barLength; i++) {
            System.out.print(" ");
        }
        System.out.println("] " + hp + " / " + maxHP);
    }

    public int[] getskillcount() {
        return skillcount;
    }

    public int getaccessoryNumMax() {
        return accessoryNumMax;
    }

}