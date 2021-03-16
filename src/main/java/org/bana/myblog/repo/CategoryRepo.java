package org.bana.myblog.repo;

import org.bana.myblog.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Integer> {
	Category findBycategoryDescription(String category);
}
