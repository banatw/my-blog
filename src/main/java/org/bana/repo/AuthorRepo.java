package org.bana.repo;

import org.bana.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends PagingAndSortingRepository<Author, String> {
	Author findByUsername(String username);
}
