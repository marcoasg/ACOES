package Backend;

import java.util.ArrayList;
import java.util.List;

public class ProyectoGeneral {

	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String nombre;
    private String descripcion;
    private Usuario coordinador;
    
    public static ProyectoGeneral[] ListaProyectosGenerales()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<ProyectoGeneral> lista = new ArrayList<ProyectoGeneral>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		ProyectoGeneral[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tProyectoGen;"))
		{
			ProyectoGeneral p = new ProyectoGeneral( (String)tupla[0]);
			lista.add(p);
		}
		resultado = new ProyectoGeneral[lista.size()];
		int i = 0;
		for (ProyectoGeneral pr : lista) {
			resultado[i] = pr;
			i++;
		}
		return resultado;
	}
    
    public ProyectoGeneral(String n) {
    	// Crea el objeto cargando sus valores de la base de datos
    	if (n.length() == 0) {
       		throw new Error("Introduzca un Proyecto General.");
    	}
    	
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tProyectoGen WHERE nombre = '"
    			+ n + "';");
    	
    	if (lista.isEmpty()) {
    		throw new Error("nombre de proyecto incorrecto");
    	}else {
    		Object[] tupla = lista.get(0);
    		
    	 	nombre = (String)tupla[0];
    	 	descripcion = (String)tupla[1] == null ? "" : (String)tupla[1];
    	 	coordinador = new Usuario((String)tupla[2]);
    	}
    }
    
    public ProyectoGeneral(String n, Usuario c) {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	
    	if (n.length() <= 0 || c==null) {
    		throw new Error("Rellene los campos obligatorios.");
    	}
    	if(!c.getRol().getRolName().equalsIgnoreCase("CoordinadorProyecto")) {
    		throw new Error("El usuario debe ser un coordinador");
    	}
    	
    	if (miBD.Select("SELECT * FROM tProyectoGen WHERE nombre = '"+n+"';").isEmpty()) {
			miBD.Insert("INSERT into tProyectoGen values('" + n +"', null,'"+c.getUsuario()+"');");
    		
    		nombre = n;
			coordinador = c;
			
		} else {
			throw new Error("El proyecto "+n+" ya existe en el sistema.");
		}
    	
    }
    
    public void setNombre(String value) {
    	// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tProyectoGen set nombre = '" + value + "' WHERE nombre = '" + this.nombre + "';");
    	nombre = value;
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setDescripcion(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tProyectoGen set descripcion = '" + value + "' WHERE nombre = '" + this.nombre + "';");
    	descripcion = value;
    }
    
    public String getDescripcion() {
    	return descripcion;
    }
    
    public void setCoordinador(Usuario value) {
    	if(!value.getRol().getRolName().equalsIgnoreCase("Coordinador")) {
    		throw new Error("El usuario debe ser un coordinador");
    	}
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tProyectoGen set coordinador= '" + value.getUsuario() + "' WHERE nombre = '" + this.nombre + "';");
    	coordinador = value;
    }
    
    public Usuario getCoordinador() {
    	return coordinador;
    }
    
}
