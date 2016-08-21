package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import reactor.rx.Stream;

@RestController
public class DashboardRestController {

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping("/{projectId}/dashboard")
	public DeferredResult<Dashboard> dashboard(@PathVariable String projectId) {
		DeferredResult<Dashboard> dashboardDeferredResult = new DeferredResult<>();
		//Stream<Project> projectStream = this.dashboardService.getProject(projectId);
		Stream<Discussion> discussionStream = this.dashboardService.getDiscussions(projectId);
		
		Stream<Milestone> milestoneStream = this.dashboardService.getMilestones(projectId);

		this.dashboardService.getDashboard(projectId ,milestoneStream, discussionStream).consume(
				dashboardDeferredResult::setResult);
		return dashboardDeferredResult;
	}

}
