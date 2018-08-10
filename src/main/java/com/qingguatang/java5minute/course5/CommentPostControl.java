package com.qingguatang.java5minute.course5;

import com.qingguatang.java5minute.course4.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * @author caomengxi 2018/8/9.
 * @version 1.0
 */
@Controller
public class CommentPostControl {

    private static Map<String,List<Comment>> comments = new HashMap<>();

    @RequestMapping(value = "/comment/post")
    public String post(
            @RequestParam(value = "songId")String songId,Comment comment){

        Date commentTime = new Date();
        comment.setCommentTime(commentTime);
        comment.setId(UUID.randomUUID().toString());

        //java8Map,如果map里没有这个key，那么就按照后面的这个function添加对应的key和value
        //如果有这个key，那么就不添加
        //相当于以下的数据
        comments.computeIfAbsent(songId,k->new ArrayList<>()).add(comment);

        /*List<Comment> res;
        if(comments.containsKey(songId)){
            res = comments.get(songId);
        }else{
            res = new ArrayList<>();
            comments.put(songId,res);
        }
        res.add(comment);*/

        List<Comment> commentList = comments.get(songId);

        //倒序
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                if(o1.getCommentTime().after(o2.getCommentTime())){
                    return -1;
                }
                return 1;
            }
        });
        //return "redirect:/comments";
        return "redirect:/songinfo?songId=" + songId;
    }

    public List<Comment> getComments(String songId){
        return comments.get(songId);
    }
}
