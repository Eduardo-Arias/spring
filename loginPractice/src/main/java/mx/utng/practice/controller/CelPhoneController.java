package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.CelPhone;
import mx.utng.practice.repository.CelPhoneRepository;

@Named
@ViewScoped
public class CelPhoneController {
	@Autowired(required=true)
	private CelPhoneRepository celPhoneRepository;
	private CelPhone celPhone= new CelPhone();
	private List<CelPhone> celPhones;
	private Boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setCelPhones(celPhoneRepository.findAll());
	}
	
	public void save(){
		celPhoneRepository.save(celPhone);
		if(!editMode){
			getCelPhones().add(celPhone);
		}
		celPhone = new CelPhone();
		setEditMode(false);
	}
	
	public void delete(CelPhone celPhone){
		celPhoneRepository.delete(celPhone);
		celPhones.remove(celPhone);
	}
	
	public void update(CelPhone celPhone){
		setCelPhone(celPhone);
		setEditMode(true);
	}
	
	public void cancel(){
		celPhone = new CelPhone();
		setEditMode(false);
	}

	public CelPhone getCelPhone() {
		return celPhone;
	}

	public void setCelPhone(CelPhone celPhone) {
		this.celPhone = celPhone;
	}

	public List<CelPhone> getCelPhones() {
		return celPhones;
	}

	public void setCelPhones(List<CelPhone> celPhones) {
		this.celPhones = celPhones;
	}

	public Boolean getEditMode() {
		return editMode;
	}

	public void setEditMode(Boolean editMode) {
		this.editMode = editMode;
	}
	
}
