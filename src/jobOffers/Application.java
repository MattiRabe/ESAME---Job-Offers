package jobOffers;

public class Application {

    private Candidate candidate;
    private Position position;


    public Application(Candidate candidate, Position position) {
        this.candidate = candidate;
        this.position = position;
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

}
