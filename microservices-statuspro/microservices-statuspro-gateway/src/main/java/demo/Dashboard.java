package demo;

import java.util.Collection;

public class Dashboard {

	private String projectId;
	
	private Collection<Project> project;

	private Collection<Milestone> milestones;

	private Collection<Discussion> discussions;

	public Dashboard(String projectId , Collection<Milestone> milestones,
			Collection<Discussion> discussions) {
		this.projectId = projectId;
		this.milestones = milestones;
		this.discussions = discussions;
		//this.project = project;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Collection<Project> getProject() {
		return project;
	}

	public void setProject(Collection<Project> project) {
		this.project = project;
	}

	public Collection<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(Collection<Milestone> milestones) {
		this.milestones = milestones;
	}

	public Collection<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(Collection<Discussion> discussions) {
		this.discussions = discussions;
	}
	
	@Override
	public String toString() {
		return "Dashboard{" + "projectId='" + projectId + '\'' + ", discussions="
				+ discussions + ", milestones=" + milestones + '}';
	}



}
