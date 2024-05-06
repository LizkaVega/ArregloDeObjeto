package pktLizkaVega_facturas;

public class clsFactura {
	private int numeroFactura;
	private String fechaFactura;
	private String codigoCliente;
	private double montoFactura;
	
	public clsFactura()
	{
		numeroFactura = 0;
		fechaFactura = "";
		codigoCliente = "";
		montoFactura = 0.00;
	}
	
	public clsFactura(int numeroFactura, String fechaFactura, String codigoCliente, double montoFactura)
	{
		this.numeroFactura = numeroFactura;
		this.fechaFactura = fechaFactura;
		this.codigoCliente = codigoCliente;
		this.montoFactura = montoFactura;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public String getFechaFactura() {
		return fechaFactura;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public double getMontoFactura() {
		return montoFactura;
	}
}
