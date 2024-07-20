package jobOffers;

public class Application {

    private Candidate candidate;
    private Position position;
    private Boolean status;


    public Application(Candidate candidate, Position position) {
        this.candidate = candidate;
        this.position = position;
        status=false;
    }


    public Candidate getCandidate() {
        return candidate;
    }
    public Position getPosition() {
        return position;
    }

    public String getCandidateName() {
        return candidate.getName();
    }
    public String getPositionName() {
        return position.getRole();
    }


    @Override
    public String toString() {
        return candidate.getName() + ":" + position.getRole();
    }


    public Boolean getStatus() {
        return status;
    }

    public void assess(){
        for(String s : position.getSkills().keySet()){
            if(!candidate.getSkillsRatings().containsKey(s) || candidate.getSkillsRatings().get(s)<position.getSkills().get(s)){
                status=false;
                return;
            }
        }
        status=true;
    }
}
