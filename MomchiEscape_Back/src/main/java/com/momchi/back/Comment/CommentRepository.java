package com.momchi.back.Comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    void saveComment(Comment comment);
    List<Comment> getCommentByPostId(Long videoId);
    void updateComment(Comment comment);
    void deleteComment(Long commentId);
}
