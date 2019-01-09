package Backend;

import java.util.ArrayList;
import java.util.List;

public class ProyectoLocal {
	
	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	
	private String localizacion;
	private ProyectoGeneral proyecto;
	private Usuario coordinador;
	private int codigo;
	
	 public static ProyectoLocal[] ListaProyectosLocales(ProyectoGeneral pg)
		{
			// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
			List<ProyectoLocal> lista = new ArrayList<ProyectoLocal>();
			BD miBD = new BD(BD_SERVER,BD_NAME);
			ProyectoLocal[] resultado;
			
			for(Object[] tupla: miBD.Select("SELECT * FROM tProyectoLocal WHERE proyecto = '"+pg.getNombre()+"';"))
			{
				ProyectoLocal p = new ProyectoLocal((Integer)tupla[3]);
				lista.add(p);
			}
			resultado = new ProyectoLocal[lista.size()];
			int i = 0;
			for (ProyectoLocal pr : lista) {
				resultado[i] = pr;
				i++;
			}
			return resultado;
		}
	    
	    public ProyectoLocal(int c) {
	    	// Crea el objeto cargando sus valores de la base de datos
	    	if ((Integer)c == null) {
	       		throw new Error("Introduzca un codigo de Proyecto Local.");
	    	}
	    	
	    	BD miBD = new BD(BD_SERVER,BD_NAME);
	    	List<Object[]> lista = miBD.Select("SELECT * FROM tProyectoLoc WHERE codigo = " + c + ";");
	    	
	    	if (lista.isEmpty()) {
	    		throw new Error("codigo de proyecto incorrecto");
	    	}else {
	    		Object[] tupla = lista.get(0);
	    		
	    	 	localizacion = (String)tupla[0] == null ? "" : (String)tupla[0];
	    	 	proyecto = new ProyectoGeneral((String)tupla[1]);
	    	 	coordinador = new Usuario((String)tupla[2]);
	    	 	codigo = (Integer)tupla[3];
	    	}
	    }
	    
	    public ProyectoLocal(ProyectoGeneral p, Usuario c) {
			// Crea el objeto y lo inserta en la base de datos
	    	BD miBD = new BD(BD_SERVER,BD_NAME);
	    	
	    	if (p==null|| c==null) {
	    		throw new Error("Rellene los campos obligatorios.");
	    	}
	    	if(!c.getRol().getRolName().equalsIgnoreCase("CoordinadorLocalH")) {
	    		throw new Error("El usuario debe ser un coordinador");
	    	}
	    	
	    	miBD.Insert("INSERT into tProyectoLoc values(null,'"+p.getNombre()+"','"+c.getUsuario()+"');");
	    		
	    		proyecto = p;
	    		coordinador = c;
	    		codigo = (Integer) miBD.Select("SELECT MAX(codigo) FROM tProyectoLoc;").get(0)[0];
				
		
	    	
	    }
	    
	    public void setLocalizacion(String value) {
	    	// Actualiza el atributo en memoria y en la base de datos
	    	BD miBD = new BD(BD_SERVER, BD_NAME);
	    	miBD.Update("UPDATE tProyectoLoc set localizacion = '" + value + "' WHERE codigo = '" + this.codigo + "';");
	    	localizacion = value;
	    }
	    
	    public String getLocalizacion() {
	    	return localizacion;
	    }
	    
	    public void setProyecto(ProyectoGeneral value) {
	    	BD miBD = new BD(BD_SERVER, BD_NAME);
	    	miBD.Update("UPDATE tProyectoLoc set proyecto = '" + value.getNombre() + "' WHERE codigo = '" + this.codigo + "';");
	    	proyecto = value;
	    }
	    
	    public ProyectoGeneral getProyecto() {
	    	return proyecto;
	    }
	    
	    public void setCoordinador(Usuario value) {
	    	if(!value.getRol().getRolName().equalsIgnoreCase("Coordinador")) {
	    		throw new Error("El usuario debe ser un coordinador");
	    	}
	    	BD miBD = new BD(BD_SERVER, BD_NAME);
	    	miBD.Update("UPDATE tProyectoLoc set coordinador= '" + value.getUsuario() + "' WHERE codigo = '" + this.codigo + "';");
	    	coordinador = value;
	    }
	    
	    public Usuario getCoordinador() {
	    	return coordinador;
	    }
	    
	    public int getCodigo() {
	    	return codigo;
	    }
	    
}
