package timesheet.models;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeStore extends UserBaseStore<Employee>{

}
