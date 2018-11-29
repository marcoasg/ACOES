package Backend;
import java.util.*;

public class Usuario 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String usuario;
    private String password;
    private Rol rol;
    private int numSocio;
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
    private String relacion;
    private boolean certificado;
    private String sector;
    private Date fechaAlta;
    private Date fechaBaja;
    private String observaciones;

	public static Usuario[] ListaUsuarios()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Usuario> lista = new ArrayList<Usuario>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Usuario[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tUsuario;"))
		{
			Usuario r = new Usuario( (String)tupla[0], ((String)tupla[1]).toCharArray());
			lista.add(r);
		}
		resultado = new Usuario[lista.size()];
		int i = 0;
		for (Usuario u : lista) {
			resultado[i] = u;
			i++;
		}
		return resultado;
	}
	
    public Usuario(String n, char[] p)
    {
		// Crea el objeto cargando sus valores de la base de datos
		// Si la password almacenada no se corresponde con la suministrada se elevará una excepción
    	if (n.length() == 0) {
    		throw new Error("Introduzca un usuario.");
    	}
    	if (p.length == 0) {
    		throw new Error ("Introduzca su contraseña");
    	}
    	
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tUsuario WHERE usuario = '"
    			+ n + "' AND password = '" + new String(p) +"';");
    	
    	if (lista.isEmpty()) {
    		throw new Error("Usuario o contraseña incorrectos.");
    	}else {
    		Object[] tupla = lista.get(0);
        	usuario = (String)tupla[0];
        	password = (String)tupla[1];
        	numSocio = (Integer)tupla[2];
            rol = new Rol((String)tupla[3]);
            nombre = (String)tupla[4] == null ? "" : (String)tupla[4];
            apellidos = (String)tupla[5] == null ? "" : (String)tupla[5];
            estado = (String)tupla[6] == null ? "" : (String)tupla[6];
            nif = (String)tupla[7] == null ? "" : (String)tupla[7];
            direccion = (String)tupla[8] == null ? "" : (String)tupla[8];
            codigoPostal = (Integer)tupla[9] == null ? -1 : (Integer)tupla[9];
            provincia = (String)tupla[10] == null ? "" : (String)tupla[10];
            telefonoFijo = (String)tupla[11] == null ? "" : (String)tupla[11];
            telefonoMovil = (String)tupla[12] == null ? "" : (String)tupla[12];
            email = (String)tupla[13] == null ? "" : (String)tupla[13];
            relacion = (String)tupla[14] == null ? "" : (String)tupla[14];
            certificado = (Integer)tupla[15] == 1 ? true : false;
            sector = (String)tupla[16] == null ? "" : (String)tupla[16];
            fechaAlta = (Date)tupla[17] == null ? new Date() : (Date)tupla[17];
            fechaBaja = (Date)tupla[18] == null ? new Date() : (Date)tupla[18];
            observaciones = (String)tupla[19] == null ? "" : (String)tupla[19];
    	}
        
    }
    
    public Usuario(String n, String p, Rol r)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	
    	if (miBD.Select("SELECT * FROM tUsuario WHERE usuario = '"+n+"';").isEmpty()) {
			miBD.Insert("INSERT into tUsuario values('"+n+"','"+new String(p)+"','"+r.getRolName()+"');");
    		
    		usuario = n;
			password = p;
			rol = r;
		} else {
			throw new Error("El usuario "+n+" ya existe en el sistema.");
		}
    	
    	
    }

    public String getNombre() 
    { 
    	return nombre; 
    }

    public void setNombre(String value) 
    { 
    	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set usuario = '" + value + "' WHERE usuario = '" + usuario + "';");
    	usuario = value;
    	

    }

    public void borraUsuario() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Delete("DELETE FROM tUsuario WHERE usuario = '" + usuario + "' and password = '" + new String(password) +  "';");
    	usuario = null;
    	password = null;
    	rol = null;
    	
    }
    public String getPassword() 
    { 
    	return password; 
    }
        
    public void setPassword (String value)
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set password = '" + new String(value) + "' WHERE usuario = '" + usuario + "';");
    	password = value;
    }

    public Rol getRol()
    {
        return rol;
    }
    
    public void setRol()
    {
    	throw new Error("Error: Un usuario no puede cambiar el rol de si mismo.");     
    }

    public void ModiRol(Usuario u, Rol r)
    {
		// Si el objeto actual es administrador
		// Actualiza el atributo rol de u en memoria y en la base de datos
    	if (this.rol.getRolName() == "Admin" ) {
        	BD miBD = new BD(BD_SERVER, BD_NAME);
        	miBD.Update("UPDATE tUsuario set rol = '" + r + "' WHERE usuario = '" + usuario + "';");
    		u.rol = r;
    		
    	} else {
    		throw new Error("Error: Necesitas ser administrador para cambiar los roles de otros usuarios.");
    	}

    }
	
	public String toString()
	{
	
		return usuario + "\t" + new String (password) + "\t" + rol.getRolName();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getNumSocio() {
		return numSocio == 0 ? -1 : numSocio;
	}

	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal == 0 ? -1 : codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
