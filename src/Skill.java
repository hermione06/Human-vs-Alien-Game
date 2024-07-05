public class Skill {
    String name;
    String description;
    int attackPower;
    int defensePoint;
    // int cooldown; //an integer to store the skill's cooldown period in turns
    
    public Skill(String name, String description, int attackPower, int defensePoint){
        this.name = name;
        this.description = description;
        this.attackPower = attackPower;
        this.defensePoint = defensePoint;
    }
    
}
