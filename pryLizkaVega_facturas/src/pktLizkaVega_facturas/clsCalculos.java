package pktLizkaVega_facturas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class clsCalculos {
	/**
	 * Calcula los días transcurridos entre la fecha de la factura y la fecha actual.
	 */
	public long diasTranscurridos(LocalDate fechaFactura) {
		LocalDate fechaActual = LocalDate.now();
		return ChronoUnit.DAYS.between(fechaFactura, fechaActual);
	}

	/**
	 * Obtiene la fecha actual formateada en un string.
	 */
	public String obtenerFechaActual() {
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
		String fechaFormateada = fechaActual.format(formato);
		String[] partes = fechaFormateada.split(" ");
		partes[0] = partes[0].substring(0, 1).toUpperCase() + partes[0].substring(1).toLowerCase();
		partes[3] = partes[3].substring(0, 1).toUpperCase() + partes[3].substring(1).toLowerCase();
		fechaFormateada = String.join(" ", partes);
		return fechaFormateada;
	}

	/**
	 * Convierte una fecha en formato de cadena (dd/MM/yyyy) a un objeto LocalDate.
	 */
	public LocalDate convertirFechaFacturaADate(String fecha) {
		DateTimeFormatter formatoFechaDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(fecha, formatoFechaDate);
	}
}

