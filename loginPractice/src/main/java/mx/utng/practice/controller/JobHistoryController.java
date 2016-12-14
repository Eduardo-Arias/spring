package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.JobHistory;
import mx.utng.practice.repository.JobHistoryRepository;

@Named
@ViewScoped
public class JobHistoryController {
	@Autowired(required=true)
	private JobHistoryRepository jobHistoryRepository;
	private JobHistory jobHistory = new JobHistory();
	private List<JobHistory> jobHistorys;
	private Boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setJobHistorys(jobHistoryRepository.findAll());
	}
	
	public void save(){
		jobHistoryRepository.save(jobHistory);
		if(!editMode){
			getJobHistorys().add(jobHistory);
		}
		jobHistory = new JobHistory();
		setEditMode(false);
	}
	
	public void delete(JobHistory jobHistory){
		jobHistoryRepository.delete(jobHistory);
		jobHistorys.remove(jobHistory);
	}
	
	public void update(JobHistory jobHistory){
		setJobHistory(jobHistory);
		setEditMode(true);
	}
	
	public void cancel(){
		jobHistory = new JobHistory();
		setEditMode(false);
	}

	public JobHistory getJobHistory() {
		return jobHistory;
	}

	public void setJobHistory(JobHistory jobHistory) {
		this.jobHistory = jobHistory;
	}

	public List<JobHistory> getJobHistorys() {
		return jobHistorys;
	}

	public void setJobHistorys(List<JobHistory> jobHistorys) {
		this.jobHistorys = jobHistorys;
	}

	public Boolean getEditMode() {
		return editMode;
	}

	public void setEditMode(Boolean editMode) {
		this.editMode = editMode;
	}
}
