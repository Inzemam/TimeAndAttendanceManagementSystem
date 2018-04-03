package timesheet.models;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminStore extends UserBaseStore<Admin>{

}
