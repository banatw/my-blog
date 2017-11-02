package org.bana.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("org.bana.entity")
@ComponentScan({"org.bana.controller","org.bana.config"})
@EnableJpaRepositories("org.bana.repo")
@SpringBootApplication
public class MyBlogApplication {
	/*@Autowired
	private AuthorRepo authorRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private PostRepo postRepo;*/

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> {
			roleRepo.save(new Role(null, "ROLE_ADMIN", new Date(), "SYSTEM"));
			roleRepo.save(new Role(null, "ROLE_USER", new Date(), "SYSTEM"));
			categoryRepo.save(new Category(null, "Komputer", new Date(), "SYSTEM", null));
			categoryRepo.save(new Category(null, "Sains", new Date(), "SYSTEM", null));
			
			for(Role role : roleRepo.findAll()) {
				System.out.println(role.getIdRole() + " " +  role.getRoleName());
			}
			authorRepo.save(new Author("admin", "admin", "Syabana", roleRepo.findByroleName("ROLE_ADMIN"), new Date(), "SYSTEM", null));
			
			Post post = new Post();
			post.setAuditDate(new Date());
			post.setAuthor(authorRepo.findOne("admin"));
			post.setPostSubTitle("");
			post.setCategory(categoryRepo.findBycategoryDescription("Komputer"));
			post.setIdPost(UUID.randomUUID().toString().replace("-", ""));
			post.setPostContent("My First Content");
			post.setPostDate(new Date());
			post.setPostTitle("Hello World");
			postRepo.save(post);
			
		};
	}*/
	
}