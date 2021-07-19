package com.sly.base.utils;

import java.io.File;
import java.util.List;

/**
 * @Created by wj on 2021/7/9 15:57
 * @Description TODO
 */
public class FileUtils {

    /**
     * 递归获取指定层级的文件或目录
     * @param dir
     * @param level
     * @param fileList
     */
    public static void getSpecifiedLevel(File dir, int level, List<File> fileList){
        if(level < 1){
            throw new RuntimeException("level must be greater than or equal to 1");
        }
        if(dir == null){
            return;
        }
        File[] files = dir.listFiles();
        if(files == null){
            return;
        }
        for(int i = 0; i < files.length; i++){
            if(level == 1){
                fileList.add(files[i]);
            } else {
                File file = files[i];
                if(file.isDirectory()){
                    getSpecifiedLevel(file, level - 1, fileList);
                }
            }
        }
    }

    /**
     * 递归删除文件
     * @param file
     */
    public static void delFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File file1 : files){
                delFile(file1);
            }
            file.delete();
        } else {
            file.delete();
        }
    }

}
