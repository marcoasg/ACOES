package Backend;
import java.util.*;

public class Usuario 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String nombre;
    private String password;
    private Rol rol;

	public static List<Usuario> ListaUsuarios()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Usuario> lista = new ArrayList<Usuario>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tUsuario;"))
		{
			Usuario r = new Usuario( (String)tupla[0], (String)tupla[1],new Rol((String)tupla[2]) );
			lista.add(r);
		}
		return lista;
	}
	
    public Usuario(String n, String p)
    {
		// Crea el objeto cargando sus valores de la base de datos
		// Si la password almacenada no se corresponde con la suministrada se elevará una excepción
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	Object[] tupla = miBD.Select("SELECT * FROM tUsuario WHERE nombre = '"
    			+ n + "' and password = '" + "';").get(0);
    	
    	nombre = (String)tupla[0];
    	password = (String)tupla[1];
        rol = (Rol)tupla[2];
        
    }
    
    public Usuario(String n, String p, Rol r)
    {
		// Crea el objeto y lo inserta en la base de datos
    	nombre = n;
    	password = p;
    	rol = r;
    }

    public String getNombre() 
    { 
    	return nombre; 
    }

    public void setNombre(String value) 
    { 
    	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE usuario set nombre = '" + value + "' WHERE nombre = '" + nombre + "';");
    	nombre = value;
    	

    }

    public void borraUsuario() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Delete("DELETE FROM usuario WHERE nombre = '" + nombre + "' and password = '" + password +  "';");
    	nombre = null;
    	password = null;
    	rol = null;
    	
    }
    public String getPassword() 
    { 
    	return password; 
    }
        
    public void setPassword (String value)
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE usuario set password = '" + value + "' WHERE nombre = '" + nombre + "';");
    	password = value;
    }

    public Rol getRol()
    {
        return rol;
    }
    
    public void setRol()
    {
    	throw new Error("Error: Un usuario no puede cambiar el rol de si mismo.");     
    }

    public void ModiRol(Usuario u, Rol r)
    {
		// Si el objeto actual es administrador
		// Actualiza el atributo rol de u en memoria y en la base de datos
    	if (this.rol.getRolName() == "Admin" ) {
        	BD miBD = new BD(BD_SERVER, BD_NAME);
        	miBD.Update("UPDATE usuario set rol = '" + r + "' WHERE nombre = '" + nombre + "';");
    		u.rol = r;
    		
    	} else {
    		throw new Error("Error: Necesitas ser administrador para cambiar los roles de otros usuarios.");
    	}

    }

    public boolean AccesoPantalla(String p)
    {
        return rol.Acceso(p);
    }

    public boolean ModificaPantalla(String p)
    {
        return rol.Modificacion(p);
    }
	
	public String toString()
	{
	
		return nombre + "\t" + password + "\t" + rol.getRolName();
	}
}
