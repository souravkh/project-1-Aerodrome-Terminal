package cdac.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cdac.model.Task;


@Repository
public interface TaskRepo extends CrudRepository<Task,Integer>{

}
