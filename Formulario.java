import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Formulario {

    private JFrame frame;
    private JTextField textFieldEmail;
    private JTextField textFieldUnidades;
    private JComboBox<String> comboBoxMetodoPago;
    private JComboBox<String> comboBoxProductos;
    private JCheckBox checkBoxPrivacidad;
    private JButton btnComprar;
    private JButton btnCalcularPrecio;
    private JButton btnFinalizarCompra;

    private String productoSeleccionado;
    private double precioProducto;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario window = new Formulario();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Formulario() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblEmail = new JLabel("Correo electrónico:");
        lblEmail.setBounds(10, 11, 120, 14);
        frame.getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(140, 8, 200, 20);
        frame.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblUnidades = new JLabel("Unidades en stock:");
        lblUnidades.setBounds(10, 42, 120, 14);
        frame.getContentPane().add(lblUnidades);

        textFieldUnidades = new JTextField();
        textFieldUnidades.setBounds(140, 39, 50, 20);
        frame.getContentPane().add(textFieldUnidades);
        textFieldUnidades.setColumns(10);

        JLabel lblMetodoPago = new JLabel("Método de pago:");
        lblMetodoPago.setBounds(10, 73, 120, 14);
        frame.getContentPane().add(lblMetodoPago);

        comboBoxMetodoPago = new JComboBox<String>();
        comboBoxMetodoPago.setBounds(140, 70, 120, 20);
        comboBoxMetodoPago.addItem("Tarjeta");
        comboBoxMetodoPago.addItem("PayPal");
        comboBoxMetodoPago.addItem("Efectivo");
        frame.getContentPane().add(comboBoxMetodoPago);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(10, 104, 120, 14);
        frame.getContentPane().add(lblProducto);

        comboBoxProductos = new JComboBox<String>();
        comboBoxProductos.setBounds(140, 101, 120, 20);
        comboBoxProductos.addItem("Mesa");
        comboBoxProductos.addItem("Silla");
        comboBoxProductos.addItem("Lámpara");
        comboBoxProductos.addItem("Sofá");
        frame.getContentPane().add(comboBoxProductos);

        checkBoxPrivacidad = new JCheckBox("Aceptar política de privacidad");
        checkBoxPrivacidad.setBounds(10, 134, 200, 23);
        frame.getContentPane().add(checkBoxPrivacidad);
        checkBoxPrivacidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnComprar.setEnabled(checkBoxPrivacidad.isSelected());
            }
        });

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(10, 168, 89, 23);
        btnComprar.setEnabled(false);
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarProducto();
            }
        });
        frame.getContentPane().add(btnComprar);

        btnCalcularPrecio = new JButton("Calcular precio");
        btnCalcularPrecio.setBounds(109, 168, 120, 23);
        btnCalcularPrecio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPrecio();
            }
        });
        frame.getContentPane().add(btnCalcularPrecio);

        btnFinalizarCompra = new JButton("Finalizar compra");
        btnFinalizarCompra.setBounds(239, 168, 135, 23);
        btnFinalizarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });
        frame.getContentPane().add(btnFinalizarCompra);
    }

    private void comprarProducto() {
        productoSeleccionado = (String) comboBoxProductos.getSelectedItem();
        switch (productoSeleccionado) {
            case "Mesa":
                precioProducto = 7.95;
                break;
            case "Silla":
                precioProducto = 15.95;
                break;
            case "Lámpara":
                precioProducto = 25.50;
                break;
            case "Sofá":
                precioProducto = 9.99;
                break;
        }

        String mensaje = "Has comprado el siguiente producto:\n\n";
        mensaje += "Producto: " + productoSeleccionado + "\n";
        mensaje += "Precio: " + precioProducto + " euros\n";
        JOptionPane.showMessageDialog(frame, mensaje, "Confirmación de compra", JOptionPane.INFORMATION_MESSAGE);
    }

    private void calcularPrecio() {
        int unidades = Integer.parseInt(textFieldUnidades.getText());
        double precio = 0;

        switch (comboBoxProductos.getSelectedIndex()) {
            case 0: // Mesa
                precio = 7.95;
                break;
            case 1: // Silla
                precio = 15.95;
                break;
            case 2: // Lámpara
                precio = 25.50;
                break;
            case 3: // Sofá
                precio = 9.99;
                break;
        }

        double total = unidades * precio;
        JOptionPane.showMessageDialog(frame, "El importe total de la compra sin IVA es: " + total + " euros",
                "Total de compra", JOptionPane.INFORMATION_MESSAGE);
    }

    private void finalizarCompra() {
        int unidades = Integer.parseInt(textFieldUnidades.getText());
        double precio = 0;

        switch (comboBoxProductos.getSelectedIndex()) {
            case 0: // Mesa
                precio = 7.95;
                break;
            case 1: // Silla
                precio = 15.95;
                break;
            case 2: // Lámpara
                precio = 25.50;
                break;
            case 3: // Sofá
                precio = 9.99;
                break;
        }

        double total = unidades * precio;

        if (checkBoxPrivacidad.isSelected()) {
            total += total * 0.21; // IVA del 21%

            // Añadir 9.99 euros en caso de envío urgente
            if (JOptionPane.showConfirmDialog(frame, "¿Deseas envío urgente?", "Envío",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                total += 9.99;
            }

            JOptionPane.showMessageDialog(frame,
                    "El importe total de la compra con IVA y envío es: " + total + " euros", "Compra finalizada",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Debes aceptar la política de privacidad para finalizar la compra",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
