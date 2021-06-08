package com.sly.supos.history.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sly.supos.utils.HttpClientUtil;
import com.sly.supos.utils.Reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by wj on 2021/6/8 15:07
 * @Description TODO
 */
public class Demo1 {

    private static final String FILE_PATH = "D:\\program\\app3.0\\61.csv";

    private static final String AUTHORIZATION = "Bearer a1ab3bee25ca42b39feac24927a77dbe";
    private static final String COOKIE = "acw_tc=0bc9524e16231394413863871edd4875a882f300ed7d658518653bab86033d; suposTicket=a1ab3bee25ca42b39feac24927a77dbe";
    private static final String URL = "http://supos30.demo.devcloud.supos.net/project/dam/supngin/api/dam/runtime/system/template/preheater/instance/Preheater_2/service/system/setPropertyVQTValues/debug";

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
            JSONObject postJson = new JSONObject();
            JSONObject jsonDatas = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for(int j = 0; j < datas.size(); j ++){
                JSONObject jsonData = new JSONObject();
                jsonData.put("timestamp", datas.get(j).get(0));
                jsonData.put("value", datas.get(j).get(i));
                jsonArray.add(jsonData);
            }
            jsonDatas.put("system." + propertyName.get(i), jsonArray);
            postJson.put("inputs", jsonDatas);
            Map<String, String> header = new HashMap<>();
            header.put("Authorization", AUTHORIZATION);
            header.put("Cookie", COOKIE);
            try {
                Reply res = HttpClientUtil.doPost(URL, JSON.toJSONString(postJson), header);
                System.out.println(JSON.toJSONString(res));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
