package LevelsBeyond;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;


@Path("/notes")
public class NoteService {
	NoteDao noteDao = new NoteDao();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getAllOrOptionNotesInJSON(@QueryParam("query") String query)
	{
		return noteDao.getAllOrOptionNotes(query);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Note getANoteInJSON(@PathParam("id") int id)
	{
		return noteDao.getANote(id);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Note createANote(Note note)
	{
		return noteDao.createANote(note);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Note updateANote(@PathParam("id") int id, Note note)
	{
		note.setId(id);
		return noteDao.updateANote(note);
	}
	
	@DELETE
	@Path("{id}")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteANote(@PathParam("id") int id)
	{
		String idStr = Integer.toString(id);
		
		if (noteDao.deleteANote(id))
		{
			return "Note id: " + idStr + " is deleted\n";
		}
		
		return "id: " + idStr + " not found\n";
	}
	
	
}
