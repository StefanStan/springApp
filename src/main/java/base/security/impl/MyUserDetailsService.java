package base.security.impl;


import base.users.User;
import base.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Implements Spring Security {@link UserDetailsService} that is injected into authentication provider in configuration XML.
 * It interacts with domain, loads user details and wraps it into {@link UserContext} which implements Spring Security {@link UserDetails}.
 */
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/**
	 * This will be called from
	 * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider#retrieveUser(String, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)}
	 * when {@link base.security.specs.AuthenticationService#authenticate(String, String)} calls
	 * {@link AuthenticationManager#authenticate(org.springframework.security.core.Authentication)}. Easy.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(" *** MyUseDetailService.loadUserByUsername");
		User user = userDao.getByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		return new UserContext(user);
	}
}
