package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.Environment;
import reactor.rx.Stream;
import reactor.rx.Streams;

@Component
public class DashboardService {

	@Autowired
	private Environment environment;

	@Autowired
	private ProjectClient projectClient;
	
	
	@Autowired
	private MilestoneClient milestoneClient;

	@Autowired
	private DiscussionClient discussionClient;

	public Stream<Discussion> getDiscussions(String projectId) {
		return Streams.<Discussion> create(subscriber -> {
			this.discussionClient.getDiscussions(projectId).forEach(subscriber::onNext);
			subscriber.onComplete();
		}).dispatchOn(this.environment, Environment.cachedDispatcher()).log("discussions");
	}

	public Stream<Milestone> getMilestones(String projectId) {
		return Streams.<Milestone> create(subscriber -> {
			this.milestoneClient.getMilestones(projectId).forEach(subscriber::onNext);
			subscriber.onComplete();
		}).dispatchOn(this.environment, Environment.cachedDispatcher()).log("milestones");
	}
	
	public Stream<Project> getProject(String projectId) {
		return Streams.<Project> create(subscriber -> {
			this.projectClient.getProject(projectId).forEach(subscriber::onNext);
			subscriber.onComplete();
		}).dispatchOn(this.environment, Environment.cachedDispatcher()).log("project");

	}

	public Stream<Dashboard> getDashboard(String projectId,
			Stream<Milestone> milestones, Stream<Discussion> discussions) {
		return Streams.zip(milestones.buffer(),discussions.buffer(), tuple ->
			new Dashboard(projectId,tuple.getT1(),tuple.getT2()));
	}

}
