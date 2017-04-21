package pw.project.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

import pw.project.Aspect;
import pw.project.CharacteristicTrait;
import pw.project.Hero;
import pw.project.PDFGenerator;
import pw.project.Proficiencies;
import pw.project.Strength;

public class PDFGeneratorTest {
	private PDFGenerator pdfGenerator;
	private Hero hero;

	@Before
	public void setUp() throws Exception {
		hero = new Hero();
		hero.setName("HeroName");
		hero.setInvolvementPool(5);
		hero.setTalePool(4);
		hero.setBaseSignificance(123);

		hero.getStrengthList().add(new Strength("atut1", "Charakter", "Elastycznosc"));
		hero.getStrengthList().add(new Strength("atut2", "Charakter", "Socjalizacja"));
		hero.getStrengthList().add(new Strength("atut3", "Wyrafinowanie", "Elastycznosc"));
		
		List<String> proficiencyList = new ArrayList<String>();
		proficiencyList.add("Walecznosc i zahartowanie");
		proficiencyList.add("Kondycja i sprawnosc");
		proficiencyList.add("Wiedza i obycie");
		hero.getBackgroundAspectList().add(new Aspect("aspekt tla1", 2, proficiencyList));
		hero.getBackgroundAspectList().add(new Aspect("aspekt tla2", 2, proficiencyList));
		
		hero.getRoleAspectList().add(new Aspect("aspekt roli1", 2, proficiencyList));
		hero.getRoleAspectList().add(new Aspect("aspekt roli2", 2, proficiencyList));
		
		hero.getFocusAspectList().add(new Aspect("aspekt skupienia1", 2, proficiencyList));
		hero.getFocusAspectList().add(new Aspect("aspekt skupienia2", 2, proficiencyList));
		
		hero.getSecretList().add(new CharacteristicTrait("secret 1", 2));
		hero.getSecretList().add(new CharacteristicTrait("secret 2", 2));
		hero.getSecretList().add(new CharacteristicTrait("secret 3", 2));
		
		hero.getResourceList().add(new CharacteristicTrait("resource 1", 2));
		hero.getResourceList().add(new CharacteristicTrait("resource 1", 2));
		hero.getResourceList().add(new CharacteristicTrait("resource 1", 2));
		
		hero.getTagList().add(new CharacteristicTrait("tag 1", 2));
		hero.getTagList().add(new CharacteristicTrait("tag 2", 2));
		hero.getTagList().add(new CharacteristicTrait("tag 3", 2));
		
		hero.getExperienceList().add(new CharacteristicTrait("Experience 1", 2));
		hero.getExperienceList().add(new CharacteristicTrait("Experience 2", 2));
		hero.getExperienceList().add(new CharacteristicTrait("Experience 3", 2));
		
		pdfGenerator = new PDFGenerator(hero);
	}

	@Test
	public void test() throws FileNotFoundException, DocumentException {
		pdfGenerator.generate();
	}

}
