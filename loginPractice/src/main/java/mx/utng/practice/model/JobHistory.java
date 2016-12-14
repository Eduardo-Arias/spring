package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="job_history")
public class JobHistory {
	@Id @GeneratedValue
	private Long id;
	private String idEmploye;
	private String starDate;
	private String endDate;
	private String idDepartament;
	
	public JobHistory(String idEmploye, String starDate, String endDate, String idDepartament) {
		super();
		this.idEmploye = idEmploye;
		this.starDate = starDate;
		this.endDate = endDate;
		this.idDepartament = idDepartament;
	}
	
	public JobHistory() {
		this("","","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getStarDate() {
		return starDate;
	}

	public void setStarDate(String starDate) {
		this.starDate = starDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getIdDepartament() {
		return idDepartament;
	}

	public void setIdDepartament(String idDepartament) {
		this.idDepartament = idDepartament;
	}

	@Override
	public String toString() {
		return "JobHistory [id=" + id + ", idEmploye=" + idEmploye + ", starDate=" + starDate + ", endDate=" + endDate
				+ ", idDepartament=" + idDepartament + "]";
	}
}
