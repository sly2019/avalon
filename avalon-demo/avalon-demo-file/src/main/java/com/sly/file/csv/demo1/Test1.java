package com.sly.file.csv.demo1;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/6/4
 * @Description TODO
 */
public class Test1 {

    private static final String FILE_PATH = "D:\\program\\app3.0\\3.csv";

    public static void main(String[] args) {

        List<String> propertyName = new ArrayList<>();
        List<List<String>> datas = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            // CSV文件的分隔符
            String DELIMITER = ",";
            // 按行读取
            String line;
            boolean flag = true;
            while ((line = br.readLine()) != null) {
                // 分割
                String[] columns = line.split(DELIMITER);
                List<String> data = new ArrayList<>();
                for(String str : columns){
                    data.add(str);
                }
                if(flag){
                    propertyName = data;
                    flag = false;
                } else {
                    datas.add(data);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(JSON.toJSONString(propertyName));
        System.out.println(propertyName.size());
        System.out.println(datas.size());
        for(int i = 0; i < datas.size(); i++){
            if(datas.get(i).size() != propertyName.size()){
                System.out.println(JSON.toJSONString(datas.get(i)));
            }
        }

        for(int i = 1; i < propertyName.size(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append("{\"system.");
            sb.append(propertyName.get(i));
            sb.append("\":[");
            for(int j = 0; j < datas.size(); j ++){
                if(j != 0){
                    sb.append(",");
                }
                sb.append("{\"timestamp\":'");
                sb.append(datas.get(j).get(0));
                sb.append("', \"value\":");
                sb.append(datas.get(j).get(i));
                sb.append("}");
            }
            sb.append("]}");
            //System.out.println("=====================   " + propertyName.get(i) + "   =====================");
            System.out.println(sb.toString());
            //System.out.println();
            System.out.println();
        }
    }

}
