package com.sly.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @Author by wj on 2021/7/9 15:57
 * @Description TODO
 */
@Slf4j
public class FileUtils {

    public static void getSpecifiedLevel(File dir, int level, List<File> fileList){
        if(level < 1){
            throw new RuntimeException("level must be greater than or equal to 1");
        }
        if(dir == null){
            return;
        }
        File[] files = dir.listFiles();

    }
}
