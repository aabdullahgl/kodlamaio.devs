package Kodlama.io.Kodlama.io.Devs.controllers.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/v1/languages")
public class ProgrammingLanguagesController {
	private final ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		
		this.programmingLanguageService = programmingLanguageService;
	}
	@GetMapping
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	@GetMapping("/{id}")
	public ProgrammingLanguage getOneProgrammingLanguage(@PathVariable int id) throws Exception {
		
		return programmingLanguageService.getById(id);
	}
	@PostMapping
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}
	@PutMapping("/{id}")
	public void update(@PathVariable int id,@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(id, programmingLanguage);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		programmingLanguageService.delete(id);
	}
}
