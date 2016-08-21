package demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{projectId}/project")
public class ProjectRestController {

	@Autowired
	private ProjectRepository projectRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Project> getProjects(@PathVariable String projectId) {
		return this.projectRepository.findByProjectId(projectId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Project getProject(@PathVariable String projectId,
			@PathVariable Long id) {
		return this.projectRepository.findByProjectIdAndId(projectId, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Project createProject(@PathVariable String projectId, @RequestBody Project project) {
		return this.projectRepository.save(
				new Project(
						project.getProjectId(),
						project.getName(),
						project.getDescription(),
						project.getStatusUpdate(),
						project.getRagStatus(),
						project.getMilestoneStatus(),
						project.getCompletionStatus(),
						project.getDiscussionStatus()));
	}

}
