package chap6.encapsulation;

// 내부 코드를 바꾸어도 다른 코드에 영향을 주지 않는다.
public class EnhancedPlayer {
    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name){
        this(name, 100, "Sword");
    }

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;

        if(health <= 0){
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }

        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        health -= damage;

        if(health <= 0){
            System.out.println("Player knocked out of game");
        }
    }

    public int healthRemaining(){
        return health;
    }

    public void restoreHealth(int extraHealth){
        this.health += extraHealth;
        if(health > 100){
            System.out.println("Player restored to 100%");
            health = 100;
        }
    }
}