package banking.clients.service.repository;

import banking.clients.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <User,Integer> {
}
