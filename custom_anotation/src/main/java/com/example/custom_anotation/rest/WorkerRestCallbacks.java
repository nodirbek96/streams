package com.example.custom_anotation.rest;

import com.example.custom_anotation.dto.Response;
import com.example.custom_anotation.dto.Worker;

public interface WorkerRestCallbacks {
    Response insertWorker(Worker worker);
    Response getAllWorkers();
}
