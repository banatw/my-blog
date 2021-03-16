package org.bana.myblog.config;

import org.bana.myblog.entity.Author;
import org.bana.myblog.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private AuthorRepo userRepo;

	public MyUserDetailService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Author author = userRepo.findById(arg0).get();
		if (author != null) {
			User user = new User(author.getUsername(), author.getPassword(),
					AuthorityUtils.commaSeparatedStringToAuthorityList(author.getRole().getRoleName()));
			return user;
		} else {
			throw new BadCredentialsException("error");
		}
	}

}
