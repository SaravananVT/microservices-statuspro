package demo;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("milestone-service")
public interface MilestoneClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}/milestone")
	Collection<Milestone> getMilestones(@PathVariable("projectId") String projectId);

}
