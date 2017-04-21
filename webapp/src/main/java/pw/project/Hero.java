package pw.project;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import pw.project.Aspect;
import pw.project.CharacteristicTrait;
import pw.project.Strength;

public class Hero {
	@Size(min=3, max=20)
	private String name;

	@Range(min=10, max=9999999)
	private int involvementPool;
	
	@Range(min=10, max=9999999)
	private int talePool;

	private int baseSignificance;
	private List<Strength> strengthList = new ArrayList<Strength>();
	private List<CharacteristicTrait> secretList = new ArrayList<CharacteristicTrait>();
	private List<CharacteristicTrait> resourceList = new ArrayList<CharacteristicTrait>();
	private List<CharacteristicTrait> tagList = new ArrayList<CharacteristicTrait>();
	private List<CharacteristicTrait> experienceList = new ArrayList<CharacteristicTrait>();
	private List<Aspect> backgroundAspectList = new ArrayList<Aspect>();
	private List<Aspect> roleAspectList = new ArrayList<Aspect>();
	private List<Aspect> focusAspectList = new ArrayList<Aspect>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInvolvementPool() {
		return involvementPool;
	}
	public void setInvolvementPool(int involvementPool) {
		this.involvementPool = involvementPool;
	}
	public int getTalePool() {
		return talePool;
	}
	public void setTalePool(int talePool) {
		this.talePool = talePool;
	}
	public int getBaseSignificance() {
		return baseSignificance;
	}
	public void setBaseSignificance(int baseSignificance) {
		this.baseSignificance = baseSignificance;
	}
	public List<Strength> getStrengthList() {
		return strengthList;
	}
	public void setStrengthList(List<Strength> strengthList) {
		this.strengthList = strengthList;
	}
	public List<CharacteristicTrait> getSecretList() {
		return secretList;
	}
	public void setSecretList(List<CharacteristicTrait> secretList) {
		this.secretList = secretList;
	}
	public List<CharacteristicTrait> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<CharacteristicTrait> resourceList) {
		this.resourceList = resourceList;
	}
	public List<CharacteristicTrait> getTagList() {
		return tagList;
	}
	public void setTagList(List<CharacteristicTrait> tagList) {
		this.tagList = tagList;
	}
	public List<CharacteristicTrait> getExperienceList() {
		return experienceList;
	}
	public void setExperienceList(List<CharacteristicTrait> experienceList) {
		this.experienceList = experienceList;
	}
	public List<Aspect> getBackgroundAspectList() {
		return backgroundAspectList;
	}
	public void setBackgroundAspectList(List<Aspect> backgroundAspectList) {
		this.backgroundAspectList = backgroundAspectList;
	}
	public List<Aspect> getRoleAspectList() {
		return roleAspectList;
	}
	public void setRoleAspectList(List<Aspect> roleAspectList) {
		this.roleAspectList = roleAspectList;
	}
	public List<Aspect> getFocusAspectList() {
		return focusAspectList;
	}
	public void setFocusAspectList(List<Aspect> focusAspectList) {
		this.focusAspectList = focusAspectList;
	}

	
}
