package demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProjectServiceApplication {

	@Bean
	public CommandLineRunner init(ProjectRepository projectRepository) {
		return args -> {
			projectRepository.deleteAll();
			Arrays.asList("project1,project2".split(",")).forEach(projectId -> {
					Arrays.asList(
							  "Test Project 1,Name 1,Description 1,update 1,rag 1,milestone 1,completion 1,discussion 1;"
							+ "Test Project 2,Name 2,Description 2,update 2,rag 2,milestone 2,completion 2,discussion 2;"
							+ "Test Project 3,Name 3,Description 3,update 3,rag 3,milestone 3,completion 3,discussion 3;"
							+ "Test Project 4,Name 4,Description 4,update 4,rag 4,milestone 4,completion 4,discussion 4;"
							+ "Test Project 5,Name 5,Description 5,update 5,rag 5,milestone 5,completion 5,discussion 5;"
							+ "Test Project 6,Name 6,Description 6,update 6,rag 6,milestone 6,completion 6,discussion 6".split(";"))
						.stream()
						.map(name -> name.split(","))
						.map(details -> new Project(
								projectId,
								details[0],
								details[1],
								details[2],
								details[3],
								details[4],
								details[5],
								details[6]))
						.forEach(projectRepository::save);
				});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication.class, args);
	}

}
