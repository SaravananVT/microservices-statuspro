package demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

	List<Milestone> findByProjectId(String projectId);

	Milestone findByProjectIdAndId(String projectId, Long id);

}
