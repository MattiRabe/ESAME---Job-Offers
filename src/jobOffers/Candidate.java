package jobOffers;

import java.util.HashSet;

public class Candidate {

    private String name;
    private HashSet<String> skills = new HashSet<>();

    
    public Candidate(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public HashSet<String> getSkills() {
        return skills;
    }

    public void addSkill(String s ){
        skills.add(s);
    }

    public Boolean applicationIsValid(Position p){
        for(String s : p.getSkills().keySet()){
            if(!this.skills.contains(s)) return false;
        }
        return true;
    }


}
