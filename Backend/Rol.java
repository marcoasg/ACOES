package Backend;
import java.util.*;


public class Rol 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String rolName;
    // nivel 1 : Agente; nivel 2 : Coord local; nivel 3 : Admin y Coord general
    private int nivel;
    private String rolDes;

	public static List<Rol> ListaRoles()
	{ 
		// Retorna una lista con todos los obejtos de la clase almacenados en la base de datos		
		List<Rol> lista = new ArrayList<Rol>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tRol;"))
		{
			Rol r = new Rol( (String)tupla[0] );
			lista.add(r);
		}
		return lista;
	}
		
    public Rol(String name)
    {
    	if (name != "Admin" && name != "CoordGen" && name != "CoordLoc" && name != "Agt") {
    		throw new Error("El rol no es correcto.");
    	}
		// Crea el objeto cargando sus valores de la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	Object[] tupla = miBD.Select("SELECT * FROM tRol WHERE rolName = '"
    			+ name + "';").get(0);
    	
    	rolName = (String)tupla[0];
    	rolDes = (String)tupla[1];
        nivel = (Integer)tupla[2];
    }
    
    public Rol(String name, String des, int nivel)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Insert("INSERT INTO tRol VALUES('" + name +
    			"', '" + des + "', " + nivel + ");");
    	rolName = name;
        rolDes = des;
        this.nivel = nivel;
    }
	
    public String getRolName() 
    { 
    	return rolName; 
    }
        
    public void setRolName(String value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tRol SET rolName = '" + value 
    			+ "' WHERE rolName = '"+ this.rolName + "';");
    	this.rolName = value;    		
    }

    public String getRolDes() 
    { 
    	return rolDes; 
    }
    
    public void setRolDes(String value) 
    {
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tRol SET rolDes = '" + value 
    			+ "' WHERE rolName = '"+ this.rolName + "';");
    	this.rolDes = value;   
    }

    public int getNivel() {
    	return nivel;
    }
    
    public void setNivel(int niv) {
    	nivel = niv;
    }

    
}
