package demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{projectId}/discussion")
public class DiscussionRestController {

	@Autowired
	private DiscussionRepository discussionRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Discussion> getDiscussions(@PathVariable String projectId) {
		return this.discussionRepository.findByProjectId(projectId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Discussion getDiscussion(@PathVariable String projectId,
			@PathVariable Long id) {
		return this.discussionRepository.findByProjectIdAndId(projectId, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Discussion createDiscussion(@PathVariable String projectId, @RequestBody Discussion discussion) {
		return this.discussionRepository.save(
				new Discussion(
						projectId,
						discussion.getDate(),
						discussion.getType(),
						discussion.getDescription(),
						discussion.getStatus()));
	}

}
