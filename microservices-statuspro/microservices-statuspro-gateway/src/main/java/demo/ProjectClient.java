package demo;


import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("project-service")
public interface ProjectClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}/project/list")
	Collection<Project> getProject(@PathVariable("projectId") String projectId);

}
