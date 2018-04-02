package weblogin;

import org.springframework.data.repository.CrudRepository;

public interface UserStore extends CrudRepository<Employee, Long> {
    Employee findByUsername(String username);
}
