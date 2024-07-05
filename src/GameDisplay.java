package JAVA.Projects.AliensHumans;

public class GameDisplay {
    public void displayGameStart(){
        System.out.println("Welcome to Human VS Alien Game!");
        System.out.println("You are a human and you have to fight against aliens!");
        System.out.println("Game started!");
    }

    public void diplayHumanState(Human human){
        System.out.println("Your current state:");
        if (human.healthPoints < 0){
            human.healthPoints = 0;
        }
        System.out.println("Health: "+human.healthPoints);
    }

    public void diplayAlienState(Alien alien){
        System.out.println("Alien's current state:");
        if (alien.healthPoints < 0){
            alien.healthPoints = 0;
        }
        System.out.println("Health: "+alien.healthPoints);
    }   
    
    public void displayHumanWeapon(Human human){
        System.out.print("\nYou chose "+human.weapon.name+" - "+human.weapon.description);
        System.out.println(" : You have "+human.weapon.attackPower+" damage points\n");
    }

    public void displayHumanSkill(Human human){
        System.out.print("\nYou chose "+human.skill.name+". ");
        System.out.println("You"+human.skill.description+ "\n");
    }

    public void displayAlienWeapon(Alien alien){
        System.out.print("Alien chose "+alien.weapon.name+" - "+alien.weapon.description);
        System.out.println(" : This weapon has "+alien.weapon.attackPower+" damage points");
    }

    public void displayAlienSkill(Alien alien){
        System.out.print("\nAlien chose "+ alien.skill.name+". ");
        System.out.println("Alien "+alien.skill.description);
        System.out.println("This skill has "+alien.skill.attackPower+" damage points and "+alien.skill.defensePoint +" defense points.");               
        
    }
}
