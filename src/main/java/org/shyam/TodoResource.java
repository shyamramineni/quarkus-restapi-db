package org.shyam;

import java.util.List;


import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/todo")
public class TodoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAll() {
        if(Todo.count() == 0) {
            populateData();
        }
            
        return Todo.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insert(Todo item) {
        item.persist();
        return Response.ok(item).status(201).build();

    }

    @Transactional
    public void populateData() {
        new Todo("one", false, 1).persist();
        new Todo("two", false, 2).persist();
        new Todo("three", false, 3).persist();
        new Todo("four", false, 4).persist();
        new Todo("five", false, 5).persist();
        new Todo("six", false, 6).persist();

    }


}



