package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	void add(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void update(int id,ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage getById(int id);
	List<ProgrammingLanguage> getAll();
	
}
