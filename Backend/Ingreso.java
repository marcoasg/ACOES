package Backend;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ingreso {
	
	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	
	private float cantidad;
	private Socio socio;
	private ProyectoLocal proyecto;
	private Date fecha;
	private int codigo;
	
	public static Ingreso[] ListaIngresos(ProyectoLocal p, Date fi, Date ff){
		List<Ingreso> lista = new ArrayList<Ingreso>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Ingreso[] resultado;
		
		for(Object[] tupla : miBD.Select("SELECT * FROM tIngreso WHERE proyecto = "+p+";")) {
			if((fi.compareTo((Date)tupla[3])<=0)&&(ff.compareTo((Date)tupla[3])>=0)){
				lista.add(new Ingreso((Integer)tupla[4]));
			}
		}
		resultado = new Ingreso[lista.size()];
		int i = 0;
		for(Ingreso in : lista) {
			resultado[i] = in;
			i++;
		}
		return resultado;
		
	}
	public Ingreso(int id) {
		BD miBD = new BD(BD_SERVER,BD_NAME); 
		Object[] tupla = miBD.Select("SELECT * FROM tIngreso WHERE codigo = "+ id + ";").get(0);
		
		if(tupla == null) {
			throw new Error("El ingreso con codigo "+id+" no esta en la base de datos");
		}
		cantidad = (int)tupla[0];
		socio = new Socio((int)tupla[1]);
		proyecto = new ProyectoLocal((int)tupla[2]);
		fecha = (Date)tupla[3];
		codigo = (Integer)tupla[4];
	}
	
	public Ingreso(float cant, Socio socio, ProyectoLocal proyecto, Date fecha) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		miBD.Insert("Insert into tIngreso values("+ cant +", " +socio.getNumSocio()+", " +proyecto.getCodigo()+", "+formatoDelTexto.format(new Date())+");" );
		this.cantidad=cant;
		this.socio = socio;
		this.proyecto = proyecto;
		this.fecha = fecha;
		this.codigo = (Integer)miBD.SelectEscalar("Select MAX(codigo) from tIngreso;");
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Update("UPDATE tIngreso SET cantidad = " +cantidad+" WHERE codigo = " +this.codigo+";");
		this.cantidad = cantidad;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Update("UPDATE tIngreso SET socio = " +socio.getNumSocio()+" WHERE codigo = " +this.codigo+";");
		this.socio = socio;
	}

	public ProyectoLocal getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoLocal proyecto) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Update("UPDATE tIngreso SET proyecto = " +proyecto.getCodigo()+" WHERE codigo = " +this.codigo+";");
		this.proyecto = proyecto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		miBD.Update("UPDATE tIngreso SET fecha = " +formatoDelTexto.format(fecha)+" WHERE codigo = " +this.codigo+";");
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}
	
}
