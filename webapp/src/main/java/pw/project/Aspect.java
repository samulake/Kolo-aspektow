package pw.project;

import java.util.ArrayList;
import java.util.List;

public class Aspect extends CharacteristicTrait {
	private List<String> assignedProficiencyList = new ArrayList<String>();
	
	public Aspect() {}
	
	public Aspect(String name, int value, List<String> assignedProficiencyList) {
		super.setName(name);
		super.setValue(value);
		this.assignedProficiencyList = assignedProficiencyList;
	}
	
	public List<String> getAssignedProficiencyList() {
		return assignedProficiencyList;
	}

	public void setAssignedProficiencyList(List<String> assignedProficiencyList) {
		this.assignedProficiencyList = assignedProficiencyList;
	}
}
