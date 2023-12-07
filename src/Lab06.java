import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Lab06 {
    public static void main(String[] args) {
        movingText("Welcome to the minimalist RPG game!", 30);
        movingText("CAUTION! Do not let the enemy know your move.", 30);
        movingText("First you have to choose your accessory for your character.", 30);
        Knight char1 = new Knight(10);
        Archer char2 = new Archer(10);
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        boolean endgame = false;
        delay(2);

        // select accessory here
        SelectAccessory(char1, scanner);
        SelectAccessory(char2, scanner);

        while (!endgame) {
            turn++;
            System.out.println();
            movingText(("-------------TURN " + turn + "---------------"), 25);
            delay(2);
            CalculateFight(char1, char2, selectSkill(char1, scanner), selectSkill(char2, scanner));
            endgame = checkEndGame(char1, char2);
        }
        determineWinner(char1, char2);
        scanner.close();
    }

    private static void SelectAccessory(Character character, Scanner scanner){
        movingText("Choose " + character.role + " accessory", 30);
        int Anum = 0;
        while(character.getaccessoryNumMax() > Anum){

            System.out.println("1: Ring [+12 Atk]  2: Amulet [+6 Def] ");
            String accessory = scanner.next();
            if (accessory.equals("1")){
                character.equipAccessory(new Ring(1));

            }
            if (accessory.equals("2")){
                character.equipAccessory(new Amulet(1));

            }

            Anum++ ;
        }

    }

    private static String selectSkill(Character character, Scanner scanner) {
        character.showStatus();
        movingText("Please select your attack option", 20);
        for (int i = 0; i < character.skillList.size(); i++) {
            movingText(
                    "["+ character.getskillcount()[i] + " times left]  " + " #" + (i + 1) + " " + character.skillList.get(i),
                    30);

        }

        while (true) {
            System.out.println("Your option: ");
            String n = scanner.next();
            try {
                int num = Integer.parseInt(n);
                if (num < 1 || num > character.skillList.size()) {
                    movingText("Invalid input!, You must select from 1 to " + character.skillList.size(),15);
                    continue;
                }

                if (character.getskillcount()[num - 1] == 0) {
                    movingText("can no longer use this skill, please select another skill",15);
                    continue;
                }

                return character.skillList.get(num - 1);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!, You must select from 1 to " + character.skillList.size());
            }
        }
    }

    private static void CalculateFight(Knight char1, Archer char2, String c1Skill, String c2Skill) {

        boolean knightBlock = c1Skill.equals("Block");
        boolean archerEvaded = c2Skill.equals("Evasion");

        if (!knightBlock) {
            if (c2Skill.equals("Normal Attack")) {
                char2.attack(char1);
            } else if (c2Skill.equals("Double Shot")) {
                char2.doubleShot(char1);
            }
        } else {
            char1.Block(char2);
            if (c2Skill.equals("Piercing Arrow")) {
                char2.piercingArrow(char1);
            }
        }

        if (!archerEvaded) {
            if (c1Skill.equals("Normal Attack")) {
                char1.attack(char2);
            } else if (c1Skill.equals("Bash")) {
                char1.Bash(char2);
            } else if (c1Skill.equals("Counter Attack")) {
                char1.CounterAttack(char2);
            }
        } else {
            char2.evation(char1);
        }

    }

    private static boolean checkEndGame(Character char1, Character char2) {
        return (!char1.isAlive() || !char2.isAlive());
    }

    private static void determineWinner(Character char1, Character char2) {
        movingText("Game Over!", 20);
        movingText("Game Over!", 20);
        movingText("Game Over!", 20);
        if (char1.hp > char2.hp) {
            movingText(char1.role + " is the winner!", 20);
        } else if (char2.hp > char1.hp) {
            movingText(char2.role + " is the winner!", 20);
        } else {
            movingText("It's a draw!", 20);
        }
    }

    private static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void movingText(String text, int millis) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(millis);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }
}