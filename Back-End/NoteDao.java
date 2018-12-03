package LevelsBeyond;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;
//import java.util.Comparator;


public class NoteDao {
	public static final String dataFile = "Notes.dat";
	
	@SuppressWarnings("unchecked")
	public Note getANote(int id)
	{
		List<Note> noteList = null;
		
		try { 
			File file = new File(dataFile); 
			if (!file.exists())
			{ 
				return null;
			} 
			else
			{ 
				FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	            noteList = (List<Note>) ois.readObject(); 
	            ois.close();
	            
	            for (Note note : noteList)
	            {
	            	if (note.getId() == id)
	            	{
	            		return note;
	            	}
	            }
			} 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Note createANote(Note note)
	{
		List<Note> noteList = null;
		Note newNote = null;
		//Note maxNote = null;
		
		try { 
			File file = new File(dataFile); 
			if (!file.exists())
			{ 
				newNote = new Note(1, note.getBody()); 
				noteList = new ArrayList<Note>(); 
				noteList.add(note); 
				saveNoteList(noteList); 
			} 
			else
			{ 
				FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	            noteList = (List<Note>) ois.readObject(); 
	            ois.close();
	            
	            //maxNote = Collections.max(noteList, Comparator.comparingInt(Note::getId));
	            //int maxId = maxNote.getId();
	            //int newId = maxId + 1;
	            int newId = noteList.size() + 1;
	            
	            newNote = new Note(newId, note.getBody());
	            noteList.add(newNote);
	            saveNoteList(noteList);
	            
			} 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		}
		
		return newNote;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Note> getAllOrOptionNotes(String query)
	{
		List<Note> noteList = null;
		List<Note> newOptionNoteList = null;
		
		if (query == null)
		{
			try { 
				File file = new File(dataFile);
	            
				if (!file.exists())
				{
					noteList = new ArrayList<Note>(); 
					saveNoteList(noteList); 
				} 
				else
				{ 
					FileInputStream fis = new FileInputStream(file); 
		            ObjectInputStream ois = new ObjectInputStream(fis); 
		            noteList = (List<Note>) ois.readObject(); 
		            ois.close(); 
				}
			
			} catch (IOException e) { 
				e.printStackTrace(); 
			} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
			}
			
			return noteList;
		}
		else
		{
		
			try { 
				File file = new File(dataFile); 
				if (!file.exists())
				{ 
					noteList = new ArrayList<Note>();
					saveNoteList(noteList); 
				} 
				else
				{ 
					FileInputStream fis = new FileInputStream(file); 
					ObjectInputStream ois = new ObjectInputStream(fis); 
					noteList = (List<Note>) ois.readObject(); 
					ois.close();
	            
					newOptionNoteList = new ArrayList<Note>();
					for (Note note : noteList)
					{
						boolean hasIt = note.getBody().contains(query);
						if (hasIt)
						{
							newOptionNoteList.add(note);
						}
					}
	            
				}
		
			} catch (IOException e) { 
				e.printStackTrace(); 
			} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
			}
		
			return newOptionNoteList;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Note updateANote(Note note)
	{
		List<Note> noteList = null;
		
		try { 
			File file = new File(dataFile); 
			if (!file.exists())
			{ 
				return null;
			} 
			else
			{ 
				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				noteList = (List<Note>) ois.readObject(); 
				ois.close();
	            
				for (Note eachNote : noteList)
				{
					if (eachNote.getId() == note.getId())
					{
						eachNote.setBody(note.getBody());
						saveNoteList(noteList);
						return eachNote;
					}
				}
	            
			}
		
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
		}
		
		return null;

	}
	

	@SuppressWarnings("unchecked")
	public boolean deleteANote(int id)
	{
		List<Note> noteList = null;
		List<Note> newNoteList = null;
		
		boolean isDeleted = false;
		
		try { 
			File file = new File(dataFile); 
			if (file.exists())
			{
				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				noteList = (List<Note>) ois.readObject(); 
				ois.close();
	            
				newNoteList = new ArrayList<Note>();
				for (Note eachNote : noteList)
				{
					if (eachNote.getId() != id)
					{
						newNoteList.add(eachNote);	
					}
					else
					{
						isDeleted = true;
					}
				}
				saveNoteList(newNoteList);
				noteList.clear();   
			}
		
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
		}

		return isDeleted;
	}
	
	private void saveNoteList(List<Note> noteList)
	{ 
		try { 
			File file = new File(dataFile); 
			FileOutputStream fos;  
			fos = new FileOutputStream(file); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(noteList); 
			oos.close(); 
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}		
	}
}