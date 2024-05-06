package pktLizkaVega_facturas;

public class clsArrObjCliente {
	private String codigoCliente;
	private String cedulaCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String numeroCliente;
	
	public clsArrObjCliente()
	{
		codigoCliente = "";
		cedulaCliente = "";
		nombreCliente = "";
		apellidoCliente = "";
		numeroCliente = "";
	}
	
	public clsArrObjCliente(String codigoCliente, String cedulaCliente, String nombreCliente, String apellidoCliente, String numeroCliente)
	{
		this.codigoCliente = codigoCliente;
		this.cedulaCliente = cedulaCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.numeroCliente = numeroCliente;
	}
	
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public String getNumeroCliente() {
		return numeroCliente;
	}
}


