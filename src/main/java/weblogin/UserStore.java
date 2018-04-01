package weblogin;

import org.springframework.data.repository.CrudRepository;

public interface UserStore extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
