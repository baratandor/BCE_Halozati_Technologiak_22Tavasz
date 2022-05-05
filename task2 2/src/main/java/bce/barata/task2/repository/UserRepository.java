package bce.barata.task2.repository;

import bce.barata.task2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long>
{
   Optional<User> findByName(String name);
   Optional<User> findByPassword(String name);


}
