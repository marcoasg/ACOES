package Backend;

import java.text.SimpleDateFormat;
import java.util.*;

public class Gasto {
	
	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	
	private float cantidad;
	private String beneficiario;
	private ProyectoLocal proyecto;
	private Date fecha;
	private int codigo;
	
	public static Gasto[] ListaGastos(ProyectoLocal p, Date fi, Date ff){
		List<Gasto> lista = new ArrayList<Gasto>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Gasto[] resultado;
		
		for(Object[] tupla : miBD.Select("SELECT * FROM tGasto WHERE proyecto = "+p+";")) {
			if((fi.compareTo((Date)tupla[3])<=0)&&(ff.compareTo((Date)tupla[3])>=0)){
				lista.add(new Gasto((Integer)tupla[4]));
			}
		}
		resultado = new Gasto[lista.size()];
		int i = 0;
		for(Gasto g : lista) {
			resultado[i] = g;
			i++;
		}
		return resultado;
		
	}
	
	public Gasto(int id) {
		BD miBD = new BD(BD_SERVER,BD_NAME); 
		Object[] tupla = miBD.Select("SELECT * FROM tGasto WHERE codigo =" + id +";").get(0);
		
		if(tupla == null) {
			throw new Error("El gasto con codigo "+id+" no esta en la base de datos");
		}
		cantidad = (int)tupla[0];
		beneficiario= (String)tupla[1];
		proyecto = new ProyectoLocal((int)tupla[2]);
		fecha = (Date)tupla[3];
		codigo = (Integer)tupla[4];
	}
	
	public Gasto(float cant, String beneficiario, ProyectoLocal proyecto, Date fecha) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		miBD.Insert("Insert into tGasto values("+ cant +", '" +beneficiario+"', " +proyecto.getCodigo()+", "+formatoDelTexto.format(new Date())+");" );
		this.cantidad=cant;
		this.beneficiario = beneficiario;
		this.proyecto = proyecto;
		this.fecha = fecha;
		this.codigo = (Integer)miBD.SelectEscalar("Select MAX(codigo) from tGasto;");
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Update("UPDATE tGasto SET cantidad = " +cantidad+" WHERE codigo = " +this.codigo+";");
		this.cantidad = cantidad;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Update("UPDATE tGasto SET beneficiario = '" +beneficiario+"' WHERE codigo = " +this.codigo+";");
		this.beneficiario = beneficiario;
	}

	public ProyectoLocal getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoLocal proyecto) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Update("UPDATE tGasto SET proyecto = " +proyecto.getCodigo()+" WHERE codigo = " +this.codigo+";");
		this.proyecto = proyecto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		BD miBD = new BD(BD_SERVER,BD_NAME);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		miBD.Update("UPDATE tGasto SET fecha = " +formatoDelTexto.format(fecha)+" WHERE codigo = " +this.codigo+";");
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}
	
}