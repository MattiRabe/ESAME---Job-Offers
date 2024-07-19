package jobOffers;

import java.util.*;


public class JobOffers  {

	private HashSet<String> skills = new HashSet<>();
	private HashMap<String, Position> positions = new HashMap<>();

//R1
	public int addSkills (String... skills) {
		for(String s : skills) this.skills.add(s);
		return this.skills.size();
	}
	
	public int addPosition (String position, String... skillLevels) throws JOException {
		if(positions.containsKey(position)) throw new JOException(position);
		Position p = new Position(position);
		String skill[];
		for(String s: skillLevels){
			skill=s.split(":");
			if(Integer.parseInt(skill[1])<4 || Integer.parseInt(skill[1])>8) throw new JOException(position);
			p.addSkill(s);
		}
		positions.put(position, p);
		
		return p.getAverage();
	}
	
//R2	
	public int addCandidate (String name, String... skills) throws JOException {
		return -1;
	}
	
	public List<String> addApplications (String candidate, String... positions) throws JOException {
		return null;
	} 
	
	public TreeMap<String, List<String>> getCandidatesForPositions() {
		return null;
	}
	
	
//R3
	public int addConsultant (String name, String... skills) throws JOException {
		return -1;
	}
	
	public Integer addRatings (String consultant, String candidate, String... skillRatings)  throws JOException {
		return -1;
	}
	
//R4
	public List<String> discardApplications() {
		return null;
	}
	
	 
	public List<String> getEligibleCandidates(String position) {
		return null;
	}
	

	
}

		
