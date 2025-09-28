package com.plannerapp.model.dto.task;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskHomeViewModel {

    private List<TaskDto> assignedTasks;

    private List<TaskDto> availableTasks;


    public TaskHomeViewModel() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public TaskHomeViewModel(List<TaskDto> assignedTasks, List<TaskDto> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
    }
}
