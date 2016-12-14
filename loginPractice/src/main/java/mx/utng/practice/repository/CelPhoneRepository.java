package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.CelPhone;
import mx.utng.practice.model.JobHistory;

public interface CelPhoneRepository extends JpaRepository<CelPhone, Long>{
	@Query("select cel from CelPhone cel")
	public List<CelPhone> findAll();
}