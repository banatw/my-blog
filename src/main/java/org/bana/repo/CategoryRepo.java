package org.bana.repo;

import org.bana.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Integer> {
	Category findBycategoryDescription(String category);
}
