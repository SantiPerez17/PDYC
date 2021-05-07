/**
 * 
 */
package ar.edu.unnoba.pdyc2021.mymusic.resource;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.unnoba.pdyc2021.mymusic.dto.userDTO;
import ar.edu.unnoba.pdyc2021.mymusic.model.User;
import ar.edu.unnoba.pdyc2021.mymusic.service.UserService;

/**
 * @author Santiago
 *
 */
@Path("/users")
public class UserResource {

    @Autowired
    private UserService userService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
    	ModelMapper modelMapper = new ModelMapper();
    	Type ListType = new TypeToken<List<userDTO>>(){}.getType();
    	List<userDTO> list = modelMapper.map(userService.getUsers(), ListType);
        return Response.ok(list).build();
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user)
    {
    	return userService.addUser(user);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getCountryById(@PathParam("id") Long id)
    {
    	return userService.findUser(id);
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Long id)
    {
    	userService.deleteUser(id);
  
    }
    @PUT
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@RequestBody User user, @PathParam("id") Long id)
    {
    		return userService.updateUser(user, id);
  
    }
    
    

}
