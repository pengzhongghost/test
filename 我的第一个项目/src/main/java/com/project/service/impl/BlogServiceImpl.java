package com.project.service.impl;

import com.project.mapper.BlogMapper;
import com.project.mapper.CommentMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.Blog;
import com.project.pojo.BlogExample;
import com.project.pojo.Comment;
import com.project.pojo.User;
import com.project.service.BlogService;
import com.project.utill.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentMapper commentMapper;
    @Override
    @Transactional
    public Integer save(Blog blog) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        blog.setDate(date);
        Blog blog1=blogMapper.selectByUid(blog.getUid());
        if (blog1!=null){
            return blogMapper.updateByUid(blog);
        }else {
            blog.setPublish(0);
            return blogMapper.insertSelective(blog);
        }
    }

    @Override
    public Blog beforeSave(Integer uid) {

        return blogMapper.selectByUid(uid);
    }

    @Override
    @Transactional
    public Integer publish(Blog blog) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        blog.setDate(date);
        blog.setPublish(1);
        blog.setStar(0);
        return blogMapper.insert(blog);
    }

    @Override
    public PageBean<Blog> selectAll(String searchinfo1,Integer index) {

        PageBean<Blog> pageBean=new PageBean<>();
        pageBean.setIndex(index);
        String searchinfo=null;
        if (searchinfo1!=null&&searchinfo1!=""){
            searchinfo="%"+searchinfo1+"%";
        }
        int count=blogMapper.countBySome(searchinfo);

        pageBean.setTotalCount(count);

        int startRow = pageBean.getStartRow();
        int sendRow = pageBean.getEndRow();
        int endRow=sendRow-startRow;


        List<Blog> blogs=blogMapper.selectBySome(startRow,endRow,searchinfo);

        pageBean.setList(blogs);
        for (Blog blog : blogs) {
            User user = userMapper.selectByPrimaryKey(blog.getUid());
            blog.setUser(user);
            String text1 = blog.getIntroduction();
            if (text1.length()>=100){
                text1=text1.substring(0,100);
            }
            String text=text1+"...";
            blog.setIntroduction(text);

        }

//        int[] numbers1 = pageBean.getNumbers();
//
//        int[] numbers = new int[3];
//        if (numbers1!=null){
//            if (numbers1.length>3){
//                if (index-1==0){
//                    numbers[0]=1;
//                    numbers[1]=2;
//                    numbers[2]=3;
//                }else if (index+1>=pageBean.getTotalPageCount()-1){
//                    numbers[0]=pageBean.getTotalPageCount()-3;
//                    numbers[1]=pageBean.getTotalPageCount()-2;
//                    numbers[2]=pageBean.getTotalPageCount()-1;
//                }else {
//                    numbers[0]=index-1;
//                    numbers[1]=index;
//                    numbers[2]=index+1;
//                }
//                pageBean.setNumbers(numbers);
//            }else {
//                pageBean.setNumbers(numbers1);
//            }
//        }
//        System.out.println(pageBean.getTotalPageCount());
//        System.out.println(pageBean.getNumbers().length);
        return pageBean;
    }

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    private void recursively(int tid,Comment comment) {
            tempReplys.add(comment);

            User user1 = userMapper.selectByPrimaryKey(comment.getUid());
        comment.setUser(user1);
        Comment comment1=commentMapper.findSeniorUid(comment.getTextgrade());
        if (comment1!=null){
            User user2 = userMapper.selectByPrimaryKey(comment1.getUid());
            comment.setSenior(user2);
        }
            List<Comment> replys = commentMapper.selectByTidAndPar(tid, comment.getCid());
        if (replys.size()>0) {
            for (Comment reply : replys) {
                        recursively(tid,reply);
                    }
        }
    }
    @Override
    public Blog selectByTid(Integer tid) {
        Blog blog = blogMapper.selectByPrimaryKey(tid);
        User user = userMapper.selectByPrimaryKey(blog.getUid());
        blog.setUser(user);
        List<Comment> comments=commentMapper.selectByTid(tid);
        for (Comment comment : comments) {

            List<Comment> comments1 = commentMapper.selectByTidAndPar(tid, comment.getCid());
            comment.setReplyComments(comments1);
            if (comments1.size()>0){
                for (Comment comment1 : comments1) {

                    recursively(tid,comment1);

                }
            }
            User user1 = userMapper.selectByPrimaryKey(comment.getUid());
            comment.setUser(user1);
            Comment comment1=commentMapper.findSeniorUid(comment.getTextgrade());
            if (comment1!=null){
                User user2 = userMapper.selectByPrimaryKey(comment1.getUid());
                comment.setSenior(user2);
            }
            comment.setReplyComments(tempReplys);
            tempReplys=new ArrayList<>();
        }
        blog.setComments(comments);
//        System.out.println(tid);
//        List<Comment> comments2=commentMapper.selectByTidAndPar(tid);
//        //System.out.println(comments2);
//        for (Comment comment : comments2) {
//            User user1 = userMapper.selectByPrimaryKey(comment.getUid());
//            comment.setUser(user1);
//            Comment comment1=commentMapper.findSeniorUid(comment.getTextgrade());
//            User user2 = userMapper.selectByPrimaryKey(comment1.getUid());
//            comment.setSenior(user2);
//        }
//
//        User user15 =null;
//        User user12=null;
//        Comment comment3 = commentMapper.selectByTidAndParAndPar1(tid);
//        if (comment3!=null){
//            Comment comment10=commentMapper.findSeniorUid(comment3.getTextgrade());
//            user15 = userMapper.selectByPrimaryKey(comment3.getUid());
//            user12 = userMapper.selectByPrimaryKey(comment10.getUid());
//            comment3.setUser(user15);
//            comment3.setSenior(user12);
//        }
//        blog.setComment3(comment3);
//
//
//
//        int i = commentMapper.selectByTidAndParAndParCount(tid);
//        List<Comment> comments3 =null;
//        if (i>1){
//            comments3 = commentMapper.selectByTidAndParAndPar(tid,i-1);
//            for (Comment comment : comments3) {
//                User user1 = userMapper.selectByPrimaryKey(comment.getUid());
//                comment.setUser(user1);
//                Comment comment1=commentMapper.findSeniorUid(comment.getTextgrade());
//                User user10 = userMapper.selectByPrimaryKey(comment1.getUid());
//                comment.setSenior(user10);
//            }
//        }
//        blog.setComments2(comments2);
//        blog.setComments3(comments3);
        return blog;
    }

    private Integer star=0;
    @Override
    public Integer starAddByTid(Integer tid) {

        Blog blog = blogMapper.selectByPrimaryKey(tid);
        Integer i = blog.getStarperson();

        if (blog.getStar()==0){
            star=1;
        }else {
            star=blog.getStar()+1;
        }
        blogMapper.updateByTidAndStar(tid,star);
        return star;
    }

    @Override
    public Integer starSubByTid(Integer tid) {
        Blog blog = blogMapper.selectByPrimaryKey(tid);
        if (blog.getStar()==0){
            star=0;
        }else {
            star=blog.getStar()-1;
            blogMapper.updateByTidAndStar(tid,star);
        }
        return star;

    }

    @Override
    public List<Blog> showFirstThreeBlogs() {

        return blogMapper.selectFirstThreeBlogs();
    }

    @Override
    public List<Blog> showSecondThreeBlogs() {
        return blogMapper.selectSecondThreeBlogs();
    }
}
