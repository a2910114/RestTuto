package com.mykhaylenko.jackson;

import com.mykhaylenko.messanger.model.Comment;
import com.mykhaylenko.messanger.model.Link;
import com.mykhaylenko.messanger.model.Message;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pavlo.mykhaylenko on 7/30/2015.
 */
public class JacksonExample {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Comment comment1 = new Comment(1L, "Comment1 message", "Comment1 Author");
        Comment comment2 = new Comment(2L, "Comment2 message", "Comment2 Author");

        Map<Long, Comment> comments = new HashMap<>();
        comments.put(comment1.getId(), comment1);
        comments.put(comment2.getId(), comment2);

        Link link1 = new Link();
        link1.setLink("link1");
        link1.setRel("rel1");

        Link link2 = new Link();
        link2.setLink("link2");
        link2.setRel("rel2");

        List links = new ArrayList<>();
        links.add(link1);
        links.add(link2);

        Message message = new Message(1, "Message content", "author");
        message.setComments(comments);
        message.setLinks(links);

        try {
            String result =  mapper.writeValueAsString(message);
            System.out.println(result);
            Message message1 = mapper.readValue(result, Message.class);
            System.out.printf("Message from message: %s\n", message1.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
