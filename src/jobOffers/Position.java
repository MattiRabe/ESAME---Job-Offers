package jobOffers;

import java.util.HashMap;

public class Position {

    private String role;
    private HashMap<String, Integer> skills = new HashMap<>();

    
    public Position(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public HashMap<String, Integer> getSkills() {
        return skills;
    }

    public void addSkill(String s){
        String skill[]=s.split(":");
        skills.put(skill[0], Integer.parseInt(skill[1]));
    }

    public Integer getAverage(){
        Integer sum=0;
        for(Integer i : skills.values()) sum+=i;
        return sum/skills.size();
    }

    

}
