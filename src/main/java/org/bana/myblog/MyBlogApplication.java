package org.bana.myblog;

import java.util.Date;
import java.util.UUID;

import org.bana.myblog.entity.Author;
import org.bana.myblog.entity.Category;
import org.bana.myblog.entity.Post;
import org.bana.myblog.entity.Role;
import org.bana.myblog.repo.AuthorRepo;
import org.bana.myblog.repo.CategoryRepo;
import org.bana.myblog.repo.PostRepo;
import org.bana.myblog.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @EntityScan("org.bana.entity")
// @ComponentScan({"org.bana.controller","org.bana.config"})
// @EnableJpaRepositories("org.bana.repo")
@SpringBootApplication
public class MyBlogApplication {
	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private PostRepo postRepo;

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> {
			roleRepo.save(new Role(null, "ROLE_ADMIN", new Date(), "SYSTEM"));
			roleRepo.save(new Role(null, "ROLE_USER", new Date(), "SYSTEM"));
			categoryRepo.save(new Category(null, "Komputer", new Date(), "SYSTEM", null));
			categoryRepo.save(new Category(null, "Sains", new Date(), "SYSTEM", null));

			/*for(Role role : roleRepo.findAll()) {
				System.out.println(role.getIdRole() + " " +  role.getRoleName());
			}*/
			authorRepo.save(new Author("admin", new BCryptPasswordEncoder().encode("admin"), "Syabana",
					roleRepo.findByroleName("ROLE_ADMIN"), new Date(), "SYSTEM", null));

			Post post = new Post();
			post.setAuditDate(new Date());
			post.setAuthor(authorRepo.findById("admin").get());
			post.setPostSubTitle("");
			post.setCategory(categoryRepo.findBycategoryDescription("Komputer"));
			post.setIdPost(UUID.randomUUID().toString().replace("-", ""));
			post.setPostContent("<i>My First Content</i>");
			post.setPostDate(new Date());
			post.setPostTitle("Hello World");
			postRepo.save(post);

		};
	}

}
