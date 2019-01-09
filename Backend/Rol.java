package Backend;
import java.util.*;


public class Rol 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    /*
     * Posibles nombres para el rol según el país:
     * ESP:
     * 	Agente (nivel1)
     * 	CoordinadorLocalE(nivel2)
     *	CoordinadorGeneralE(nivel3)
     * HON:
     * 	CoordinadorLocalH(nivel1)
     * 	CoordinadorProyectoH(nivel2)
     * 	CoordinadorGeneralH(nivel3)
     * */
    
    private String rolName;
    private int nivel;
    private String pais;
    private String rolDes;
    
    public static String pais(String name) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	Object[] tupla = miBD.Select("SELECT * FROM tRol WHERE rolName = '"
    			+ name + "';").get(0);
    	String pais = (String)tupla[3];
    	return pais;
    }
    
    public static boolean rolValido(String name, String pais) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tRol WHERE rolName = '"
    			+ name + "' and pais = '" + pais + "';");
    	return !lista.isEmpty();
    }

	public static List<Rol> ListaRoles()
	{ 
		// Retorna una lista con todos los obejtos de la clase almacenados en la base de datos		
		List<Rol> lista = new ArrayList<Rol>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tRol;"))
		{
			Rol r = new Rol( (String)tupla[0],(String)tupla[3] );
			lista.add(r);
		}
		return lista;
	}
		
    public Rol(String name, String pais)
    {
		// Crea el objeto cargando sus valores de la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	Object[] tupla = miBD.Select("SELECT * FROM tRol WHERE rolName = '"
    			+ name + "' and pais = '" + pais + "';").get(0);
    	
    	rolName = (String)tupla[0];
    	rolDes = (String)tupla[1];
        nivel = (Integer)tupla[2];
        this.pais = (String)tupla[3];
    }
    
    public Rol(String name, String des, int nivel, String pais)
    {
		// Crea el objeto y lo inserta en la base de datos
    	if ((name == "Agente" && pais == "Honduras") || (name == "CoordinadorProyecto" && pais == "España"))
    		throw new Error("Este rol no es válido para el pais escogido.");
    	
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Insert("INSERT INTO tRol VALUES('" + name +
    			"', '" + des + "', " + nivel + ",'"+pais+"');");
    	rolName = name;
        rolDes = des;
        this.nivel = nivel;
        this.pais = pais;
    }
	
    public String getRolName() 
    { 
    	return rolName; 
    }
        
    public void setRolName(String value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	if ((value == "Agente" && pais == "Honduras") || (value == "CoordinadorProyecto" && pais == "España"))
    		throw new Error("Este rol no es válido para tu pais.");
    	
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

	public String getPais() {
		return pais;
	} 
}
