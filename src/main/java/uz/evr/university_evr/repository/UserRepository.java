package uz.evr.university_evr.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.evr.university_evr.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
