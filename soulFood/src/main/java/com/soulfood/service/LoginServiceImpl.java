package com.soulfood.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.LoginException;
import com.soulfood.model.CurrentUserSession;
import com.soulfood.model.Customer;
import com.soulfood.model.Login;
import com.soulfood.repository.CustomerRepo;
import com.soulfood.repository.CurrentUserSessionRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	private CurrentUserSessionRepo sRepo;

	@Override
	public String loginAccount(Login login) throws LoginException {

		Customer customer = cRepo.findByEmail(login.getUserName());
		if (customer != null) {

			if (customer.getPassword().equals(login.getPassword())) {

				CurrentUserSession cuurSession = sRepo.findByEmail(login.getUserName());

				if (cuurSession != null) {
					throw new LoginException("User already Logged In!");
				} else {
					CurrentUserSession currentUserSession = new CurrentUserSession();
					currentUserSession.setEmail(login.getUserName());
					currentUserSession.setLoginDateTime(LocalDateTime.now());

					String key = RandomString.make(6);
					currentUserSession.setPrivateKey(key);

					sRepo.save(currentUserSession);
					return "Login Sucessufull!";
				}
			} else {
				throw new LoginException("Please Enter a valid password");
			}

		} else {
			throw new LoginException("Please Enter a valid username");
		}
	}

	@Override
	public String logoutAccount(String key) throws LoginException {

		CurrentUserSession currSession = sRepo.findByPrivateKey(key);
		if (currSession != null) {
			sRepo.delete(currSession);
			return "Logged Out!";
		} else {
			throw new LoginException("This User not-Logged In");
		}
	}
}