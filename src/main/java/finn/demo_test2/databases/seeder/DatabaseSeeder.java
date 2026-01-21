package finn.demo_test2.databases.seeder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import finn.demo_test2.modules.users.entities.User;
import finn.demo_test2.modules.users.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class DatabaseSeeder implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Transactional
  @Override
  public void run(String... args) throws Exception {
    if(isTableEmpty()) {
      String passwordEncoded = passwordEncoder.encode("finn");
      logger.info("seeding data...");

      User user = new User();
      user.setName("Tuan Pham");
      user.setEmail("test@gmail.com");
      user.setUserCatalogueId(2L);
      user.setPassword(passwordEncoded);
      user.setPhone("045465443");
      userRepository.save(user);
    }

  }

  private boolean isTableEmpty() {
    Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM User").getSingleResult();
    return count == 0;
  }
}
