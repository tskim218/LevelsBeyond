package LevelsBeyond;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


//import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@XmlRootElement(name = "note")
//@JsonPropertyOrder({ "id", "body" })
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String body;
	
	public Note()
	{
		super();
	}
	
	public Note(int id, String body)
	{
		super();
		this.id = id;
		this.body = body;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getBody()
	{
		return body;
	}
	
	public void setBody(String body)
	{
		this.body = body;
	}

}