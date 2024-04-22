package DefaultPackages;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CarritoEmpresa extends javax.swing.JFrame {

    static String Nombre;
    static double Precio;
    static boolean AceptarBoton = false;

    public CarritoEmpresa() {
        initComponents();

        textoCantidad.setVisible(false);

        setTitle("Comprar");
        setLocationRelativeTo(null);
        setResizable(false);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProducto.setModel(modeloTabla);

        String campo = cajaBuscar.getText();
        String where = "";
        if (!"".equals(campo)) {
            where = "where Code = '" + campo + "'";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Category from itemsproducts " + where);
            rs = ps.executeQuery();

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Costo");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Categoria");

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            int anchos[] = {30, 150, 50, 50, 150};

            for (int i = 0; i < cantidadColumnas; i++) {
                tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while (rs.next()) {
                Object fila[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        cajaBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonConfirmarCompra = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        textoCantidad = new javax.swing.JTextField();
        textoPrecio = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        textoClave = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoCategoria = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OSboton = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        carritoBoton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProducto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaProducto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.setRowHeight(25);
        tablaProducto.getTableHeader().setReorderingAllowed(false);
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);
        if (tablaProducto.getColumnModel().getColumnCount() > 0) {
            tablaProducto.getColumnModel().getColumn(0).setResizable(false);
            tablaProducto.getColumnModel().getColumn(1).setResizable(false);
            tablaProducto.getColumnModel().getColumn(2).setResizable(false);
        }

        cajaBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cajaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Nombre del producto");

        botonAgregar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonAgregar.setText("Agregar Producto");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonConfirmarCompra.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonConfirmarCompra.setText("Confirmar compra");
        botonConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarCompraActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Clave");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Precio");

        botonBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        textoPrecio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        textoClave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Categoria");

        textoCategoria.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jMenu1.setText("Menú");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        OSboton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        OSboton.setText("Organizador de Stocks");
        OSboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OSbotonActionPerformed(evt);
            }
        });
        jMenu1.add(OSboton);
        jMenu1.add(jSeparator1);

        carritoBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        carritoBoton.setText("Carrito");
        carritoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carritoBotonActionPerformed(evt);
            }
        });
        jMenu1.add(carritoBoton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(botonBuscar)
                        .addGap(165, 165, 165))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(botonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonConfirmarCompra)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botonBuscar)
                    .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(textoPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(textoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonConfirmarCompra)
                            .addComponent(botonAgregar))
                        .addGap(89, 89, 89))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProducto.setModel(modeloTabla);
        String campo = cajaBuscar.getText();
        String where = "";
        if (!"".equals(campo)) {
            where = "where Name like '" + campo + "%'";
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Category from itemsproducts " + where);
            rs = ps.executeQuery();

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Costo");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Categoria");

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            int anchos[] = {30, 150, 50, 50, 150};

            for (int i = 0; i < cantidadColumnas; i++) {
                tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while (rs.next()) {
                Object fila[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            int fila = tablaProducto.getSelectedRow();
            String clave = tablaProducto.getValueAt(fila, 0).toString();

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Category from itemsproducts where Code=?");
            ps.setString(1, clave);
            rs = ps.executeQuery();

            while (rs.next()) {
                textoNombre.setText(rs.getString("Name"));
                textoPrecio.setText(String.valueOf(rs.getDouble("Cost")));
                textoCantidad.setText(String.valueOf(rs.getInt("Quantity")));
                textoClave.setText(String.valueOf(rs.getInt("Code")));
                textoCategoria.setText(rs.getString("Category"));
                if (AceptarBoton) {
                    Nombre = textoNombre.getText();
                    Precio = Double.parseDouble(textoPrecio.getText());

                    Carrito carrito = new Carrito();
                }
            }
        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }


    }//GEN-LAST:event_tablaProductoMouseClicked

    private void carritoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carritoBotonActionPerformed
        Carrito carrito = new Carrito();
        carrito.setVisible(true);
        dispose();
    }//GEN-LAST:event_carritoBotonActionPerformed

    private void OSbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OSbotonActionPerformed
        Tabla tabla = new Tabla();
        tabla.setVisible(true);
        dispose();

    }//GEN-LAST:event_OSbotonActionPerformed

    private void botonConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarCompraActionPerformed
        Carrito carrito = new Carrito();
        carrito.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonConfirmarCompraActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProducto.setModel(modeloTabla);

        String campo = cajaBuscar.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "where Name like '" + campo + "%'";
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Category from itemsproducts " + where);
            rs = ps.executeQuery();

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Costo");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Categoria");

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            int anchos[] = {30, 150, 50, 50, 150};

            for (int i = 0; i < cantidadColumnas; i++) {
                tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object fila[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed

        AceptarBoton = true;

        PreparedStatement ps = null;

        Carrito carrito = new Carrito();

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            if (carrito.repetido(textoNombre.getText()) == 0) {
                ps = conexion.prepareStatement("insert into shop (Code, Name, Cost, Quantity, Total, Category) values (?,?,?,?,?,?)");
                ps.setString(1, textoClave.getText());
                ps.setString(2, textoNombre.getText());
                ps.setDouble(3, Double.parseDouble(textoPrecio.getText()));
                ps.setInt(4, Integer.parseInt(textoCantidad.getText()));
                ps.setDouble(5, Double.parseDouble(textoPrecio.getText()));
                ps.setString(6, textoCategoria.getText());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Agregado correctamente");
                limpiarCajas();
                botonBuscarActionPerformed(evt);

            } else {

                JOptionPane.showMessageDialog(null, "Este elemento ya se encuentra en el carrito");
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }//GEN-LAST:event_botonAgregarActionPerformed

    public void limpiarCajas() {

        textoCantidad.setText(null);
        textoNombre.setText(null);
        textoPrecio.setText(null);
        textoClave.setText(null);
        cajaBuscar.setText(null);
        textoCategoria.setText(null);
    }

    public void validarIngresosTabla() {

        Carrito carrito = new Carrito();

        for (int i = 0; i < tablaProducto.getRowCount(); i++) {
            if (carrito.tablaProducto.getValueAt(i, 1).equals(textoNombre.getText())) {
                JOptionPane.showMessageDialog(null, "Elemento duplicado");

            }

        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarritoEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OSboton;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonConfirmarCompra;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JMenuItem carritoBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JLabel textoCategoria;
    private javax.swing.JLabel textoClave;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoPrecio;
    // End of variables declaration//GEN-END:variables
}
