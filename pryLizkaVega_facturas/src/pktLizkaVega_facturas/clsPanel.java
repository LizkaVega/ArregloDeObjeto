package pktLizkaVega_facturas;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class clsPanel {
	// Instancia de NumberFormat para formatear moneda
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.US);
		
		// Método para crear el encabezado principal del panel
		public JPanel crearEncabezadoPrincipal(String fecha) {
			// Líneas del encabezado
			String[] encabezado = {
				"UNIVERSIDAD TECNOLÓGICA DE PANAMÁ",
				"CENTRO REGIONAL DE CHIRIQUÍ",
				"FACULTAD DE INGENIERÍA DE SISTEMAS DE COMPUTACIÓN",
				"CARRERA LICENCIATURA EN DESARROLLO Y GESTIÓN DE SOFTWARE",
				"GRUPO 2GS212",
				"ANÁLISIS DE ANTIGÜEDAD DE CUENTAS POR COBRAR"
			};

			// Crear un nuevo GridBagLayout y un JPanel para contener el contenido
			GridBagLayout gridBagLayout = new GridBagLayout();
			JPanel panelEncabezado = new JPanel(gridBagLayout);

			// Configurar las restricciones para centrar el contenido
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.anchor = GridBagConstraints.CENTER;

			// Agregar cada línea del encabezado como un JLabel al panel
			for (int i = 0; i < encabezado.length; i++) {
				String linea = encabezado[i];
				JLabel etiqueta = new JLabel(linea);

				// Agregar espacio vertical usando Insets
				if (i == 2 || i == 5) {
					gbc.insets = new Insets(25, 0, 0, 0);
				} else {
					gbc.insets = new Insets(0, 0, 0, 0);
				}

				gridBagLayout.setConstraints(etiqueta, gbc);
				panelEncabezado.add(etiqueta);
			}

			// Crear una nueva fila para las etiquetas del estudiante y del docente
			JPanel panelInformacion = new JPanel(new GridBagLayout());
			GridBagConstraints gbcInfo = new GridBagConstraints();

			// Agregar información del estudiante como una etiqueta
			JLabel estudianteLabel = new JLabel("ESTUDIANTE: Lizka Vega");
			gbcInfo.gridx = 0;
			gbcInfo.gridy = 0;
			gbcInfo.insets = new Insets(0, 0, 0, 145);  // Ajustar el espacio horizontal entre las etiquetas
			panelInformacion.add(estudianteLabel, gbcInfo);

			// Agregar información del docente como otra etiqueta
			JLabel docenteLabel = new JLabel("DOCENTE: Prof. Eduardo Beitia");
			gbcInfo.gridx = 1;
			gbcInfo.insets = new Insets(0, 10, 0, 180);  // Ajustar el espacio horizontal entre las etiquetas
			panelInformacion.add(docenteLabel, gbcInfo);

			// Restablecer las restricciones para la siguiente componente (puede que no sea necesario dependiendo del diseño)
			gbcInfo.gridx = 2;
			gbcInfo.weightx = 1;

			// Agregar el panel de información al panel principal
			gbc.insets = new Insets(25, 0, 0, 0); // Restablecer los márgenes para la etiqueta de fecha
			panelEncabezado.add(panelInformacion, gbc);

			// Agregar la fecha debajo de panelInformacion
			gbc.insets = new Insets(25, 0, 0, 406); // Agregar espacio vertical debajo de panelInformacion
			JLabel fechaLabel = new JLabel("Fecha: " + fecha);
			gridBagLayout.setConstraints(fechaLabel, gbc);
			panelEncabezado.add(fechaLabel);

			return panelEncabezado;
		}
		
		// Método para agregar la información de un cliente al panel principal
		public void agregarCliente(JPanel panelPrincipal, String codigoCliente, String apellidoCliente, String nombreCliente) {
			JPanel panelCliente = new JPanel(new GridBagLayout());
			GridBagConstraints gbcCliente = new GridBagConstraints();
			gbcCliente.anchor = GridBagConstraints.CENTER;

			JLabel codigoClienteLabel = new JLabel("CÓDIGO CLIENTE: " + codigoCliente);
			JLabel nombreClienteLabel = new JLabel("NOMBRE: " + nombreCliente + " " + apellidoCliente);

			gbcCliente.gridx = 0;
			gbcCliente.gridy = 0;
			gbcCliente.insets = new Insets(25, 0, 0, 174);  // Ajustar el espacio horizontal entre las etiquetas
			panelCliente.add(codigoClienteLabel, gbcCliente);

			gbcCliente.gridx = 1;
			gbcCliente.insets = new Insets(25, 50, 0, 146);  // Ajustar el espacio horizontal entre las etiquetas
			panelCliente.add(nombreClienteLabel, gbcCliente);

			// Agregar el panelCliente con restricciones al panelPrincipal
			GridBagConstraints gbcClientePrincipal = new GridBagConstraints();
			gbcClientePrincipal.gridwidth = GridBagConstraints.REMAINDER;
			gbcClientePrincipal.anchor = GridBagConstraints.CENTER;
			panelPrincipal.add(panelCliente, gbcClientePrincipal);
		}

		// Método para agregar el encabezado de las facturas al panel principal
		public void agregarEncabezadoFacturas(JPanel panelPrincipal) {
			JPanel panelFacturasPrincipal = new JPanel(new GridBagLayout());
			JPanel panelFactura = new JPanel(new GridLayout(1, 8, 0, 0)); // 2 filas, 4 columnas, sin espacio horizontal
			GridBagConstraints gbc = new GridBagConstraints();

			JLabel[] etiquetas = {
				new JLabel("FECHA"),
				new JLabel("NUM. FACTURA"),
				new JLabel("MONTO"),
				new JLabel("MES CORR."),
				new JLabel("30 DÍAS"),
				new JLabel("60 DÍAS"),
				new JLabel("90 DÍAS"),
				new JLabel("+120 DÍAS")
			};

			for (int i = 0; i < etiquetas.length; i++) {
				JLabel etiqueta = etiquetas[i];
				etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
				etiqueta.setPreferredSize(new Dimension(85, etiqueta.getPreferredSize().height));
				if (i >= 2) {
					etiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				panelFactura.add(etiqueta);
			}
			gbc.insets = new Insets(25, 0, 0, 8);
			panelFacturasPrincipal.add(panelFactura, gbc);
			GridBagConstraints gbcFacturaPrincipal = new GridBagConstraints();
			gbcFacturaPrincipal.gridwidth = GridBagConstraints.REMAINDER;
			gbcFacturaPrincipal.anchor = GridBagConstraints.CENTER;
			panelPrincipal.add(panelFacturasPrincipal, gbcFacturaPrincipal);
		}
		
		// Método para agregar la información de una factura al panel principal
		public void agregarFacturas(String fechaFactura, int numeroFactura, double montoFactura, double[] montoFacturas, JPanel panelPrincipal) {
			JPanel panelFacturasPrincipal = new JPanel(new GridBagLayout());
			JPanel panelFacturas = new JPanel(new GridLayout(1, 8, 0, 0));
			// Configurar las restricciones para centrar el contenido
			GridBagConstraints gbc = new GridBagConstraints();

			JLabel[] etiquetas = {
				new JLabel(fechaFactura),
				new JLabel(Integer.toString(numeroFactura)),
				new JLabel(formatoMoneda.format(montoFactura)),
				new JLabel(formatoMoneda.format(montoFacturas[0])),
				new JLabel(formatoMoneda.format(montoFacturas[1])),
				new JLabel(formatoMoneda.format(montoFacturas[2])),
				new JLabel(formatoMoneda.format(montoFacturas[3])),
				new JLabel(formatoMoneda.format(montoFacturas[4])),
			};

			for (int i = 0; i < etiquetas.length; i++) {
				if(i <= 1)
					etiquetas[i].setHorizontalAlignment(SwingConstants.CENTER);
				etiquetas[i].setPreferredSize(new Dimension(85, etiquetas[i].getPreferredSize().height));
				if(i >= 2)
					etiquetas[i].setHorizontalAlignment(SwingConstants.RIGHT);
				panelFacturas.add(etiquetas[i]);
			}

			// Agregar el panelFactura con restricciones al panelPrincipal
			gbc.insets = new Insets(0, 0, 0, 8);
			panelFacturasPrincipal.add(panelFacturas, gbc);
			GridBagConstraints gbcFacturaPrincipal = new GridBagConstraints();
			gbcFacturaPrincipal.gridwidth = GridBagConstraints.REMAINDER;
			gbcFacturaPrincipal.anchor = GridBagConstraints.CENTER;
			panelPrincipal.add(panelFacturasPrincipal, gbcFacturaPrincipal);
		}
		
		// Método para agregar las totales de las facturas al panel principal
		public void agregarFacturasTotales(JPanel panelPrincipal, double[] montoTotalFacturas) {
			JPanel panelFacturasPrincipal = new JPanel(new GridBagLayout());
			JPanel panelFacturas = new JPanel(new GridLayout(1, 6, 0, 0));  // Cambiado de 8 a 6
			GridBagConstraints gbc = new GridBagConstraints();

			// Añadir un separador al panelPrincipal con un nuevo GridBagConstraints
			JLabel separador = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			GridBagConstraints gbcSeparador = new GridBagConstraints();
			gbcSeparador.gridwidth = GridBagConstraints.REMAINDER;
			panelPrincipal.add(separador, gbcSeparador);

			JLabel[] etiquetas = {
				new JLabel(formatoMoneda.format(montoTotalFacturas[0])),
				new JLabel(formatoMoneda.format(montoTotalFacturas[1])),
				new JLabel(formatoMoneda.format(montoTotalFacturas[2])),
				new JLabel(formatoMoneda.format(montoTotalFacturas[3])),
				new JLabel(formatoMoneda.format(montoTotalFacturas[4])),
				new JLabel(formatoMoneda.format(montoTotalFacturas[5]))
			};

			// Añadir etiquetas al panelFacturas
			for (JLabel etiqueta : etiquetas) {
				etiqueta.setPreferredSize(new Dimension(85, etiqueta.getPreferredSize().height));
				etiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
				panelFacturas.add(etiqueta);
			}

			// Añadir panelFacturas al panelFacturasPrincipal
			gbc.insets = new Insets(0, 164, 0, 0);
			panelFacturasPrincipal.add(panelFacturas, gbc);

			// Añadir panelFacturasPrincipal al panelPrincipal
			panelPrincipal.add(panelFacturasPrincipal);
		}
	}

