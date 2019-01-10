package Backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Envio {
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	
	private String descripcion;
	private Date fecha;
	private Apadrinamiento apadrinamiento;
	private int codigo;
	
	public Envio(Apadrinamiento ap) {
		BD miBD = new BD(BD_SERVER,BD_NAME); 
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		miBD.Insert("Insert into tEnvio values(null,'" + formatoDelTexto.format(new Date()) + "'," + ap.getCodigo() + ");");
		
		descripcion = null;
		fecha = new Date();
		apadrinamiento = ap;
		codigo = (Integer)miBD.SelectEscalar("Select MAX(codigo) from tEnvio;");
	}
	
	public Envio(int c) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tEnvio WHERE codigo = "
    			+ c + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El envio no existe en la base de datos.");
    	} else {
    		Object[] tupla = lista.get(0);
    		descripcion = (String)tupla[0];
    		fecha = (Date)tupla[1];
    		apadrinamiento = new Apadrinamiento((Integer)tupla[2]);
    		codigo = (Integer)tupla[3];
    	}
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String des) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tEnvio set descripcion = '" + des + "' WHERE codigo = " + this.codigo + ";");
		this.descripcion = des;
	}

	public Date getFecha() {
		return fecha;
	}

	public Apadrinamiento getApadrinamiento() {
		return apadrinamiento;
	}

	public int getCodigo() {
		return codigo;
	}
}
