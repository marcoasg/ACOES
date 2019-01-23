package Backend;

import java.util.List;

public class Sede {
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	
	private String localizacion;
	
	public Sede(String loc) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tSede WHERE localizacion = '"
    			+ loc + "';");
    	
    	if (lista.isEmpty()) {
    		throw new Error("No existe una sede en "+ loc+".");
    	}else {
    		localizacion = loc;
    	}
	}

	public String getLocalizacion() {
		return localizacion;
	}
}
