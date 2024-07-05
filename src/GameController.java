import java.util.Scanner;

public class GameController {
    public Human human;
    public Alien alien;
    public Scanner scanner;

    public GameController (Human human, Alien alien){
        this.human = human;
        this.alien = alien;
        scanner = new Scanner(System.in);
    }

    public void startGame(){
        GameDisplay gameDisplay = new GameDisplay();
        UserInputHandler userInputHandler = new UserInputHandler(scanner);
        int turn  = 1;
        while(!checkWinCondition()){
            System.out.println("\nTurn "+turn+" :\n");
            if (turn % 2 == 1){
                humanTurn(userInputHandler, gameDisplay);
            }
            else {
                alienTurn(userInputHandler, gameDisplay);
            }        
            System.out.println();
            gameDisplay.diplayHumanState(human);
            gameDisplay.diplayAlienState(alien);
            turn++;         
        }
    }

    public void humanTurn(UserInputHandler userInputHandler, GameDisplay gameDisplay)  {
        System.out.println("Your turn\n");
        Weapon chosenWeapon = userInputHandler.getHumanWeaponChoice();
        human.weapon = chosenWeapon;
        gameDisplay.displayHumanWeapon(human);        
        Skill chosenSkill = userInputHandler.getHumanSkillChoice(human);
        human.skill = chosenSkill;
        gameDisplay.displayHumanSkill(human);
        applyHumanDamageDefensePoints();
 
    }

    public void alienTurn(UserInputHandler userInputHandler, GameDisplay gameDisplay){
        System.out.println("Alien's turn\n");
        Weapon chosenWeapon = userInputHandler.getAlienWeaponChoice();
        alien.weapon = chosenWeapon;
        gameDisplay.displayAlienWeapon(alien);
        Skill chosenSkill = userInputHandler.getAlienSkillChoice();
        alien.skill = chosenSkill;
        gameDisplay.displayAlienSkill(alien);
        applyAlienDamageDefensePoints();
    }   

    public void applyAlienDamageDefensePoints(){
        int damage = alien.weapon.attackPower + alien.skill.attackPower;
        int defense = alien.skill.defensePoint;
        human.healthPoints -= damage;
        alien.healthPoints += defense;
    }
    
    public void applyHumanDamageDefensePoints(){
        int damage = human.weapon.attackPower + human.skill.attackPower;
        int defense = human.skill.defensePoint;
        alien.healthPoints -= damage;
        human.healthPoints += defense;
    }

    public boolean checkWinCondition(){
        if (human.healthPoints <= 0){
            System.out.println("You lost!");
            return true;
        }
        else if (alien.healthPoints <= 0){
            System.out.println("You won!!");
            return true;
        }
        return false;
    }    
}
