package org.bana.repo;

import org.bana.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends PagingAndSortingRepository<Role, Integer> {
	Role findByroleName(String role);
}
