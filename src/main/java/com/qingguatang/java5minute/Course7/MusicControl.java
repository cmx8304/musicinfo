package com.qingguatang.java5minute.Course7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caomengxi 2018/8/9.
 * @version 1.0
 */
@Controller
public class MusicControl {

    private static final Map<String,String> musics = new HashMap<>();

    @RequestMapping(value = "/song/music")
    @ResponseBody
    public String getMusicSrc(String songId){
        return musics.get(songId);
    }

    //这个注解的作用是让这个类在应用初始化的时候能够自动执行，也就是说当我们执行其他方法的时候，这个 musics 的 hashmap 的值就已经有了
    @PostConstruct
    public void init(){
        musics.put("35847388","https://m10.music.126.net/20180810114228/9492f3befe210dfba5925fba88598597/ymusic/de9a/6885/e183/effb8f74546c98fd619d51f22e2bfaaf.mp3");
        musics.put("2117009","https://m10.music.126.net/20180810114114/6a652ae44e5382985596a1ed684bbaad/ymusic/56e1/ec67/c249/c07799185b858908bd85268507f44b1e.mp3");
    }
}
