package org.bana.myblog.repo;

import org.bana.myblog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepo extends PagingAndSortingRepository<Post, String> {
	Page<Post> findByAuthorUsernameOrderByPostDateDesc(String username, Pageable pageable);

	Page<Post> findByAuthorUsernameOrderByAuditDateDesc(String username, Pageable pageable);

	Page<Post> findAllByOrderByPostDateDesc(Pageable pageable);

	Page<Post> findByAuthorUsernameAndPostTitleContainsIgnoreCaseOrderByPostDateDesc(String username, String title,
			Pageable pageable);
}
