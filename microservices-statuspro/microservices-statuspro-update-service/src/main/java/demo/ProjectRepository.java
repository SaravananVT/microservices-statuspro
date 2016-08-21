package demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findByProjectId(String projectId);

	Project findByProjectIdAndId(String projectId, Long id);

}
