package fr.eql.teama.catalogue.init;

import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Profile("initData")//en développement seulement , pas en production
@Component
public class InitDataSet {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct()
	public void initData() {
		User user = userService.addUser(new User("alice"));
	}

}
