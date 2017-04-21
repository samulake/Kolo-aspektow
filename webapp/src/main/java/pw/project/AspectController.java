package pw.project;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pw.project.Hero;
import pw.project.Aspect;

@Controller
public class AspectController {
	private ModelAndView modelAndView;
	private Hero hero;

	@ModelAttribute
	public void addCommonAtributes(Model model) {
		model.addAttribute("stepsMessage", "Krok 3 z 4");
	}

	@RequestMapping(value = "aspectData.html")
	public ModelAndView getAspectDataForm(HttpServletRequest request) {
		modelAndView = new ModelAndView("aspectData");
		this.hero = (Hero) request.getAttribute("hero");
		return modelAndView;
	}

	@RequestMapping(value = "addAspect")
	public ModelAndView addAspect(@Valid Aspect aspect, BindingResult result, @RequestParam Map<String, String> variableMap) {
		modelAndView = new ModelAndView("aspectData");
		Integer numberOfProficiencies = Integer.parseInt(variableMap.get("numberOfProficiencies"));

		if (aspect.getAssignedProficiencyList().size() != numberOfProficiencies) {
			result.addError(new ObjectError("hero", "Wybierz " + numberOfProficiencies + " bieglosci!"));
		}

		if (!result.hasErrors()) {
			if (numberOfProficiencies == 3) {
				hero.getBackgroundAspectList().add(aspect);
			} else if (numberOfProficiencies == 2) {
				hero.getRoleAspectList().add(aspect);
			} else if (numberOfProficiencies == 1) {
				hero.getFocusAspectList().add(aspect);
			}
		}
		modelAndView.addObject("backgroundAspectList", hero.getBackgroundAspectList());
		modelAndView.addObject("roleAspectList", hero.getRoleAspectList());
		modelAndView.addObject("focusAspectList", hero.getFocusAspectList());

		return modelAndView;
	}

	@RequestMapping(value = "submitData.html")
	public ModelAndView submitData() {
		modelAndView = new ModelAndView("forward:/otherData.html");
		modelAndView.addObject("hero", this.hero);

		return modelAndView;
	}

}
