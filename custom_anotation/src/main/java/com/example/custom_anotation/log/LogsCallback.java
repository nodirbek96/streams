package com.example.custom_anotation.log;

import java.io.File;

public interface LogsCallback {
    File createDirectory(String dirName);
    File createFile(String url,String fileName);
    File writeIntoFile(String folderName,String fileName,String input,String prefix);
    String convertToJson(Object o);
    String makefileName();
}
