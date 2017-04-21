package pw.project;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pw.project.Hero;
import pw.project.Strength;

@Controller
public class StrengthsController {
	private ModelAndView modelAndView;
	private Hero hero;

	@ModelAttribute
	public void addCommonAtributes(Model model) {
		model.addAttribute("stepsMessage", "Krok 2 z 4");
	}

	@RequestMapping(value = "strengthData.html")
	public ModelAndView getStrengthDataForm(@ModelAttribute("hero") Hero hero) {
		modelAndView = new ModelAndView("strengthData");
		this.hero = hero;
		return modelAndView;
	}

	@RequestMapping(value = "addStrength", method = RequestMethod.POST)
	public ModelAndView addStrength(@Valid Strength strength, BindingResult result) {
		modelAndView = new ModelAndView("strengthData");

		if (hero.getStrengthList().size() >= 6) {
			result.addError(new ObjectError("hero", "Maksymalna liczba atutów wynosi 6!"));
		}
		if (!result.hasErrors()) {
			hero.getStrengthList().add(strength);
		}
		modelAndView.addObject("strengthList", hero.getStrengthList());
		return modelAndView;
	}

	@RequestMapping(value = "submitStrengthData")
	public ModelAndView submitData() {
		modelAndView = new ModelAndView("forward:/aspectData.html");
		modelAndView.addObject("hero", this.hero);
		return modelAndView;
	}
}
