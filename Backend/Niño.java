package Backend;
import java.text.SimpleDateFormat;
import java.util.*;

public class Niño 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String nombre;
    private Socio padrino;
    private int codigo;
    private String apellidos;
    private String estado;
    private String beca;
    private String sexo;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String curso;
    private String coloniaProcedencia;
    private String coloniaResidencia;
    private String observaciones;
    
    
	public static Niño[] ListaNiños()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Niño> lista = new ArrayList<Niño>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Niño[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tNiño;"))
		{
			Niño r = new Niño( ((Integer)tupla[2]));
			lista.add(r);
		}
		resultado = new Niño[lista.size()];
		int i = 0;
		for (Niño u : lista) {
			resultado[i] = u;
			i++;
		}
		return resultado;
	}
	
	public Niño(int c) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tNiño WHERE codigo = "
    			+ c + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El niño no existe en la base de datos.");
    	}else {
    		Object[] tupla = lista.get(0);
        	nombre = (String)tupla[0];
        	padrino = new Socio((Integer)tupla[1]);
            codigo = (int)tupla[2];
            apellidos = tupla[3] == null ? "" : (String)tupla[3];
            estado = tupla[4] == null ? "" : (String)tupla[4];
            beca = tupla[5] == null ? "" : (String)tupla[5];
            sexo = tupla[6] == null ? "" : (String)tupla[6];
            fechaNacimiento = tupla[7] == null ? null : (Date)tupla[7];
            fechaEntrada = tupla[8] == null ? null : (Date)tupla[8];
            fechaSalida = tupla[9] == null ? null : (Date)tupla[9];
            curso = tupla[10] == null ? "" : (String)tupla[10];
            coloniaProcedencia = tupla[11] == null ? "" : (String)tupla[11];
            coloniaResidencia = tupla[12] == null ? "" : (String)tupla[12];
            observaciones = tupla[13] == null ? "" : (String)tupla[13];
    	}
	}
	

    
    public Niño()
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME); 
    	miBD.Insert("INSERT INTO tNiño VALUES(null, null, null, null, null, null, null, null, null, null, null, null, null)");
    	codigo = (Integer) miBD.Select("SELECT MAX(codigo) FROM tNiño;").get(0)[0];
   	
    }

    public String getNombre() 
    { 
    	return nombre; 
    }

    public void setNombre(String value) 
    { 
    	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set nombre = '" + value + "' WHERE codigo = " + codigo + ";");
    	nombre = value;
    	

    }

    public void desactivaNiño() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String fecha = formatoDelTexto.format(date);
    	miBD.Update("UPDATE tNiño set fechaSalida = '" + fecha + "' WHERE codigo = " + this.codigo + ";");
    	fechaSalida = date;
    }
    public Socio getPadrino() 
    { 
    	return padrino; 
    }
        
    public void setPadrino (Socio value)
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set padrino = " + value.getNumSocio() + " WHERE codigo = " + codigo + ";");
    	padrino = value;
    }

    public int getCodigo() {
    	return codigo;
    }
    
    
    public String getApellidos()
    {
        return apellidos;
    }
    
    public void setApellidos(String value)
    {
       	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set apellidos = '" + value + "' WHERE codigo = " + codigo + ";");
    	apellidos = value;    
    }


	public String toString()
	{
		return Integer.toString(codigo);
	}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set estado = '" + estado + "' WHERE codigo = " + this.codigo + ";");
		this.estado = estado;
	}

	public String getBeca() {
		return beca;
	}

	public void setBeca(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set beca = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.beca = beca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set sexo = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.sexo = value;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Update("UPDATE tNiño set fechaNacimiento = '" + formatoDelTexto.format(value) + "' WHERE codigo = " + this.codigo + ";");
		this.fechaNacimiento = value;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Update("UPDATE tNiño set fechaEntrada = '" + formatoDelTexto.format(value) + "' WHERE codigo = " + this.codigo + ";");
		this.fechaEntrada = value;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Update("UPDATE tNiño set fechaSalida = '" + formatoDelTexto.format(value) + "' WHERE codigo = " + this.codigo + ";");
		this.fechaSalida = value;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set curso = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.curso = value;
	}

	public String getColoniaProcedencia() {
		return coloniaProcedencia;
	}

	public void setColoniaProcedencia(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set coloniaProcedencia = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.coloniaProcedencia = value;
	}

	public String getColoniaResidencia() {
		return coloniaResidencia;
	}

	public void setColoniaResidencia(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set coloniaResidencia = " + value + " WHERE codigo = " + this.codigo + ";");
		this.coloniaResidencia = value;
	}


	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNiño set observaciones = '" + observaciones + "' WHERE codigo = " + this.codigo + ";");
		this.observaciones = observaciones;
	}
}
