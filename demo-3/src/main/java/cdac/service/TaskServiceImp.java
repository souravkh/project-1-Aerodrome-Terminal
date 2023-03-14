package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.TaskRepo;
import cdac.model.Task;


@Service
public class TaskServiceImp implements TaskService{
	@Autowired
	TaskRepo trepo;
	
	@Override
	public Task SaveTask(Task task) {
		return trepo.save(task);
	}

	@Override
	public void delete(int task_id) {
		trepo.deleteById(task_id);
		
	}

	@Override
	public List<Task> showalltask() {
		
		return (List<Task>)trepo.findAll();
	}

	@Override
	public Task gettaskbyid(int task_id) {
		Optional<Task> opt=trepo.findById(task_id);
		return opt.get();
	}

	@Override
	public void updatetask(Task task) {
	trepo.save(task);
	}

}
