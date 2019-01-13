package Backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apadrinamiento {

    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	private Socio socio;
	private Ni�o ni�o;
	private Date fechaAlta;
	private Date fechaBaja;
	private int codigo;
	private int cuota;
	
	public static Apadrinamiento[] ListaApadrinamientos()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Apadrinamiento> lista = new ArrayList<Apadrinamiento>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Apadrinamiento[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tApadrinamiento;"))
		{
			Apadrinamiento a = new Apadrinamiento( ((Integer)tupla[4]));
			lista.add(a);
		}
		resultado = new Apadrinamiento[lista.size()];
		int i = 0;
		for (Apadrinamiento a : lista) {
			resultado[i] = a;
			i++;
		}
		return resultado;
	}

	
	public Apadrinamiento(Socio s, Ni�o n, int cuota) {
		//inserta el apadrinamiento en la BD
		Date fecha = new Date();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Insert("Insert into tApadrinamiento values("+s.getNumSocio()+","+n.getCodigo()+",'"+ formatoDelTexto.format(fecha) +"',null, "+cuota+";);");
		socio = s;
		ni�o = n;
		fechaAlta = fecha;
		fechaBaja = null;
		codigo = (Integer)miBD.SelectEscalar("Select MAX(codigo) from tApadrinamiento;");
		this.cuota = cuota;
	}
	
	public Apadrinamiento(int cod) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tApadrinamiento WHERE codigo = "
    			+ cod + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El apadrinamiento no existe en la base de datos.");
    	}else {
    		Object[] tupla = lista.get(0);
    		socio = new Socio((Integer) tupla[0]);
    		ni�o = new Ni�o((Integer) tupla[1]);
    		fechaAlta = tupla[2] == null ? null : (Date)tupla[2];
    		fechaBaja = tupla[3] == null ? null : (Date)tupla[3];
    		codigo = cod;
    		cuota = (Integer) tupla[5];
    	}
	}
	
	public Apadrinamiento(Socio s, Ni�o n) {

		BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tApadrinamiento WHERE socio = "
    			+ s.getNumSocio() + " and ni�o = "+n.getCodigo()+";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El apadrinamiento no existe en la base de datos.");
    	}else {
    		Object[] tupla = lista.get(0);
    		socio = new Socio((Integer) tupla[0]);
    		ni�o = new Ni�o((Integer) tupla[1]);
    		fechaAlta = tupla[2] == null ? null : (Date)tupla[2];
    		fechaBaja = tupla[3] == null ? null : (Date)tupla[3];
    		codigo = (Integer)tupla[4];
    		cuota = (Integer) tupla[5];
    	}
	
	}
	
	
	public void darDeBajaApadrinamiento() {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String fecha = formatoDelTexto.format(date);
    	miBD.Update("UPDATE tApadrinamiento set fechaBaja = '" + fecha + "' WHERE codigo = " + this.codigo + ";");
    	fechaBaja = date;
	}


	public Socio getSocio() {
		return socio;
	}


	public Ni�o getNi�o() {
		return ni�o;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public Date getFechaBaja() {
		return fechaBaja;
	}


	public int getCodigo() {
		return codigo;
	}
	
	public int getCuota() {
		return cuota;
	}
}
