package demo;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("discussion-service")
public interface DiscussionClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}/discussion")
	public Collection<Discussion> getDiscussions(@PathVariable("projectId") String projectId);

}
