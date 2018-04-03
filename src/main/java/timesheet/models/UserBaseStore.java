package timesheet.models;

import org.springframework.data.repository.CrudRepository;

public interface UserBaseStore<T extends User> extends CrudRepository<T, Long>{
	
	
	public T findByUsername(String username);
	

}
