package timesheet.models;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserStore extends UserBaseStore<User> {

    
}
