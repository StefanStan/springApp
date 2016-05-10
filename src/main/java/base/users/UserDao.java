package base.users;

import org.springframework.stereotype.Component;

/** This is domain DAO to access users. Kinda fake here. */
@Component
public class UserDao {

	public User getByLogin(String login) {
		switch (login) {
			case "admin":
				return new User("admin", "Administrator", "$2a$10$MJCv2bPyCLj2ZPbUuWzh8uCW4U1uqM/kyLpFV22W185XU45QVvDBa", "ADMIN");
			case "special":
				return new User("special", "Special Expert", "$2a$10$L7bMvpuHdtTN/qZ15XSje.rgwzBMcODZcnPg3c1mMgRQQzGSuatTG", "ROLE_SPECIAL");
			default:
				return null;
		}
	}
}
