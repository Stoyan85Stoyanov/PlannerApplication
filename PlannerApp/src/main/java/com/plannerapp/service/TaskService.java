package com.plannerapp.service;
import com.plannerapp.model.dto.task.TaskHomeViewModel;
import com.plannerapp.model.dto.task.TasksAddBindingModel;

import java.util.UUID;

public interface TaskService {


    void add(TasksAddBindingModel tasksAddBindingModel);

    void remove(UUID id);

    void assign(UUID id, String username);

    TaskHomeViewModel getHomeViewData(String username);
}
