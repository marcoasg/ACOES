package Backend;
import java.util.*;


public class Permiso implements Comparable<Permiso>
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
	private String rolName;
	private String pantalla;
    private boolean acceso;
    private boolean modificacion;


    public static List<Permiso> ListaPermisosRol(String rolName)
    {		
		// Retorna una lista con todos los permisos de un rol determinado
    	List<Permiso> permisos = new ArrayList<>();
    	BD miBD = new BD(BD_SERVER,BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tPermiso WHERE rolName = '"+rolName+"';"))
		{
			Permiso p = new Permiso((String)tupla[0], (String)tupla[1]);
			permisos.add(p);
		}
		
		return permisos;
    }
    
    public Permiso(String r, String p)
    {
		// Crea el objeto cargando sus valores de la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	Object[] tupla = miBD.Select("SELECT * FROM tPermiso WHERE rolName = '"
    			+ r + "' AND pantalla = '"+ p +"';").get(0);
    	
    	rolName = (String)tupla[0];
    	pantalla = (String)tupla[1];
    	acceso = (Boolean)tupla[2];
    	modificacion = (Boolean)tupla[3];
    }

    public Permiso(String r, String p, boolean a, boolean m)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	
    	rolName = r;
    	pantalla = p;
    	acceso = a;
    	modificacion = m;
    	
    	miBD.Insert("INSERT into tPermiso values('"+r+"','"+p+"',"+a+","+m+");");
    }
    
	public void setRolName(String value) 
	{
		// Actualiza el atributo en memoria y en la base de datos
		BD miBD = new BD(BD_SERVER,BD_NAME);
		
		miBD.Update("UPDATE tPermiso SET rolName = '"+value+"' WHERE rolName = '"+this.rolName+"' and pantalla = '"+this.pantalla+"';");
		
		rolName = value;
	}

	public String getRolName() 
	{
		return rolName;
	}
    
    public String getPantalla() 
    {
    	return pantalla; 
    }
    
    public void setPantalla(String value) 
    {
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
		
		miBD.Update("UPDATE tPermiso SET pantalla = '"+value+"' WHERE rolName = '"+this.rolName+"' and pantalla = '"+this.pantalla+"';");
		
		pantalla = value;
    }
    

    public boolean getAcceso() 
    { 
    	return acceso; 
    }
        
    public void setAcceso(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
		
		miBD.Update("UPDATE tPermiso SET acceso = "+value+" WHERE rolName = '"+this.rolName+"' and pantalla = '"+this.pantalla+"';");
		
		acceso = value;
    }

    
    public boolean getModificacion() 
    { 
    	return modificacion; 
    }
    
    public void setModificacion(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
		
		miBD.Update("UPDATE tPermiso SET modificacion = "+value+" WHERE rolName = '"+this.rolName+"' and pantalla = '"+this.pantalla+"';");
		
		modificacion = value;
    }

    @Override
	public boolean equals(Object o) 
	{
		boolean res = false;
		if (o instanceof Permiso) 
		{
			Permiso p = (Permiso) o;
			res = this.pantalla.equalsIgnoreCase(p.pantalla) 
				&& this.rolName.equalsIgnoreCase(p.rolName);
		}
		return res;
	}
	
	public int hashCode() 
	{
		return pantalla.toLowerCase().hashCode() 
				+ rolName.toLowerCase().hashCode();
	}

	public int compareTo(Permiso p) 
	{
		int res = this.rolName.compareToIgnoreCase(p.rolName);
		if (res == 0) res = this.pantalla.compareToIgnoreCase(p.pantalla);
		return res;
	}
}
