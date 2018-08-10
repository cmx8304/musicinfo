package com.qingguatang.java5minute.course4;

import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.CommentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author caomengxi 2018/8/8.
 * @version 1.0
 */
@Controller
public class CommentControl {

    @Autowired
    private CommentPostControl commentPostControl;

    @RequestMapping(value = "/comments")
    public String comments(ModelMap modelMap){

        List<Comment> comments = commentPostControl.getComments("35847388");
        modelMap.addAttribute("comments",comments);
        return "comments";
    }

    /*private List<Comment> getComment(){
        List<Comment> comments = new ArrayList<>();
        Comment comment = new Comment();
        comment.setIcon("http://p1.music.126.net/vGKrH1IzLT27xF8TPEGE7Q==/109951163411337685.jpg?param=50y50");
        comment.setNickName("AriLuv");
        comment.setContent("hello！一转眼四年了！终于等到王者的归来~阿呆的全球屠榜又要开始啦！在此献上我的鸡腿！嘻嘻~");
        comment.setCommentTime(new Date());
        comment.setLikeNum(82747);

        comments.add(comment);
        return  comments;
    }*/
}
