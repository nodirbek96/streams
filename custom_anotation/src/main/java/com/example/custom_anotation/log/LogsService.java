package com.example.custom_anotation.log;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class LogsService implements LogsCallback{
    @Override
    public File createDirectory(String dirName) {
        File txtFile;
        txtFile = new File("log/"+dirName);
        if (!txtFile.exists()) {
            txtFile.mkdirs();
        }
        return txtFile;
    }
    @Override
    public File createFile(String url,String fileName) {
        String FILE_NAME=url+"/"+fileName+".log";
        File newFile = new File(FILE_NAME);
        try {
            boolean success=newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newFile;
    }
    @Override
    public File writeIntoFile(String folderName,String fileName,String input,String prefix) {
        File dir=createDirectory(folderName);
        File file=createFile(dir.getPath(),fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), true));
            writer.append(prefix);
            writer.append(input);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    @Override
    public String convertToJson(Object o) {
        ObjectMapper objectMapper=new ObjectMapper();
        String json;
        try {
            json= objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    @Override
    public String makefileName() {
        LocalDate localDate=LocalDate.now();
        return formatInteger(localDate.getDayOfMonth()) + "." +
                formatInteger(localDate.getMonthValue()) + "." + localDate.getYear();
    }
    private String formatInteger(int a) {
        String format = String.valueOf(a);
        if (a < 10) {
            format = "0" + a;
        }
        return format;
    }
}
