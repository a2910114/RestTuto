package com.mykhaylenko.messanger.recources;

import javax.ws.rs.Path;

/**
 * Created by pavlo.mykhaylenko on 7/27/2015.
 */
@Path("/messages")
public class MessageRecource {

    public String getMessages() {
        return "Hello word";
    }
}
