package cdac.service;

import java.util.List;

import cdac.model.Task;



public interface TaskService {
public Task SaveTask(Task task);
public void delete(int task_id);
public List<Task> showalltask();
public Task gettaskbyid(int task_id);
public void updatetask(Task task);	
}
