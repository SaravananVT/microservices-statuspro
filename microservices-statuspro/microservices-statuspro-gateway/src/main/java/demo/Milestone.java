package demo;



public class Milestone {


	private Long id;

	private String projectId;

	private String date;

	private String description;

	private String status;

	Milestone() {
	}

	public Milestone(String projectId, String date, String description, String status) {
		this.projectId = projectId;
		this.date = date;
		this.description = description;
		this.status = status;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Milestone{" + "projectId='" + projectId + '\'' + ", date="
				+ date + ", description="
						+ description + ", status="
								+ status + '}';
	}
	

}
