package Kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
@Repository
public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> languages = new ArrayList<>();

	public InMemoryProgrammingLanguageDao() {

		languages.add(new ProgrammingLanguage(1, "c#"));
		languages.add(new ProgrammingLanguage(2, "java"));
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);
		
	}

	@Override
	public void delete(int id) {
		languages.remove(getById(id));
		//languages.removeIf(language->language.getId()==id); bunu araştır lamd

	}

	@Override
	public void update(int id,ProgrammingLanguage programmingLanguage) {
	ProgrammingLanguage	inDbProgrammingLanguage=getById(id);
	inDbProgrammingLanguage.setName(programmingLanguage.getName());

	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage programmingLanguage:getAll()) {
			if(id==programmingLanguage.getId()) {
				return programmingLanguage;
			}
		}
		return null;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return languages;
	}

}
