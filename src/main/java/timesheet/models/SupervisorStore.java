package timesheet.models;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SupervisorStore extends UserBaseStore<Supervisor>{

}
