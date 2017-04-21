package pw.project;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pw.project.Hero;

@Controller
public class BasicsController {
	private ModelAndView modelAndView;
	
	@ModelAttribute
	public void addCommonAtributes(Model model) {
		model.addAttribute("stepsMessage" , "Krok 1 z 4");
	}
	
	@RequestMapping(value="basicData.html", method=RequestMethod.POST)
	public ModelAndView getBasicDataForm() {
		return new ModelAndView("basicData");
	}
	
	@RequestMapping(value="submitBasicData.html", method=RequestMethod.POST)
	public ModelAndView submitData(@Valid @ModelAttribute("hero") Hero hero, BindingResult result) {
		modelAndView = new ModelAndView("forward:/strengthData.html");
		if(result.hasErrors()) {
			modelAndView = new ModelAndView("basicData");
		}
		
		return modelAndView;
	}
}
