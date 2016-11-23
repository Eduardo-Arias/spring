package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="exams")
public class Exam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=45)
	private String matter;
	
	@Column
	private int unity;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@Column
	private int score;
	

	public Exam(String matter, int unity, Date date, int score) {
		super();
		this.matter = matter;
		this.unity = unity;
		this.date = date;
		this.score = score;
	}
	
	public Exam() {
		this("",0,new Date(),0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public int getUnity() {
		return unity;
	}

	public void setUnity(int unity) {
		this.unity = unity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", matter=" + matter + ", unity=" + unity + ", date=" + date + ", score=" + score
				+ "]";
	}
}
