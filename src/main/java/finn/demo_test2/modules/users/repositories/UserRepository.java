package finn.demo_test2.modules.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finn.demo_test2.modules.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
}
