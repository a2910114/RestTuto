package com.mykhaylenko.messanger.service;

import com.mykhaylenko.messanger.database.DatabaseClass;
import com.mykhaylenko.messanger.model.Comment;
import com.mykhaylenko.messanger.model.ErrorMessage;
import com.mykhaylenko.messanger.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pavlo.mykhaylenko on 7/28/2015.
 */
public class CommentService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://link.com");
        Response response = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();

        Message message = messages.get(messageId);

        if (message == null){
            throw new WebApplicationException(response);
        }

        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);

        if (comment == null) {
            throw new WebApplicationException(response);
        }

        return comment;
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();

        if (comment.getId() <= 0) {
            return null;
        }

        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
