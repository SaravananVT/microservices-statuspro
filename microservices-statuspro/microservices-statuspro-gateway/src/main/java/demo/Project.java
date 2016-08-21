package demo;



class Project {

	private Long id;

	private String projectId;

	private String name;

	private String description;

	private String statusUpdate;

	private String ragStatus;
	
	private String milestoneStatus;
	
	private String completionStatus;
	
	private String discussionStatus;


	public Project() {
	}

	public Project(String projectId, String name, String description,
			String statusUpdate, String ragStatus,String milestoneStatus,
			String completionStatus,String discussionStatus) {
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.statusUpdate = statusUpdate;
		this.ragStatus = ragStatus;
		this.milestoneStatus = milestoneStatus;
		this.completionStatus = completionStatus;
		this.discussionStatus = discussionStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusUpdate() {
		return statusUpdate;
	}

	public void setStatusUpdate(String statusUpdate) {
		this.statusUpdate = statusUpdate;
	}

	public String getRagStatus() {
		return ragStatus;
	}

	public void setRagStatus(String ragStatus) {
		this.ragStatus = ragStatus;
	}

	public String getMilestoneStatus() {
		return milestoneStatus;
	}

	public void setMilestoneStatus(String milestoneStatus) {
		this.milestoneStatus = milestoneStatus;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public String getDiscussionStatus() {
		return discussionStatus;
	}

	public void setDiscussionStatus(String discussionStatus) {
		this.discussionStatus = discussionStatus;
	}
	
	@Override
	public String toString() {
		return "Project{" + "projectId='" + projectId + '\'' + ", name="
				+ name + ", ragStatus=" + ragStatus + ", description="
						+ description + ", milestoneStatus="
								+ milestoneStatus + ", completionStatus="
										+ completionStatus + ", discussionStatus="
												+ discussionStatus + '}';
	}

}
