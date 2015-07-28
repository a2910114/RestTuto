package com.mykhaylenko.messanger.recources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by pavlo.mykhaylenko on 7/28/2015.
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoRecource {

    @GET
    @Path("/annotations")
    public String getparamsUsingAnnotations(@MatrixParam("param") String param,
                                            @HeaderParam("customHeaderValue") String header,
                                            @CookieParam("name") String cookie) {
        return "test" + param + "Header" + header + "cookie: "+cookie;
    }

    @GET
    @Path("/context")
    public String getParamsusingContext(@Context UriInfo uriInfo,
                                        @Context HttpHeaders headers) {
        String absolutePath = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "absolutePath: " + absolutePath + " cookies " + cookies;
    }

}
