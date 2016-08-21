package demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {

	List<Discussion> findByProjectId(String projectId);

	Discussion findByProjectIdAndId(String projectId, Long id);

}
