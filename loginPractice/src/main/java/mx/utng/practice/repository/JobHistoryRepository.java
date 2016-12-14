package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.utng.practice.model.JobHistory;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long>{
	@Query("select job from JobHistory job")
	public List<JobHistory> findAll();
}
