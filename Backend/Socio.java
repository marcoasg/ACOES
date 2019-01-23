package Backend;
import java.text.SimpleDateFormat;
import java.util.*;

public class Socio 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private int numSocio;
    private String agente;
    private String relacion;
    private String nombre;
    private String apellidos;
    private String estado;
    private String nif;
    private String direccion;
    private int codigoPostal;
    private String provincia;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;
    private boolean certificado;
    private String sector;
    private Date fechaAlta;
    private Date fechaBaja;
    private String observaciones;
    private Sede sede;

    
	public static Socio[] ListaSocios(Sede s)
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Socio> lista = new ArrayList<Socio>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Socio[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tSocio WHERE sede = '"+s.getLocalizacion()+"';"))
		{
			Socio r = new Socio( ((Integer)tupla[0]));
			lista.add(r);
		}
		resultado = new Socio[lista.size()];
		int i = 0;
		for (Socio u : lista) {
			resultado[i] = u;
			i++;
		}
		return resultado;
	}
    
	public static Socio[] ListaSocios()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Socio> lista = new ArrayList<Socio>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Socio[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tSocio;"))
		{
			Socio r = new Socio( ((Integer)tupla[0]));
			lista.add(r);
		}
		resultado = new Socio[lista.size()];
		int i = 0;
		for (Socio u : lista) {
			resultado[i] = u;
			i++;
		}
		return resultado;
	}
	
	public Socio(int n) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tSocio WHERE numSocio = "
    			+ n + ";");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El socio no existe en la base de datos.");
    	}else {
    		Object[] tupla = lista.get(0);
        	numSocio = (Integer)tupla[0];
        	agente = (String)tupla[1];
            relacion = (String)tupla[2];
            nombre = tupla[3] == null ? "" : (String)tupla[3];
            apellidos = tupla[4] == null ? "" : (String)tupla[4];
            estado = tupla[5] == null ? "" : (String)tupla[5];
            nif = tupla[6] == null ? "" : (String)tupla[6];
            direccion = (String)tupla[7] == null ? "" : (String)tupla[7];
            codigoPostal = tupla[8] == null ? -1 : (Integer)tupla[8];
            provincia = tupla[9] == null ? "" : (String)tupla[9];
            telefonoFijo = tupla[10] == null ? "" : (String)tupla[10];
            telefonoMovil = tupla[11] == null ? "" : (String)tupla[11];
            email = tupla[12] == null ? "" : (String)tupla[12];
            boolean esNull = tupla[13] == null ? true : false;
            if (esNull) certificado = false;
            if (!esNull) certificado = (Integer)tupla[13] == 1 ? true : false;
            sector = tupla[14] == null ? "" : (String)tupla[14];
            fechaAlta = tupla[15] == null ? null : (Date)tupla[15];
            fechaBaja = tupla[16] == null ? null : (Date)tupla[16];
            observaciones = tupla[17] == null ? "" : (String)tupla[17];
            sede = new Sede((String)tupla[18]);
    	}
	}
	

    
    public Socio(String ag,String sede)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME); 
    	miBD.Insert("INSERT INTO tSocio VALUES('" + ag + "', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,'"+sede+"')");
    		numSocio = (Integer) miBD.Select("SELECT MAX(numSocio) FROM tSocio;").get(0)[0];
   	
    }

    public int getNumSocio() 
    { 
    	return numSocio; 
    }

    public void setNumSocio(int value) 
    { 
    	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set numSocio = " + value + " WHERE numSocio = " + numSocio + ";");
    	numSocio = value;
    	

    }

    public void desactivaSocio() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String fecha = formatoDelTexto.format(date);
    	miBD.Update("UPDATE tSocio set fechaBaja = '" + fecha + "' WHERE numSocio = " + this.numSocio + ";");
    	fechaBaja = date;
    }
    public String getAgente() 
    { 
    	return agente; 
    }
        
    public void setAgente (String value)
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set agente = '" + value + "' WHERE numSocio = " + numSocio + ";");
    	agente = value;
    }

    public String getRelacion()
    {
        return relacion;
    }
    
    public void setRelacion(String value)
    {
       	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set relacion = '" + value + "' WHERE numSocio = " + numSocio + ";");
    	relacion = value;    
    }


	public String toString()
	{
		return Integer.toString(numSocio);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set nombre = '" + nombre + "' WHERE numSocio = " + this.numSocio + ";");
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set apellidos = '" + apellidos + "' WHERE numSocio = " + this.numSocio + ";");
		this.apellidos = apellidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set estado = '" + estado + "' WHERE numSocio = " + this.numSocio + ";");
		this.estado = estado;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set nif = '" + nif + "' WHERE numSocio = " + this.numSocio + ";");
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set direccion = '" + direccion + "' WHERE numSocio = " + this.numSocio + ";");
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal == 0 ? -1 : codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set codigoPostal = " + codigoPostal + " WHERE numSocio = " + this.numSocio + ";");
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set provincia = '" + provincia + "' WHERE numSocio = " + this.numSocio + ";");
		this.provincia = provincia;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set telefonoFijo = '" + telefonoFijo + "' WHERE numSocio = " + this.numSocio + ";");
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set telefonoMovil = '" + telefonoMovil + "' WHERE numSocio = " + this.numSocio + ";");
		this.telefonoMovil = telefonoMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set email = '" + email + "' WHERE numSocio = " + this.numSocio + ";");
		this.email = email;
	}

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	int cert = certificado ? 1 : 0;
    	miBD.Update("UPDATE tSocio set certificado = " + cert + " WHERE numSocio = " + this.numSocio + ";");
		this.certificado = certificado;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set sector = '" + sector + "' WHERE numSocio = " + this.numSocio + ";");
		this.sector = sector;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	miBD.Update("UPDATE tSocio set fechaAlta = '" + formatoDelTexto.format(fechaAlta) + "' WHERE numSocio = " + this.numSocio + ";");
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set observaciones = '" + observaciones + "' WHERE numSocio = " + this.numSocio + ";");
		this.observaciones = observaciones;
	}
	
	public Niño[] listaApadrinados() {
		List<Niño> lista = new ArrayList<Niño>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Niño[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT niño FROM tApadrinamiento WHERE socio = "+ this.numSocio+";"))
		{
			Niño r = new Niño( ((Integer)tupla[0]));
			lista.add(r);
		}
		resultado = new Niño[lista.size()];
		int i = 0;
		for (Niño n : lista) {
			resultado[i] = n;
			i++;
		}
		return resultado;
		
		
		
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tSocio set sede = '" + sede + "' WHERE numSocio = " + this.numSocio + ";");
		this.sede = sede;
	}
	
}
