import character.Character;

public class BattleRunner {

    private Character player;
    private Character npc;

    public BattleRunner(Character player, Character npc) {
        this.player = player;
        this.npc = npc;
    }

    private void printStats() {
        System.out.println(this.player.stats());
        System.out.println("\n");
        System.out.println(this.npc.stats());
        System.out.println("\n");
    }

    private void playerTurn() {
        int input;

        do {
            input = Integer.parseInt(System.console().readLine());

            System.out.println("--- Choose attack ---");
            System.out.println("1) Light attack");
            System.out.println("2) Medium attack");
            System.out.println("3) Heavy attack");

        } while (input > 3 || input < 1);

//        switch (input) {
//            case 1:
//
//        }
    }

    private void playerAttack() {
        // print damage
        // deal damage
    }

    private void skipSpeedPenalties() {
        while(this.player.getWeapon().getSpeedPenalty() != 0 && this.npc.getWeapon().getSpeedPenalty() != 0) {
            this.player.getWeapon().tickTurn();
            this.npc.getWeapon().tickTurn();
        }
    }

    public void run() {
        while (!this.player.isDead() && !this.npc.isDead()) {
            this.printStats();
            this.skipSpeedPenalties();

            // If player can hit:
            if (player.getWeapon().getSpeedPenalty() == 0)
                this.playerTurn();
        }
    }
}
