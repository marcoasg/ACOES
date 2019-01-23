package Backend;

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	
	private String localizacion;
	
	public Sede[] listaSedes(){
		List<Sede> lista = new ArrayList<Sede>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Sede[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tSede;"))
		{
			Sede s = new Sede( (String)tupla[0]);
			lista.add(s);
		}
		resultado = new Sede[lista.size()];
		int i = 0;
		for (Sede u : lista) {
			resultado[i] = u;
			i++;
		}
		return resultado;
	}
	
	
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
