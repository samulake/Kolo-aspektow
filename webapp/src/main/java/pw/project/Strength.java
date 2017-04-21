package pw.project;

public class Strength extends CharacteristicTrait {
	private String adjoiningSphere;
	private String mainSphere;

	public Strength() {}
	
	public Strength(String name, String adjoiningSphere, String mainSphere) {
		super.setName(name);
		this.adjoiningSphere = adjoiningSphere;
		this.mainSphere = mainSphere;
		super.setValue(3);
	}
	
	public String getAdjoiningSphere() {
		return adjoiningSphere;
	}

	public void setAdjoiningSphere(String adjoiningSphere) {
		this.adjoiningSphere = adjoiningSphere;
	}

	public String getMainSphere() {
		return mainSphere;
	}

	public void setMainSphere(String mainSphere) {
		this.mainSphere = mainSphere;
	}

}
