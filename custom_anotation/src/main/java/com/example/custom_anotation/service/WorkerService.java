package com.example.custom_anotation.service;

import com.example.custom_anotation.dto.ErrorDto;
import com.example.custom_anotation.dto.Response;
import com.example.custom_anotation.dto.Worker;
import com.example.custom_anotation.dto.res.ServerResponse;
import com.example.custom_anotation.rest.WorkerRestIml;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRestIml workerRestIml;

    public ServerResponse insertWorker(Worker worker) {
        Response response = workerRestIml.insertWorker(worker);
        if (response.isSuccess()) {
            Worker w = response.getData().getWorker();
            return ServerResponse.builder()
                    .data(w)
                    .success(true)
                    .build();
        } else {
            ErrorDto errorDto = response.getError();
            return ServerResponse.builder()
                    .error(errorDto)
                    .success(false)
                    .build();
        }
    }

    public ServerResponse getAllWorkers() {
        Response response = workerRestIml.getAllWorkers();
        if (response.isSuccess()) {
            List<Worker> workers = response.getData().getWorkers();
            return ServerResponse.builder()
                    .data(workers)
                    .success(true)
                    .build();
        } else {
            ErrorDto errorDto = response.getError();
            return ServerResponse.builder()
                    .error(errorDto)
                    .success(false)
                    .build();
        }
    }
}
