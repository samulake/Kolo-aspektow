package pw.project;

import javax.validation.constraints.Size;

public class CharacteristicTrait {
	@Size(min=3, max=30, message="Nazwa musi mieæ conajmniej {min} i maksymalnie {max} znaków!")
	private String name;
	private int value;

	public CharacteristicTrait() {}
	
	public CharacteristicTrait(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
