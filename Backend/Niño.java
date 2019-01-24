package Backend;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ni�o 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String nombre;
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
    
    
	public static Ni�o[] ListaNi�os()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Ni�o> lista = new ArrayList<Ni�o>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Ni�o[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tNi�o;"))
		{
			Ni�o r = new Ni�o( ((Integer)tupla[1]));
			lista.add(r);
		}
		resultado = new Ni�o[lista.size()];
		int i = 0;
		for (Ni�o u : lista) {
			resultado[i] = u;
			i++;
		}
		return resultado;
	}
	
	public Ni�o(int c) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tNi�o WHERE codigo = "
    			+ c + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El ni�o no existe en la base de datos.");
    	}else {
    		Object[] tupla = lista.get(0);
        	nombre = (String)tupla[0];
            codigo = (Integer)tupla[1];
            apellidos = tupla[2] == null ? "" : (String)tupla[2];
            estado = tupla[3] == null ? "" : (String)tupla[3];
            beca = tupla[4] == null ? "" : (String)tupla[4];
            sexo = tupla[5] == null ? "" : (String)tupla[5];
            fechaNacimiento = tupla[6] == null ? null : (Date)tupla[6];
            fechaEntrada = tupla[7] == null ? null : (Date)tupla[7];
            fechaSalida = tupla[8] == null ? null : (Date)tupla[8];
            curso = tupla[9] == null ? "" : (String)tupla[9];
            coloniaProcedencia = tupla[10] == null ? "" : (String)tupla[10];
            coloniaResidencia = tupla[11] == null ? "" : (String)tupla[11];
            observaciones = tupla[12] == null ? "" : (String)tupla[12];
    	}
	}
	

    
    public Ni�o()
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME); 
    	miBD.Insert("INSERT INTO tNi�o VALUES(null, null, null, null, null, null, null, null, null, null, null, null)");
    	codigo = (Integer) miBD.Select("SELECT MAX(codigo) FROM tNi�o;").get(0)[0];
   	
    }

    public String getNombre() 
    { 
    	return nombre; 
    }

    public void setNombre(String value) 
    { 
    	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set nombre = '" + value + "' WHERE codigo = " + codigo + ";");
    	nombre = value;
    	

    }

    public void desactivaNi�o() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String fecha = formatoDelTexto.format(date);
    	miBD.Update("UPDATE tNi�o set fechaSalida = '" + fecha + "' WHERE codigo = " + this.codigo + ";");
    	fechaSalida = date;
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
    	miBD.Update("UPDATE tNi�o set apellidos = '" + value + "' WHERE codigo = " + codigo + ";");
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
    	miBD.Update("UPDATE tNi�o set estado = '" + estado + "' WHERE codigo = " + this.codigo + ";");
		this.estado = estado;
	}

	public String getBeca() {
		return beca;
	}

	public void setBeca(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set beca = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.beca = value;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set sexo = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.sexo = value;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	String strFecha = value == null ? "" : formatoDelTexto.format(value);
    	if (!strFecha.equals("")) {
			miBD.Update(
					"UPDATE tNi�o set fechaNacimiento = '" + strFecha + "' WHERE codigo = " + this.codigo + ";");
		} else {
			miBD.Update(
					"UPDATE tNi�o set fechaNacimiento = null WHERE codigo = " + this.codigo + ";");
		}
		this.fechaNacimiento = value;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	String strFecha = value == null ? "" : formatoDelTexto.format(value);
    	if (!strFecha.equals("")) {
			miBD.Update("UPDATE tNi�o set fechaEntrada = '" + strFecha + "' WHERE codigo = " + this.codigo + ";");
		}else {
			miBD.Update("UPDATE tNi�o set fechaEntrada = null WHERE codigo = " + this.codigo + ";");

		}
		this.fechaEntrada = value;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date value) {
		BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	String strFecha = value == null ? "" : formatoDelTexto.format(value);
    	if (!strFecha.equals("")) {
			miBD.Update("UPDATE tNi�o set fechaSalida = '" + strFecha + "' WHERE codigo = " + this.codigo + ";");
		} else {
			miBD.Update("UPDATE tNi�o set fechaSalida = null WHERE codigo = " + this.codigo + ";");

		}
		this.fechaSalida = value;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set curso = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.curso = value;
	}

	public String getColoniaProcedencia() {
		return coloniaProcedencia;
	}

	public void setColoniaProcedencia(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set coloniaProcedencia = '" + value + "' WHERE codigo = " + this.codigo + ";");
		this.coloniaProcedencia = value;
	}

	public String getColoniaResidencia() {
		return coloniaResidencia;
	}

	public void setColoniaResidencia(String value) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set coloniaResidencia = " + value + " WHERE codigo = " + this.codigo + ";");
		this.coloniaResidencia = value;
	}


	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tNi�o set observaciones = '" + observaciones + "' WHERE codigo = " + this.codigo + ";");
		this.observaciones = observaciones;
	}
}
