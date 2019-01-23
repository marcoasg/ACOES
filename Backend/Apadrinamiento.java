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
	private int donacion;
	private int cuotaMensual;
	
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

	
	public Apadrinamiento(Socio s, Ni�o n, int donacion) {
		//inserta el apadrinamiento en la BD
		BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista2 = miBD.Select("SELECT * FROM tEstancia WHERE ni�o = "
    			+ n.getCodigo() + " and fechaBaja = null;");
		Date fecha = new Date();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		miBD.Insert("Insert into tApadrinamiento values("+s.getNumSocio()+","+n.getCodigo()+",'"+ formatoDelTexto.format(fecha) +"',null,"+donacion+",null);");
		socio = s;
		ni�o = n;
		fechaAlta = fecha;
		fechaBaja = null;
		codigo = (Integer)miBD.SelectEscalar("Select MAX(codigo) from tApadrinamiento;");
		this.donacion = donacion;
		Ingreso i = new Ingreso(donacion,socio,new ProyectoLocal((Integer)lista2.get(0)[1]),new Date());
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
    		donacion = (Integer) tupla[5];
    	}
	}
	
	public Apadrinamiento(Socio s, Ni�o n) {

		BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tApadrinamiento WHERE socio = "
    			+ s.getNumSocio() + " and ni�o = " + n.getCodigo() + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El apadrinamiento no existe en la base de datos.");
    	}else {
    		
    		Object[] tupla = lista.get(0);
    		socio = new Socio((Integer) tupla[0]);
    		ni�o = new Ni�o((Integer) tupla[1]);
    		fechaAlta = tupla[2] == null ? null : (Date)tupla[2];
    		fechaBaja = tupla[3] == null ? null : (Date)tupla[3];
    		codigo = (Integer)tupla[4];
    		donacion = (Integer) tupla[5];
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
	
	public int getCuotaMensual() {
		return cuotaMensual;
	}
	public void setCuotaMensual(int x) {
		if (x < 0) throw new Error("La cuota debe ser positiva.");
		BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tApadrinamiento set cuota = " + x + " WHERE codigo = " + this.codigo + ";");
    	cuotaMensual = x;
	}
	public void donar(int x) {
		if (x < 0) throw new Error("La donaci�n debe ser positiva.");
		BD miBD = new BD(BD_SERVER,BD_NAME);
		int total = x+donacion;
    	miBD.Update("UPDATE tApadrinamiento set donacion = " + total + " WHERE codigo = " + this.codigo + ";");
    	donacion += x;
	}
}
