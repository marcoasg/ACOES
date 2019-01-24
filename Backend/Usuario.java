package Backend;
import java.text.SimpleDateFormat;
import java.util.*;

public class Usuario 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
    
    private String usuario;
    private String password;
    private Rol rol;
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
    
	public static Usuario[] ListaUsuarios(Sede s)
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Usuario> lista = new ArrayList<Usuario>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Usuario[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tUsuario WHERE sede = '"+s.getLocalizacion()+"';"))
		{
			Usuario r = new Usuario( (String)tupla[0]);
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

	public static Usuario[] ListaUsuarios()
	{
		// Retorna una lista con todos los objetos de la clase almacenados en la base de datos
		List<Usuario> lista = new ArrayList<Usuario>();
		BD miBD = new BD(BD_SERVER,BD_NAME);
		Usuario[] resultado;
		
		for(Object[] tupla: miBD.Select("SELECT * FROM tUsuario;"))
		{
			Usuario r = new Usuario( (String)tupla[0]);
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
	
	public Usuario(String n) {
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	List<Object[]> lista = miBD.Select("SELECT * FROM tUsuario WHERE usuario = '"
    			+ n + "';");
    	
    	if (lista.isEmpty()) {
    		throw new Error("El usuario no existe en la base de datos.");
    	}else {
    		Object[] tupla = lista.get(0);
    		
        	List<Object[]> lista2 = miBD.Select("SELECT * FROM tRol WHERE rolName = '"
        			+ (String)tupla[2] + "';");
        	Object[] tuplaRol = lista2.get(0);
    		
        	usuario = (String)tupla[0];
        	password = (String)tupla[1];
            rol = new Rol((String)tupla[2],(String)tuplaRol[3]);
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
            if (rol.getPais() == "ESP") {
            	sede = new Sede((String)tupla[18]);
            } else {
            	sede = null;
            }
    	}
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
    		
    		if (tupla[16] != null)
    			throw new Error("Usuario dado de baja.");
    		
        	List<Object[]> lista2 = miBD.Select("SELECT * FROM tRol WHERE rolName = '"
        			+ (String)tupla[2] + "';");
        	Object[] tuplaRol = lista2.get(0);
    		
        	usuario = (String)tupla[0];
        	password = (String)tupla[1];
            rol = new Rol((String)tupla[2],(String)tuplaRol[3]);
            nombre = (String)tupla[3] == null ? "" : (String)tupla[3];
            apellidos = (String)tupla[4] == null ? "" : (String)tupla[4];
            estado = (String)tupla[5] == null ? "" : (String)tupla[5];
            nif = (String)tupla[6] == null ? "" : (String)tupla[6];
            direccion = (String)tupla[7] == null ? "" : (String)tupla[7];
            codigoPostal = (Integer)tupla[8] == null ? -1 : (Integer)tupla[8];
            provincia = (String)tupla[9] == null ? "" : (String)tupla[9];
            telefonoFijo = (String)tupla[10] == null ? "" : (String)tupla[10];
            telefonoMovil = (String)tupla[11] == null ? "" : (String)tupla[11];
            email = (String)tupla[12] == null ? "" : (String)tupla[12];
            boolean esNull = tupla[13] == null ? true : false;
            if (esNull) certificado = false;
            if (!esNull) certificado = (Integer)tupla[13] == 1 ? true : false;
            sector = (String)tupla[14] == null ? "" : (String)tupla[14];
            fechaAlta = (Date)tupla[15] == null ? null : (Date)tupla[15];
            fechaBaja = (Date)tupla[16] == null ? null : (Date)tupla[16];
            observaciones = (String)tupla[17] == null ? "" : (String)tupla[17];
            if (rol.getPais().equals("ESP")) {
            	sede = new Sede((String)tupla[18]);
            } else {
            	sede = null;
            }
    	}
        
    }
    
    public Usuario(String n, String p, Rol r)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	
    	if (n.length() <= 0 || p.length() <= 0 || r.getRolName().length() <= 0) {
    		throw new Error("Rellene los campos obligatorios.");
    	}
    	if (miBD.Select("SELECT * FROM tUsuario WHERE usuario = '"+n+"';").isEmpty()) {
			miBD.Insert("INSERT into tUsuario values('"+n+"','"+p+"','"+r.getRolName()+"',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);");
    		
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
    	miBD.Update("UPDATE tUsuario set nombre = '" + value + "' WHERE usuario = '" + usuario + "';");
    	nombre = value;
    	

    }

    public void desactivaUsuario() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String fecha = formatoDelTexto.format(date);
    	miBD.Update("UPDATE tUsuario set fechaBaja = '" + fecha + "' WHERE usuario = '" + this.usuario + "';");
    	fechaBaja = date;
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
    	if (this.rol.getRolName().equals("Administrador") || this.rol.getNivel() >= 3) {
        	BD miBD = new BD(BD_SERVER, BD_NAME);
        	miBD.Update("UPDATE tUsuario set rol = '" + r.getRolName() + "' WHERE usuario = '" + u.getUsuario() + "';");
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
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set usuario = '" + usuario + "' WHERE usuario = '" + this.usuario + "';");
		this.usuario = usuario;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set apellidos = '" + apellidos + "' WHERE usuario = '" + this.usuario + "';");
		this.apellidos = apellidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set estado = '" + estado + "' WHERE usuario = '" + this.usuario + "';");
		this.estado = estado;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set nif = '" + nif + "' WHERE usuario = '" + this.usuario + "';");
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set direccion = '" + direccion + "' WHERE usuario = '" + this.usuario + "';");
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal == 0 ? -1 : codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set codigoPostal = " + codigoPostal + " WHERE usuario = '" + this.usuario + "';");
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set provincia = '" + provincia + "' WHERE usuario = '" + this.usuario + "';");
		this.provincia = provincia;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set telefonoFijo = '" + telefonoFijo + "' WHERE usuario = '" + this.usuario + "';");
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set telefonoMovil = '" + telefonoMovil + "' WHERE usuario = '" + this.usuario + "';");
		this.telefonoMovil = telefonoMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set email = '" + email + "' WHERE usuario = '" + this.usuario + "';");
		this.email = email;
	}

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	int cert = certificado ? 1 : 0;
    	miBD.Update("UPDATE tUsuario set certificado = " + cert + " WHERE usuario = '" + this.usuario + "';");
		this.certificado = certificado;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set sector = '" + sector + "' WHERE usuario = '" + this.usuario + "';");
		this.sector = sector;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	if(fechaAlta != null) miBD.Update("UPDATE tUsuario set fechaAlta = '" + formatoDelTexto.format(fechaAlta) + "' WHERE usuario = '" + this.usuario + "';");
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
    	miBD.Update("UPDATE tUsuario set observaciones = '" + observaciones + "' WHERE usuario = '" + this.usuario + "';");
		this.observaciones = observaciones;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
    	BD miBD = new BD(BD_SERVER, BD_NAME);
    	miBD.Update("UPDATE tUsuario set sede = '" + sede.getLocalizacion() + "' WHERE usuario = '" + this.usuario + "';");
		this.sede = sede;
	}
}
