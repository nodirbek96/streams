package com.example.custom_anotation.rest;

import com.example.custom_anotation.dto.ErrorDto;
import com.example.custom_anotation.dto.Response;
import com.example.custom_anotation.dto.Worker;
import com.example.custom_anotation.log.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class WorkerRestIml implements WorkerRestCallbacks {
    private final RestTemplate restTemplate;
    private final LogsService logsService;
    @Value("${url.worker.insert}")
    private String urlInsert;
    @Value("${url.worker.getAll}")
    private String urlGetAll;

    @Override
    public Response insertWorker(Worker worker) {
        HttpHeaders headers =makeCommonHeaders();
        Response response;
        HttpEntity<Worker> entity = new HttpEntity<>(worker, headers);
        try {
            ResponseEntity<Response> responseEntity =
                    restTemplate.exchange(urlInsert, HttpMethod.POST, entity, Response.class);
            response = responseEntity.getBody();
            logsService.writeIntoFile("worker",
                    logsService.makefileName(),
                    logsService.convertToJson(responseEntity),
                    "\n");
        } catch (HttpStatusCodeException exception) {
            response = Response.builder().
                    error(ErrorDto.builder().
                            code(1).
                            message(exception.getLocalizedMessage()).
                            build()).
                    build();
        }
        return response;
    }
    @Override
    public Response getAllWorkers() {
        HttpHeaders headers=makeCommonHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        Response response;
        try{
            ResponseEntity<Response> responseEntity=
                    restTemplate.exchange(urlGetAll,HttpMethod.GET,entity, Response.class);
            response=responseEntity.getBody();
            logsService.writeIntoFile("workers",
                    logsService.makefileName(),
                    logsService.convertToJson(responseEntity),
                    "\n");
        }catch (HttpStatusCodeException exception) {
            response = Response.builder().
                    error(ErrorDto.builder().
                            code(1).
                            message(exception.getLocalizedMessage()).
                            build()).
                    build();
        }
        return response;
    }
    private HttpHeaders makeCommonHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }
}
