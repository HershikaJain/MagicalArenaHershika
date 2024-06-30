import java.util.Random;

class Player {
    private int health;
    private int strength;
    private int attack;
    private Random random;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.random = new Random();
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attackRoll() {
        return random.nextInt(6) + 1;
    }

    public int defendRoll() {
        return random.nextInt(6) + 1;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
    }

    @Override
    public String toString() {
        return "Player{" +
                "health=" + health +
                ", strength=" + strength +
                ", attack=" + attack +
                '}';
    }
}

public class MagicalArena {

    public static void battle(Player player1, Player player2) {
        Player attacker, defender;

        while (player1.isAlive() && player2.isAlive()) {
            // Determine who attacks first
            if (player1.getHealth() <= player2.getHealth()) {
                attacker = player1;
                defender = player2;
            } else {
                attacker = player2;
                defender = player1;
            }

            // Attacker's turn
            int attackRoll = attacker.attackRoll();
            int defendRoll = defender.defendRoll();
            int damage = (attacker.getAttack() * attackRoll) - (defender.getStrength() * defendRoll);

            if (damage > 0) {
                defender.reduceHealth(damage);
            }

            System.out.println(attacker + " attacks " + defender);
            System.out.println("Attacker rolls " + attackRoll + ", Defender rolls " + defendRoll);
            System.out.println("Damage dealt: " + damage + ", Defender's remaining health: " + defender.getHealth());

            // Check if defender is still alive
            if (!defender.isAlive()) {
                System.out.println(defender + " is dead. " + attacker + " wins!");
                return;
            }

            // Switch roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    public static void main(String[] args) {
        // Creating two players
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        // Running the battle simulation
        battle(playerA, playerB);
    }
}


