package com.mykhaylenko.messanger.recources;

import com.mykhaylenko.messanger.model.Message;
import com.mykhaylenko.messanger.recources.beans.MessageFilterBean;
import com.mykhaylenko.messanger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by pavlo.mykhaylenko on 7/27/2015.
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageRecource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() > 0) {
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
            return messageService.getMessagesPagitated(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
        Message message = messageService.getMessage(id);

        message.addLinks(getAbsolutePath(uriInfo), "self");
        message.addLinks(getProfileUri(uriInfo, message), "profile");
        message.addLinks(getCommntUri(uriInfo, message), "comments");

        return message;
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        Message newMessage = messageService.addMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();

        return Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{massageId}")
    public void deleteMessage(@PathParam("massageId") long id) {
        messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

    private String getAbsolutePath(UriInfo uriInfo) {
        return uriInfo.getAbsolutePath().toString();
    }

    private String getProfileUri(UriInfo uriInfo, Message message) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(ProfileResource.class)
                .path(message.getAuthor())
                .build()
                .toString();
        return uri;
    }

    private String getCommntUri(UriInfo uriInfo, Message message) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(MessageRecource.class)
                .path(MessageRecource.class, "getCommentResource")
                .path(CommentResource.class)
                .resolveTemplate("messageId", message.getId())
                .build()
                .toString();
        return uri;
    }
}

