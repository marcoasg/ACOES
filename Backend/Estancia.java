package Backend;

import java.text.SimpleDateFormat;
import java.util.*;

import Backend.Error;

public class Estancia {
	
	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
	private Niño niño;
	private ProyectoLocal proyecto;
	private Date fechaAlta;
	private Date fechaBaja;
	private int codigo;
	
	public static Estancia[] listaEstancias (ProyectoLocal pl) {
		List<Estancia> lista = new ArrayList<Estancia>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Estancia[] res;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tEstancia WHERE proyecto = "+pl.getCodigo()+";"))
		{
			Estancia e = new Estancia((Integer)tupla[4]);
			lista.add(e);
		}
		res = new Estancia[lista.size()];
		int i = 0;
		for (Estancia e : lista) {
			res[i] = e;
			i++;
		}
		return res;
		
		
	}
	
	public Estancia(int c) {
    	// Crea el objeto cargando sus valores de la base de datos
    	if ((Integer)c == null) {
       		throw new Error("Introduzca un codigo de estancia.");
    	}
    	
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tEstancia WHERE codigo = " + c + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("codigo de estancia incorrecto");
    	}else {
    		Object[] tupla = lista.get(0);
    		
    	 	niño  = new Niño((Integer)tupla[0]);
    	 	proyecto = new ProyectoLocal((Integer)tupla[1]);
    	 	fechaAlta = (Date)tupla[2] == null ? null : (Date)tupla[2];
    	 	fechaBaja = (Date)tupla[3] == null ? null : (Date)tupla[3];
    	 	codigo = (Integer)tupla[4];
    	}
    }
	
	public Estancia(Niño n, ProyectoLocal pl, Date f) {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	
    	if ((n==null)|| pl==null||f==null) {
    		throw new Error("Rellene los campos obligatorios.");
    	}
    	
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Insert("INSERT into tEstancia values("+n.getCodigo()+","+pl.getCodigo()+",'" + formatoDelTexto.format(f) + "',null);");
    		
    		niño = n;
    		proyecto = pl;
    		fechaAlta = f;
    		codigo = (Integer) miBD.Select("SELECT MAX(codigo) FROM tEstancia;").get(0)[0];	
    }

	public Niño getNiño() {
		return niño;
	}

	public void setNiño(Niño value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tEstancia set niño = " + value.getCodigo() + " WHERE codigo = " + this.codigo + ";");
		this.niño = value;
	}

	public ProyectoLocal getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoLocal value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tEstancia set proyecto = " + value.getCodigo() + " WHERE codigo = " + this.codigo + ";");
		this.proyecto = value;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Update("UPDATE tEstancia set fechaAlta = '" + formatoDelTexto.format(value) + "' WHERE codigo = " + this.codigo + ";");
		this.fechaAlta = value;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Update("UPDATE tEstancia set fechaBaja = '" + formatoDelTexto.format(value) + "' WHERE codigo = " + this.codigo + ";");
		this.fechaBaja = value;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public boolean estanciaTerminada() {
		return fechaBaja != null;
	}


	
	
	
	
	
}
