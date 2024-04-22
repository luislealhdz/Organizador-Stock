package DefaultPackages;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Carrito extends javax.swing.JFrame {

    static double precioinicial;
    static double precioTotal;
    static int cantidadProductos;
    static int cantidadRestante;
    static double precioTotalAPagar;
    static int QuantityToBuyPlus;
    static int QuantityToBuyLess;
    static int CantidadAPagar;

    public Carrito() {
        initComponents();

        setTitle("Carrito");
        setLocationRelativeTo(null);
        setResizable(false);

        textoCantidad.setVisible(false);
        textoClave.setVisible(false);
        textoCantidadRestante.setVisible(false);
        textoQuantityToBuy.setVisible(false);
        textoQuantityToBuyLess.setVisible(false);
        restarProducto.setVisible(false);
        botonActualizar.setVisible(false);
        cajaPagar.setVisible(false);
        textoNombre.setVisible(false);
        textoPrecio.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jlabel5.setVisible(false);
        textoCategoria.setVisible(false);
        TotalBtn.setVisible(false);

        tablaProducto.setDefaultRenderer(Object.class, new BotonesTabla());

        limpiarCajas();

        totalAPagar.setText("Total a Pagar: $0.00");

        JButton btn1 = new JButton("Agregar");
        btn1.setName("Agregar");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("Eliminar");

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

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Total, QuantityToBuy, Category from shop " + where);
            rs = ps.executeQuery();

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Costo");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Agregar");
            modeloTabla.addColumn("Eliminar");
            modeloTabla.addColumn("Total");
            modeloTabla.addColumn("Cantidad A Comprar");
            modeloTabla.addColumn("Categoria");

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            int anchos[] = {10, 150, 10, 10, 50, 50, 20, 10, 150};

            for (int i = 0; i < cantidadColumnas; i++) {
                tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object fila[] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(4);
                    fila[4] = btn1;
                    fila[5] = btn2;
                    fila[6] = rs.getObject(5);
                    fila[7] = rs.getObject(6);
                    fila[8] = rs.getObject(7);
                    SumarColumnas();
                }
                modeloTabla.addRow(fila);
                tablaProducto.setRowHeight(30);
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonPagar = new javax.swing.JButton();
        cajaPagar = new javax.swing.JTextField();
        textoCantidad = new javax.swing.JTextField();
        textoClave = new javax.swing.JTextField();
        textoCantidadRestante = new javax.swing.JTextField();
        cajaBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        totalAPagar = new javax.swing.JLabel();
        textoQuantityToBuy = new javax.swing.JTextField();
        textoQuantityToBuyLess = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        restarProducto = new javax.swing.JButton();
        eliminarProducto = new javax.swing.JButton();
        TotalBtn = new javax.swing.JButton();
        vaciarTabla = new javax.swing.JButton();
        textoPrecio = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        textoCategoria = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OSboton = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        comprarBoton = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1090, 0));

        tablaProducto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaProducto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.setRowHeight(25);
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);
        if (tablaProducto.getColumnModel().getColumnCount() > 0) {
            tablaProducto.getColumnModel().getColumn(0).setResizable(false);
            tablaProducto.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel3.setText("Precio: ");

        jLabel4.setText("Nombre: ");

        botonPagar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonPagar.setText("Pagar");
        botonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarActionPerformed(evt);
            }
        });

        cajaPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPagarActionPerformed(evt);
            }
        });

        textoCantidadRestante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCantidadRestanteActionPerformed(evt);
            }
        });

        cajaBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        botonBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        totalAPagar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalAPagar.setText("Total a pagar");

        botonActualizar.setText("Actualizar");
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonActualizarMouseClicked(evt);
            }
        });

        restarProducto.setText("-");
        restarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restarProductoMouseClicked(evt);
            }
        });

        eliminarProducto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eliminarProducto.setText("Eliminar Producto");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });

        TotalBtn.setText("Total");
        TotalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalBtnActionPerformed(evt);
            }
        });

        vaciarTabla.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vaciarTabla.setText("Vaciar");
        vaciarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarTablaActionPerformed(evt);
            }
        });

        jlabel5.setText("Categoria:");

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
        jMenu1.add(jSeparator2);

        comprarBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        comprarBoton.setText("Comprar");
        comprarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarBotonActionPerformed(evt);
            }
        });
        jMenu1.add(comprarBoton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                                .addComponent(restarProducto)
                                .addGap(36, 36, 36)
                                .addComponent(botonActualizar)
                                .addGap(38, 38, 38)
                                .addComponent(TotalBtn)
                                .addGap(18, 18, 18)
                                .addComponent(vaciarTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eliminarProducto)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(botonPagar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(totalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cajaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(423, 423, 423))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabel5)
                                .addGap(18, 18, 18)
                                .addComponent(textoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(textoQuantityToBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(textoQuantityToBuyLess, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(textoCantidadRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel5)
                            .addComponent(textoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoQuantityToBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoQuantityToBuyLess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoCantidadRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eliminarProducto)
                                .addComponent(vaciarTabla)
                                .addComponent(TotalBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(restarProducto)
                                .addComponent(botonActualizar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(botonPagar)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagarActionPerformed

        try {
            updateQuantity();
            JOptionPane.showMessageDialog(null, "Total a pagar: " + (double) Math.round(precioTotalAPagar * 100) / 100);
            registro();
            vaciarTablaActionPerformed(evt);
            botonBuscarActionPerformed(evt);
            totalAPagar.setText("Total a pagar: $0.00");

        } catch (Exception ex) {
            System.out.println("Error, " + ex);
        }

    }//GEN-LAST:event_botonPagarActionPerformed

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            int column = tablaProducto.getColumnModel().getColumnIndexAtX(evt.getX());
            int row = evt.getY() / tablaProducto.getRowHeight();

            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            int fila = tablaProducto.getSelectedRow();
            String clave = tablaProducto.getValueAt(fila, 0).toString();

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Total, QuantityToBuy, Category from shop where Code=?");
            ps.setString(1, clave);
            rs = ps.executeQuery();

            while (rs.next()) {
                textoNombre.setText(rs.getString("Name"));
                textoPrecio.setText(String.valueOf(rs.getDouble("Cost")));
                textoCantidad.setText(String.valueOf(rs.getInt("Quantity")));
                cajaPagar.setText(String.valueOf(rs.getDouble("Cost")));
                textoQuantityToBuy.setText(String.valueOf(rs.getInt("QuantityToBuy")));
                textoQuantityToBuyLess.setText(String.valueOf(rs.getInt("QuantityToBuy")));
                textoCategoria.setText(rs.getString("Category"));
                textoClave.setText(String.valueOf(rs.getInt("Code")));

                precioinicial = Double.parseDouble(cajaPagar.getText());

                cantidadProductos = Integer.parseInt(textoCantidad.getText());

                CantidadAPagar = Integer.parseInt(textoQuantityToBuy.getText());

                cantidadRestante = cantidadProductos - CantidadAPagar;

                textoCantidadRestante.setText(String.valueOf(cantidadRestante));

                QuantityToBuyPlus = Integer.parseInt(textoQuantityToBuy.getText());
                QuantityToBuyPlus++;

                QuantityToBuyLess = Integer.parseInt(textoQuantityToBuyLess.getText());
                QuantityToBuyLess--;

                if (QuantityToBuyLess == -1) {

                    restarProductoMouseClicked(evt);
                    botonActualizarMouseClicked(evt);

                }
            }

            if (row < tablaProducto.getRowCount() && row >= 0 && column < tablaProducto.getColumnCount() && column >= 0) {
                Object value = tablaProducto.getValueAt(row, column);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;

                    if (boton.getName().equals("Agregar")) {

                        try {

                            precioTotal = precioinicial * CantidadAPagar + precioinicial;

                            for (int i = 0; i < tablaProducto.getRowCount(); i++) {

                                if (Integer.parseInt(tablaProducto.getValueAt(i, 7).toString()) < cantidadProductos) {

                                    ps = conexion.prepareStatement("update shop set QuantityToBuy=?, Total=? where Code=?");
                                    ps.setString(1, String.valueOf(QuantityToBuyPlus));
                                    ps.setString(2, String.valueOf(precioTotal));
                                    ps.setString(3, textoClave.getText());

                                    ps.executeUpdate();
                                    SumarColumnas();
                                    botonActualizarMouseClicked(evt);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya no quedan productos en el almacen");
                                }
                            }
                        } catch (Exception ex) {
                            System.err.println("Error, " + ex);
                        }

                    }
                    if (boton.getName().equals("Eliminar")) {

                        try {

                            precioTotal = precioinicial * CantidadAPagar - precioinicial;

                            ps = conexion.prepareStatement("update shop set QuantityToBuy=?, Total=? where Code=?");
                            ps.setString(1, String.valueOf(QuantityToBuyLess));
                            ps.setString(2, String.valueOf(precioTotal));
                            ps.setString(3, textoClave.getText());

                            ps.executeUpdate();
                            SumarColumnas();
                            botonActualizarMouseClicked(evt);

                            if (precioTotal == 0) {
                                restarProductoMouseClicked(evt);
                                SumarColumnas();
                            }

                        } catch (Exception ex) {
                            System.err.println("Error, " + ex);
                        }

                    }

                }
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void cajaPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPagarActionPerformed

    }//GEN-LAST:event_cajaPagarActionPerformed

    private void textoCantidadRestanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCantidadRestanteActionPerformed

    }//GEN-LAST:event_textoCantidadRestanteActionPerformed

    private void comprarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarBotonActionPerformed
        CarritoEmpresa carritoE = new CarritoEmpresa();
        carritoE.setVisible(true);
        dispose();
    }//GEN-LAST:event_comprarBotonActionPerformed

    private void OSbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OSbotonActionPerformed
        Tabla tabla = new Tabla();
        tabla.setVisible(true);
        dispose();
    }//GEN-LAST:event_OSbotonActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

        SumarColumnas();

        JButton btn1 = new JButton("Agregar");
        btn1.setName("Agregar");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("Eliminar");

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

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Total, QuantityToBuy, Category from shop " + where);
            rs = ps.executeQuery();

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Costo");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Agregar");
            modeloTabla.addColumn("Eliminar");
            modeloTabla.addColumn("Total");
            modeloTabla.addColumn("Cantidad A Comprar");
            modeloTabla.addColumn("Categoria");

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            int anchos[] = {10, 150, 10, 10, 50, 50, 20, 10, 150};

            for (int i = 0; i < cantidadColumnas; i++) {
                tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object fila[] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(4);
                    fila[4] = btn1;
                    fila[5] = btn2;
                    fila[6] = rs.getObject(5);
                    fila[7] = rs.getObject(6);
                    fila[8] = rs.getObject(7);
                    SumarColumnas();
                }
                modeloTabla.addRow(fila);
                tablaProducto.setRowHeight(30);
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMouseClicked

        JButton btn1 = new JButton("Agregar");
        btn1.setName("Agregar");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("Eliminar");

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

            ps = conexion.prepareStatement("select Code, Name, Cost, Quantity, Total, QuantityToBuy, Category from shop " + where);
            rs = ps.executeQuery();

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Costo");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Agregar");
            modeloTabla.addColumn("Eliminar");
            modeloTabla.addColumn("Total");
            modeloTabla.addColumn("Cantidad A Comprar");
            modeloTabla.addColumn("Categoria");

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            int anchos[] = {10, 150, 10, 10, 50, 50, 20, 10, 150};

            for (int i = 0; i < cantidadColumnas; i++) {
                tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object fila[] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(4);
                    fila[4] = btn1;
                    fila[5] = btn2;
                    fila[6] = rs.getObject(5);
                    fila[7] = rs.getObject(6);
                    fila[8] = rs.getObject(7);
                    SumarColumnas();
                }
                modeloTabla.addRow(fila);
                tablaProducto.setRowHeight(30);
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }//GEN-LAST:event_botonActualizarMouseClicked

    private void restarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restarProductoMouseClicked

        PreparedStatement ps = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("delete from shop where Code=?");
            ps.setString(1, textoClave.getText());

            ps.executeUpdate();
            botonActualizarMouseClicked(evt);
            limpiarCajas();

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }


    }//GEN-LAST:event_restarProductoMouseClicked


    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed

        PreparedStatement ps = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("delete from shop where Code=?");
            ps.setString(1, textoClave.getText());

            ps.executeUpdate();
            TotalBtnActionPerformed(evt);
            limpiarCajas();

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }


    }//GEN-LAST:event_eliminarProductoActionPerformed

    public void registro() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            ps = conexion.prepareStatement("call reporte()");
            rs = ps.executeQuery();

            JOptionPane.showMessageDialog(null, "Compra realizada");

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }

    private void TotalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalBtnActionPerformed

        SumarColumnas();
        totalAPagar.setText("Total a pagar: $" + precioTotalAPagar);
        botonBuscarActionPerformed(evt);
    }//GEN-LAST:event_TotalBtnActionPerformed

    private void vaciarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarTablaActionPerformed

        PreparedStatement ps = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("delete from shop where Code < 1000");

            ps.executeUpdate();
            SumarColumnas();
            botonBuscarActionPerformed(evt);
            limpiarCajas();

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

    }//GEN-LAST:event_vaciarTablaActionPerformed

    public void SumarColumnas() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("call sumaTotal()");
            rs = ps.executeQuery();

            rs.next();

            precioTotalAPagar = Double.parseDouble(rs.getString(1));

            if (rs.wasNull()) {
                totalAPagar.setText("Total a pagar: $0.00");
            } else {
                totalAPagar.setText("Total a pagar: $" + precioTotalAPagar);
            }

        } catch (Exception Ex) {
            System.out.println("Error, " + Ex);
        }

        rs = null;

    }

    public void limpiarCajas() {

        textoCantidad.setText(null);
        textoNombre.setText(null);
        textoPrecio.setText(null);
        textoClave.setText(null);
        textoCantidadRestante.setText(null);
        cajaPagar.setText(null);
        textoQuantityToBuy.setText(null);
        textoQuantityToBuyLess.setText(null);
        textoCategoria.setText(null);
        totalAPagar.setText("Total a pagar: $0.00");
    }

    public void updateQuantity() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        int columna = 0;

        int valorRestante = 0;

        int valorcantidadTotal = 0;

        String Name;

        String sqlText = "update itemsproducts set Quantity=? where Name=?";
        try {

            for (int i = 0; i < tablaProducto.getRowCount(); i++) {

                columna = Integer.parseInt(tablaProducto.getValueAt(i, 3).toString());

                valorRestante = Integer.parseInt(tablaProducto.getValueAt(i, 7).toString());

                Name = tablaProducto.getValueAt(i, 1).toString();

                valorcantidadTotal = columna - valorRestante;

                ps = conexion.prepareStatement(sqlText);
                ps.setInt(1, valorcantidadTotal);
                ps.setString(2, Name);

                ps.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println("Error, " + ex);
        }

    }

    public int repetido(String nombre) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "select count(Code) from shop where Name = ?";

        try {

            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (Exception ex) {
            System.out.println("Error, " + ex);
            return 1;
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OSboton;
    private javax.swing.JButton TotalBtn;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonPagar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaPagar;
    private javax.swing.JMenuItem comprarBoton;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JButton restarProducto;
    public javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoCantidadRestante;
    private javax.swing.JLabel textoCategoria;
    private javax.swing.JTextField textoClave;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JTextField textoQuantityToBuy;
    private javax.swing.JTextField textoQuantityToBuyLess;
    private javax.swing.JLabel totalAPagar;
    private javax.swing.JButton vaciarTabla;
    // End of variables declaration//GEN-END:variables

}
