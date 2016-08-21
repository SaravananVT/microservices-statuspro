package demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{projectId}/milestone")
public class MilestoneRestController {

	@Autowired
	private MilestoneRepository milestoneRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Milestone> getMilestones(@PathVariable String projectId) {
		return this.milestoneRepository.findByProjectId(projectId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Milestone getMilestone(@PathVariable String projectId,
			@PathVariable Long id) {
		return this.milestoneRepository.findByProjectIdAndId(projectId, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Milestone createMilestone(@PathVariable String projectId, @RequestBody Milestone milestone) {
		Milestone milestoneInstance = new Milestone(projectId, milestone.getDate(),
				milestone.getDescription(), milestone.getStatus());
		return this.milestoneRepository.save(milestoneInstance);
	}

}
