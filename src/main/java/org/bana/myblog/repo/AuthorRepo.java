package org.bana.myblog.repo;

import org.bana.myblog.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends PagingAndSortingRepository<Author, String> {
	Author findByUsername(String username);
}
