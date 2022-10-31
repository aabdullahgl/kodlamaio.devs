package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private final ProgrammingLanguageRepository programmingLanguageRepository; // araştır-btk spring 
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if(isIdExist(programmingLanguage.getId())) {
			throw new Exception("Bu Id daha önce kullanılmış");
		}
		if(isNameValid(programmingLanguage.getName())) {
			programmingLanguageRepository.add(programmingLanguage);
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id bulunamadı");
		}programmingLanguageRepository.delete(id);
		
	}

	@Override
	public void update(int id, ProgrammingLanguage programmingLanguage) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id bulunamadı");
		}
		if(isNameValid(programmingLanguage.getName())) {
			programmingLanguageRepository.update(id, programmingLanguage);
		}
		
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id bulunamadı");
		}
		return programmingLanguageRepository.getById(id);
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}
	private boolean isIdExist(int id) {
		for(ProgrammingLanguage programmingLanguage:getAll()) {
			if(programmingLanguage.getId()==id) {
				return true;
			}
		}
		return false;
	}
	public boolean isNameValid(String name) throws Exception {
		if(name.isBlank()) {
			throw new Exception("İsim boş olamaz");
		}
		for(ProgrammingLanguage programmingLanguage:getAll()) {
			if(programmingLanguage.getName().equals(name)) {
				throw new Exception("İsim tekrar edemez");
			}
		}return true;
		
	}

}
