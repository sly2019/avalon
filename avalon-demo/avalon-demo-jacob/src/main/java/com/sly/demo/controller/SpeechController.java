package com.sly.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import com.sly.demo.config.ProjectConfig;
import com.sly.demo.service.SpeechService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/intelligent/voice")
@Slf4j
public class SpeechController {
    @Autowired
    SpeechService speechService;
    @Autowired
    ProjectConfig projectConfig;

    private static RateLimiter rateLimiter  = RateLimiter.create(15);
    @RequestMapping(value = "/compound",method = RequestMethod.POST)
    public Map<String,Object> voiceSynthesis(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        log.info(projectConfig.getTest());
        if (rateLimiter.tryAcquire(1000,TimeUnit.MILLISECONDS)){
            log.info("获取令牌失败");
        }
        Map<String,Object>  map = new HashMap();
        try {
            String host = request.getHeader("host");
            if ( null == jsonObject || StringUtils.isEmpty(jsonObject.getString("data"))){
                throw new RuntimeException("输入数据为空");
            }
            String data = jsonObject.getString("data");
            //合成语音并返回语音存储路径
            String s = speechService.readText(data);
            map.put("status",200);
            map.put("message","语音合成成功");
            map.put("data",host + s);
            map.put("timestamp",System.currentTimeMillis());
        }catch (Exception e){
            map.put("status",500);
            map.put("message","语音合成失败");
            log.error(e.getMessage());
            throw  new RuntimeException(e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/download/{path}/{hour}/{fileName}",method = RequestMethod.GET)
    public void downloadVoice(@PathVariable String path, @PathVariable String hour, @PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(path)|| StringUtils.isEmpty(hour) || StringUtils.isEmpty(fileName)){
            throw new RuntimeException("下载路径为空");
        }
        log.info(request.getRemoteAddr());
        String s = projectConfig.getFilePath() + path+ "/" + hour + "/" + fileName;
        response.setCharacterEncoding(request.getCharacterEncoding());
        //设置文件类型
        response.setContentType("audio/mp3");
        FileInputStream fis = null;
        try {
            File file = new File(s);
            fis = new FileInputStream(file);
            //设置文件名字
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            log.error("文件不存在");
            throw new RuntimeException("文件不存在");
        } catch (IOException e) {
            log.error("文件读取异常");
            throw new RuntimeException("文件读取异常");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error("关闭资源失败");
                    e.printStackTrace();
                }
            }
        }
    }
}
