package jobOffers;

import java.util.HashSet;
import java.util.HashMap;

public class Candidate {

    private String name;
    private HashSet<String> skills = new HashSet<>();
    private HashMap<String, Integer> skillsRatings = new HashMap<>();

    
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


    public HashMap<String, Integer> getSkillsRatings() {
        return skillsRatings;
    }

    public void addskillRating(String s, int val){
        skillsRatings.put(s, val);
    }

    public Boolean areAllRated(){
        if(skills.size()==skillsRatings.size()) return true;
        return false;
    }

    public Integer getAverage(){
        Integer sum=0;
        for(Integer i : skillsRatings.values()) sum+=i;
        return sum/skillsRatings.size();
    }

}
