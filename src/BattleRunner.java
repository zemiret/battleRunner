import character.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BattleRunner {

    private Hero player;
    private Hero npc;

    private int turnCounter;

    BattleRunner(Hero player, Hero npc) {
        this.player = player;
        this.npc = npc;

        this.turnCounter = 1;
    }

    private void printStats() {
        System.out.println(this.player.stats());
        System.out.println(this.npc.stats());
    }

    private void playerTurn() {
        int chosenAttack = 0;

        do {
            System.out.println("--- Choose attack ---");
            System.out.println("1) Light attack");
            System.out.println("2) Medium attack");
            System.out.println("3) Heavy attack");

            try {
                InputStreamReader streamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                chosenAttack = Integer.parseInt(bufferedReader.readLine()) ;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                chosenAttack = 0;
            }

        } while (chosenAttack > 3 || chosenAttack < 1);

        this.performAttack(this.player, this.npc, chosenAttack);
    }

    private void performAttack(Hero attacker, Hero victim, int chosenAttack) {
        int damage = 0;

        switch (chosenAttack) {
            case 1:
                damage = attacker.getWeapon().lightAttack();
                break;
            case 2:
                damage = attacker.getWeapon().mediumAttack();
                break;
            case 3:
                damage = attacker.getWeapon().heavyAttack();
                break;
        }

        System.out.println(attacker.getName() + " deals " + Integer.toString(damage) + " damage to " + victim.getName() + "\n");

        // deal damage
        victim.setHp(victim.getHp() - damage);
    }

    private void skipSpeedPenalties() {
        while (this.player.getWeapon().getSpeedPenalty() != 0 && this.npc.getWeapon().getSpeedPenalty() != 0) {
            this.player.getWeapon().tickTurn();
            this.npc.getWeapon().tickTurn();
        }
    }

    private void npcTurn() {
        int attackType = (int) (Math.round(Math.random() * 3));
        this.performAttack(this.npc, this.player, attackType);
    }

    public void run() {
        while (!this.player.isDead() && !this.npc.isDead()) {
            this.printTurn();

            this.printStats();
            this.skipSpeedPenalties();

            // If player can hit:
            if (player.getWeapon().getSpeedPenalty() == 0 && !this.player.isDead())
                this.playerTurn();

            // If npc can hit
            if (npc.getWeapon().getSpeedPenalty() == 0 && !this.npc.isDead())
                this.npcTurn();
        }

        if (this.player.isDead())
            System.out.println("You're dead! " + this.npc.getName() + " won.");
        else
            System.out.println(this.player.getName() + " wins against " + this.npc.getName());
    }

    private void printTurn() {
        System.out.println("------------------------- TURN " + this.turnCounter + "-------------------------");
        ++this.turnCounter;
    }
}
