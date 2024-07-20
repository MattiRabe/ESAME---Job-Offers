package jobOffers;

import java.util.*;
import java.util.stream.Collectors;


public class JobOffers  {

	private HashSet<String> skills = new HashSet<>();
	private HashMap<String, Position> positions = new HashMap<>();
	private HashMap<String, Candidate> candidates = new HashMap<>();
	private HashSet<Application> applications = new HashSet<>();
	private HashMap<String, Consultant> consultants = new HashMap<>();

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
			if(!skills.contains(skill[0])) throw new JOException(position);
			if(Integer.parseInt(skill[1])<4 || Integer.parseInt(skill[1])>8) throw new JOException(position);
			p.addSkill(s);
		}
		positions.put(position, p);
		
		return p.getAverage();
	}
	
//R2	
	public int addCandidate (String name, String... skills) throws JOException {
		if(candidates.containsKey(name)) throw new JOException(name);
		Candidate c = new Candidate(name);
		for(String s : skills){
			if(!this.skills.contains(s)) throw new JOException(name);
			c.addSkill(s);
		} 
		candidates.put(name, c);

		return c.getSkills().size();
	}
	
	public List<String> addApplications (String candidate, String... positions) throws JOException {
		if(!candidates.containsKey(candidate)) throw new JOException(candidate);
		for(String s : positions){
			if(!this.positions.containsKey(s)) throw new JOException(candidate);
			if(candidates.get(candidate).applicationIsValid(this.positions.get(s))) applications.add(new Application(candidates.get(candidate), this.positions.get(s)));
			else throw new JOException(candidate);
		}

		return applications.stream().filter(a->a.getCandidateName().equals(candidate))
		.sorted(Comparator.comparing(Application::getCandidateName).thenComparing(Application::getPositionName))
		.map(Application::toString).collect(Collectors.toList());
	} 
	
	public TreeMap<String, List<String>> getCandidatesForPositions() {
		return applications.stream().sorted(Comparator.comparing(Application::getPositionName).thenComparing(Application::getCandidateName))
		.collect(Collectors.groupingBy(Application::getPositionName, TreeMap::new, Collectors.mapping(Application::getCandidateName, Collectors.toList())));
	}
	
	
//R3
	public int addConsultant (String name, String... skills) throws JOException {
		if(consultants.containsKey(name)) throw new JOException(name);
		Consultant c = new Consultant(name);
		for(String s : skills){
			if(!this.skills.contains(s)) throw new JOException(name);
			c.addSkill(s);
		} 
		consultants.put(name, c);

		return c.getSkills().size();
	}
	
	public Integer addRatings (String consultant, String candidate, String... skillRatings)  throws JOException {
		if(consultants.get(consultant)==null || candidates.get(candidate)==null) throw new JOException(candidate); 
		for(String s : skillRatings){
			String str[] = s.split(":");
			if(Integer.parseInt(str[1])<4 || Integer.parseInt(str[1])>10) throw new JOException(candidate); 
			candidates.get(candidate).addskillRating(s);
		}
		if(!candidates.get(candidate).areAllRated()) throw new JOException(candidate); 

		return candidates.get(candidate).getAverage();
	}
	
//R4
	public List<String> discardApplications() {
		return null;
	}
	
	 
	public List<String> getEligibleCandidates(String position) {
		return null;
	}
	

	
}

		
