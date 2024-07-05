import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler(Scanner scanner){
        this.scanner = scanner;
    }

    public Weapon getHumanWeaponChoice(){
        List<Weapon> weapons = Arrays.asList(
                new Weapon("Disruptor Pistol", "disables enemies", 10, 0),
                new Weapon("Dragonsbreath Shotgun", "uses flames to harm enemies", 30, 0),
                new Weapon("Machine Gun", "shoots accurately", 20, 0),
                new Weapon("Sniper Rifle", "Highly accurate killer", 40, 0),
                new Weapon("Disruptor Sword", "cuts enemies", 20, 0)
        );
        System.out.println("Choose your weapon:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).name);
        }
        System.out.print("Enter your choice: ");
        while (true) {
        try {
            int weaponChoice = scanner.nextInt();
            if (weaponChoice < 1 || weaponChoice > weapons.size()) {
                System.out.println("Invalid choice. Please choose a number between 1 and " + weapons.size());
            } else {
                return weapons.get(weaponChoice - 1);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // discard invalid input
            }
        } 
    }

    public Skill getHumanSkillChoice(Human human) {
        Skill[] skillsArray = new Skill[] {
            new Skill("Health Boost", " can gain 10 health points", 0, 10),
            new Skill("Lava Shoot", " can block 10 damage from enemy, and deal 40 damage", 40, 10),
            new Skill("Critical Hit", " can deal double damage with your attack", human.weapon.attackPower, 0)
        };
        
        List<Skill> skills = Arrays.asList(skillsArray);
        System.out.println("Choose your skill:");
        for (int i = 0; i < skills.size(); i++){
            System.out.println((i+1) + ". " + skills.get(i).name);
        }
        System.out.print("Enter your choice: ");
        while (true) {
            try {
                int skillChoice = scanner.nextInt();
                if (skillChoice < 1 || skillChoice > skills.size()) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + skills.size());
                } else {
                    return skills.get(skillChoice - 1);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
    } 
} 

    public Weapon getAlienWeaponChoice(){
        List<Weapon> weapons = Arrays.asList(
            new Weapon ("Claws", "damages enemies", 20, 0),
            new Weapon ("Tail Swipe", "knocks humans back", 30, 0),
            new Weapon ("Acid Spray", "damages enemies and their equipment", 40, 0),
            new Weapon ("HeadBitie", "kills human", 50, 0)
        );
        int weaponChoice = randomChoice(weapons.size());
        return weapons.get(weaponChoice - 1);   
    }

    public Skill getAlienSkillChoice(){
        Skill[] skillsArray = new Skill[] {
            new Skill("Regeneration", "can generate its health +10 points",0,10),
            new Skill ("Scream", " can unleash a defeaning scream.", 0,15),
            new Skill ("Acid Puff", "can spray acid at its environment", 30, 0),
            new Skill ("Wall crawling", "can ambush humans from unexpected angles", 30, 0)
        };        
        List<Skill> skills = Arrays.asList(skillsArray);
        int skillChoice = randomChoice(skills.size());
        return skills.get(skillChoice - 1);
    }

    public int randomChoice(int x){
            Random random = new Random();
            return random.nextInt(x)+ 1;
    }
}
