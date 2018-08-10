package com.qingguatang.java5minute.course3;

import com.qingguatang.java5minute.course3.model.SongInfo;
import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.CommentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 歌曲信息类
 * @author cmx 2018/8/8.
 * @version 1.0
 */
@Controller
public class SongInfoControl {

    @Autowired
    private CommentPostControl commentPostControl;

    private static Map<String, SongInfo> songInfoMap = new HashMap<>();

    @RequestMapping(value = "/songinfo")
    public String index(String songId,ModelMap modelMap){

        if (songId == null){
            songId = "35847388";
        }
        SongInfo songInfo = songInfoMap.get(songId);
        modelMap.addAttribute("song",songInfo);

        List<Comment> comments = commentPostControl.getComments(songId);
        modelMap.addAttribute("comments",comments);

        return "index";

    }

    @RequestMapping(value = "/songinfo/get")
    @ResponseBody
    public SongInfo get(String songId){
        SongInfo songInfo = songInfoMap.get(songId);
        return songInfo;
    }

    @PostConstruct
    public void init(){
        SongInfo songInfo = new SongInfo();
        songInfo.setId("35847388");
        songInfo.setName("hello");
        songInfo.setSinger("Adele");
        songInfo.setAlbumName("Hello");
        songInfo.setCommentCount(10);
        songInfo.setAlbumImg("http://p1.music.126.net/PrO7oPvnjvH4xdujdGbf2w==/1407374890649284.jpg");
        songInfo.setLvrics("Hello, it's me <br/> 你好吗 是我 <br/> I was wondering if after all these years you'd like to meet <br/> ");
        songInfoMap.put("35847388",songInfo);

        songInfo = new SongInfo();
        songInfo.setId("2117009");
        songInfo.setName("Set Fire to the Rain");
        songInfo.setSinger("Adele");
        songInfo.setAlbumName("Hello");
        songInfo.setCommentCount(10);
        songInfo.setAlbumImg("http://p1.music.126.net/1Ep5P29fQ0cepjr-OnnTHA==/18154036486504197.jpg");
        songInfo.setLvrics("I let it fall, my heart <br/> 我本任由我心沉沦着 <br/> And as it fell, you rose to claim it <br/> ");
        songInfoMap.put("2117009",songInfo);
    }
}
