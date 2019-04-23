package com.mary.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mary.languages.models.Language;
import com.mary.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	//Dependency Injection
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// return all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	//create a language
	public Language creatLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	
	// retrieves a language
	public Language findLanguage(long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		
	}

	public void updateBook(@Valid Language language) {
		languageRepository.save(language);	
	}

}
