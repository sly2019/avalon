package com.sly.demo.service.impl;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.sly.demo.config.ProjectConfig;
import com.sly.demo.service.SpeechService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Slf4j
public class SpeechServiceImpl implements SpeechService {
    @Autowired
    ProjectConfig projectConfig;

    @Override
    public String  readText(String text){
        log.info("语音合成时间:{}",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ActiveXComponent activeXComponent = null;
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +  "/" + LocalDateTime.now().getHour();
        String path =  projectConfig.getFilePath() + format;
        fileNexistThenCreate( path);
        String fileName = UUID.randomUUID().toString().replaceAll("-","") +".mp3";
        String filePath = path +"/"+ fileName;
        try {
            activeXComponent = new ActiveXComponent("Sapi.SpVoice");
//          运行时输出语音内容
            Dispatch dispatch = activeXComponent.getObject();
            /*Variant variant = Dispatch.call(dispatch, "GetDescription");
            log.info("当前语音库：{}", variant.toString());*/
//          设置音量
            //activeXComponent.setProperty("Volume", new Variant(100));
            activeXComponent.setProperty("Volume", new Variant(100));
////          语音的朗读速度-10到 +10
            //activeXComponent.setProperty("Rate", new Variant(-1));
            activeXComponent.setProperty("Rate", new Variant(1));
////          调用执行朗读
//            Dispatch.call(dispatch, "Speak",new Variant(text));

//          生成语音文件
            activeXComponent = new ActiveXComponent("Sapi.SpFileStream");
            Dispatch fileStreamDispatch = activeXComponent.getObject();

//          音频
            activeXComponent = new ActiveXComponent("Sapi.SpAudioFormat");
            Dispatch audioDispatch = activeXComponent.getObject();

//          设置文件流格式
            Dispatch.putRef(fileStreamDispatch, "Format", audioDispatch);
//          设置音频流格式
            Dispatch.put(audioDispatch, "Type", new Variant(22));

//          调用输出文件流打开方法，创建一个.wav .mp3 .mp4   .wma文件
            Dispatch.call(fileStreamDispatch, "Open", new Variant(filePath),new Variant(3),new Variant(true));
//          设置声音对象的音频流输出流为输出文件对象
            Dispatch.putRef(dispatch, "AudioOutputStream", fileStreamDispatch);

//          设置音量0-100
            //Dispatch.put(dispatch, "Volume", new Variant(100));
            Dispatch.put(dispatch, "Volume", new Variant(100));
//          设置朗读速度
            //Dispatch.put(dispatch, "Rate", new Variant(-2));
            Dispatch.put(dispatch, "Rate", new Variant(1));
////          开始朗读
            Dispatch.call(dispatch, "Speak",new Variant(text));

//          关闭输出文件流
            Dispatch.call(fileStreamDispatch, "Close");
            Dispatch.putRef(dispatch, "AudioOutputStream", null);

            audioDispatch.safeRelease();
            fileStreamDispatch.safeRelease();
            dispatch.safeRelease();

            activeXComponent.safeRelease();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw  new RuntimeException(e.getMessage());

        }
        return "/api/intelligent/voice/download/"+ format + "/" + fileName;
    }

    private void fileNexistThenCreate(String paths){
        File file = new File(paths);
        if (!file.exists()){
            file.mkdirs();
        }
    }

}
