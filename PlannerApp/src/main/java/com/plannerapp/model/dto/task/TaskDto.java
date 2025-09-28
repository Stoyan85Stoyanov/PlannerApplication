package com.plannerapp.model.dto.task;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.enums.PriorityName;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TaskDto {

    private UUID id;

    private String description;

    private String dueDate;

    private PriorityName priority;


    public static TaskDto createFromTask(Task task) {

        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority().getName());
        taskDto.setDueDate(task.getDueDate().toString());
        return taskDto;
    }
}
