package com.example.custom_anotation.controller;

import com.example.custom_anotation.dto.Worker;
import com.example.custom_anotation.dto.res.ServerResponse;
import com.example.custom_anotation.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/worker")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerService workerService;

    @PostMapping("/insert")
    public ServerResponse insertWorker(@RequestBody @Valid Worker worker) {
        return workerService.insertWorker(worker);
    }
    @GetMapping("/all")
    public ServerResponse getAll(){
        return workerService.getAllWorkers();
    }
}
