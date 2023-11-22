package com.momchi.back.Comment;

import com.momchi.back.User.User;
import com.momchi.back.User.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl {
    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;
    public void saveComment (Comment comment){
        commentRepository.saveComment(comment);
    }
    public List<Comment> getCommentByPostId(Long postId){
        List<Comment> comments = commentRepository.getCommentByPostId(postId);
        for (int i = 0; i < comments.size(); i++) {
            User user = userService.findById(comments.get(i).getUserId());
            comments.get(i).setNickname(user.getNickname());
        }
        return comments;
    }
    public void updateComment(Comment comment){
        commentRepository.updateComment(comment);
    }
    public void deleteComment(Long commentId){
        commentRepository.deleteComment(commentId);
    }
}
