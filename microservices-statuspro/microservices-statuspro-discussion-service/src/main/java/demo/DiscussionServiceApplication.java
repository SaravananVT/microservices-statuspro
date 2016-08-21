package demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class DiscussionServiceApplication {

	@Bean
	public CommandLineRunner init(DiscussionRepository discussionRepository) {
		return args -> {
			discussionRepository.deleteAll();
			Arrays.asList("project1,project2".split(",")).forEach(projectId -> {
					Arrays.asList("01 May 2016,Issue XXX;20 Apr 2016,Issue YYY;28 Apr 2016,Risk XXX;30 Apr 2016,Issue ZZZ;02 May 2016,Issue MMM;05 May 2016,Risk 111".split(";"))
						.stream()
						.map(name -> name.split(","))
						.map(details -> new Discussion(
								projectId,
								details[0],
								details[1],
								"Discussion XXXX",
								"Open"))
						.forEach(discussionRepository::save);
				});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscussionServiceApplication.class, args);
	}

}
