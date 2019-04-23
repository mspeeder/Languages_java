package com.mary.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mary.languages.models.Language;
import com.mary.languages.services.LanguageService;

@Controller
public class LanguagesController {
	//Dependency Injection
	private final LanguageService languageService;
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	// index page
	@RequestMapping("/languages") 
	public String index(Model model, @ModelAttribute("language") Language lang) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	// Create
	@RequestMapping(value="/languages/creat", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
        if (result.hasErrors()) {
        	return "/languages/index.jsp";
        } else {
        	languageService.creatLanguage(lang);
            return "redirect:/languages";
        }
    }
	
	// show 
	@RequestMapping("/languages/{id}")
    public String showLanguage(Model model,@PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/show.jsp";
    }
	
	
	//delete
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
    } 
	
	
	//edit page
	@RequestMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
	
	// update
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
        	languageService.updateBook(language);
            return "redirect:/languages";
        }
    }	

}
