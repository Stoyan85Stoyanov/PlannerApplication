package com.plannerapp.init;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class PriorityInit implements CommandLineRunner {

    private final Map<PriorityName, String> careerInformation = Map.of(
            PriorityName.URGENT, "A An urgent problem that blocks the system use until the issue is resolved.",
            PriorityName.IMPORTANT, "A core functionality that your product is explicitly supposed to perform is compromised.",
            PriorityName.LOW, "Should be fixed if time permits but can be postponed."
    );

    private final PriorityRepository priorityRepository;

    public PriorityInit(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long count = this.priorityRepository.count();

        if (count > 0) {
            return;
        }

        List<Priority> toInsert = Arrays.stream(PriorityName.values())
                .map(name -> new Priority(name, careerInformation.get(name))).toList();

        this.priorityRepository.saveAll(toInsert);
        }
    }

