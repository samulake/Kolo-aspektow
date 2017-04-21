package pw.project;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;

import pw.project.Hero;
import pw.project.PDFGenerator;
import pw.project.CharacteristicTrait;

@Controller
public class OtherDataController {
	private ModelAndView modelAndView;
	private Hero hero;

	@ModelAttribute
	public void addCommonAtributes(Model model) {
		model.addAttribute("stepsMessage", "Krok 4 z 4");
	}

	@RequestMapping(value = "otherData.html")
	public ModelAndView getOtherDataForm(HttpServletRequest request) {
		modelAndView = new ModelAndView("otherData");
		this.hero = (Hero) request.getAttribute("hero");
		return modelAndView;
	}

	@RequestMapping(value = "addOther")
	public ModelAndView addData(@Valid @ModelAttribute("trait") CharacteristicTrait trait, BindingResult result,
			@RequestParam Map<String, String> paramMap) {
		String type = paramMap.get("type");
		modelAndView = new ModelAndView("otherData");
		if (!result.hasErrors()) {
			if (type.equals("SECRET")) {
				hero.getSecretList().add(trait);
			} else if (type.equals("RESOURCE")) {
				hero.getResourceList().add(trait);
			} else if (type.equals("TAG")) {
				hero.getTagList().add(trait);
			} else if (type.equals("EXPERIENCE")) {
				hero.getExperienceList().add(trait);
			}
		}
		modelAndView.addObject("secretList", hero.getSecretList());
		modelAndView.addObject("resourceList", hero.getResourceList());
		modelAndView.addObject("tagList", hero.getTagList());
		modelAndView.addObject("experienceList", hero.getExperienceList());
		return modelAndView;
	}

	@RequestMapping(value = "generatePDF", method = RequestMethod.POST)
	public ModelAndView submit() throws FileNotFoundException, DocumentException {
		modelAndView = new ModelAndView("generatePDF");
		sumBaseSignificance();
		PDFGenerator PDFGenerator = new PDFGenerator(hero);
		PDFGenerator.generate();
		return modelAndView;
	}

	private void sumBaseSignificance() {
		for (Strength strength : hero.getStrengthList()) {
			hero.setBaseSignificance(hero.getBaseSignificance() + strength.getValue());
		}
		sumAspects(hero.getBackgroundAspectList());
		sumAspects(hero.getRoleAspectList());
		sumAspects(hero.getFocusAspectList());
		sumOtherData(hero.getSecretList());
		sumOtherData(hero.getResourceList());
		sumOtherData(hero.getTagList());
		sumOtherData(hero.getExperienceList());
	}

	private void sumOtherData(List<CharacteristicTrait> dataList) {
		for (CharacteristicTrait trait : dataList) {
			hero.setBaseSignificance(hero.getBaseSignificance() + trait.getValue());
		}
	}

	private void sumAspects(List<Aspect> aspectList) {
		for (Aspect aspect : aspectList) {
			hero.setBaseSignificance(hero.getBaseSignificance() + aspect.getValue());
		}

	}

}
