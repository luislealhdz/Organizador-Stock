package DefaultPackages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Tabla extends javax.swing.JFrame {

    public Tabla() {
        initComponents();

        setTitle("Organizador de Stock");
        setLocationRelativeTo(null);
        setResizable(false);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProducto.setModel(modeloTabla);

        String campo = cajaBuscar.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "where Code = '" + campo + "'";
        }
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            String ASC = "select Code, Name, Cost, Quantity, Category from itemsproducts order by Code ASC";
            String DESC = "select Code, Name, Cost, Quantity, Category from itemsproducts order by Code DESC";
            if (botonOrdenar.getSelectedItem().equals("Ascendente")) {
                ps = conexion.prepareStatement(ASC);
                rs = ps.executeQuery();

                modeloTabla.addColumn("Codigo");
                modeloTabla.addColumn("Nombre");
                modeloTabla.addColumn("Costo");
                modeloTabla.addColumn("Cantidad");
                modeloTabla.addColumn("Categoria");

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidadColumnas = rsMD.getColumnCount();

                int anchos[] = {5, 200, 5, 5, 200};

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

            } else {
                ps = conexion.prepareStatement(DESC);
                rs = ps.executeQuery();

                modeloTabla.addColumn("Codigo");
                modeloTabla.addColumn("Nombre");
                modeloTabla.addColumn("Costo");
                modeloTabla.addColumn("Cantidad");
                modeloTabla.addColumn("Categoria");

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidadColumnas = rsMD.getColumnCount();

                int anchos[] = {5, 200, 5, 5, 200};

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
            }
        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        botonCargar = new javax.swing.JButton();
        cajaBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textoClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoPrecio = new javax.swing.JTextField();
        textoQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonOrdenar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        barraMenu = new javax.swing.JMenuBar();
        comprarBoton = new javax.swing.JMenu();
        botonComprar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        carritoBoton = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        botonReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProducto = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        tablaProducto.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Cost", "Quantity", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            tablaProducto.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablaProducto.getColumnModel().getColumn(0).setHeaderValue("Code");
            tablaProducto.getColumnModel().getColumn(1).setResizable(false);
            tablaProducto.getColumnModel().getColumn(1).setPreferredWidth(250);
            tablaProducto.getColumnModel().getColumn(1).setHeaderValue("Name");
            tablaProducto.getColumnModel().getColumn(2).setResizable(false);
            tablaProducto.getColumnModel().getColumn(2).setPreferredWidth(2);
            tablaProducto.getColumnModel().getColumn(2).setHeaderValue("Cost");
            tablaProducto.getColumnModel().getColumn(3).setResizable(false);
            tablaProducto.getColumnModel().getColumn(3).setPreferredWidth(2);
            tablaProducto.getColumnModel().getColumn(3).setHeaderValue("Quantity");
            tablaProducto.getColumnModel().getColumn(4).setResizable(false);
            tablaProducto.getColumnModel().getColumn(4).setPreferredWidth(250);
            tablaProducto.getColumnModel().getColumn(4).setHeaderValue("Category");
        }

        botonCargar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonCargar.setText("Buscar");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        cajaBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cajaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Buscar por código:");

        textoClave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Codigo");

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        textoPrecio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        textoQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Costo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Categoria");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Cantidad");

        botonInsertar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonInsertar.setText("Insertar");
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });

        botonModificar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonOrdenar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        botonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOrdenarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Ordenar por:");

        categorySelection.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar categoria", "DVC Sanitario (Drenaje)", "Cobre (Agua y Gas)", "CPVC (Agua Fría y Caliente)", "Tuberia Hidraulica Cedula 40 (Agua Fría a Presión)", "Pintura", "Tornillos", "Arandelas", "Galvanizado", "Electrico", "Varios" }));
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });

        comprarBoton.setText("Menú");
        comprarBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        botonComprar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonComprar.setText("Comprar");
        botonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprarActionPerformed(evt);
            }
        });
        comprarBoton.add(botonComprar);
        comprarBoton.add(jSeparator1);

        carritoBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        carritoBoton.setText("Carrito");
        carritoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carritoBotonActionPerformed(evt);
            }
        });
        comprarBoton.add(carritoBoton);
        comprarBoton.add(jSeparator2);

        botonReporte.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonReporte.setText("Reporte");
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });
        comprarBoton.add(botonReporte);

        barraMenu.add(comprarBoton);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6))
                                        .addGap(9, 9, 9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textoQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                    .addComponent(textoPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoClave, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(categorySelection, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botonInsertar)
                        .addGap(58, 58, 58)
                        .addComponent(botonModificar)
                        .addGap(61, 61, 61)
                        .addComponent(botonEliminar)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCargar)
                        .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonInsertar)
                            .addComponent(botonModificar)
                            .addComponent(botonEliminar))
                        .addGap(81, 81, 81))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
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

            int anchos[] = {5, 200, 5, 5, 200};

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

    }//GEN-LAST:event_botonCargarActionPerformed

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
                textoClave.setText(rs.getString("Code"));
                textoNombre.setText(rs.getString("Name"));
                textoPrecio.setText(String.valueOf(rs.getDouble("Cost")));
                textoQuantity.setText(String.valueOf(rs.getInt("Quantity")));

                String category = tablaProducto.getValueAt(fila, 4).toString();
                switch (category) {
                    case "Seleccionar categoria":
                        categorySelection.setSelectedIndex(0);
                        break;
                    case "DVC Sanitario (Drenaje)":
                        categorySelection.setSelectedIndex(1);
                        break;
                    case "Cobre (Agua y Gas)":
                        categorySelection.setSelectedIndex(2);
                        break;
                    case "CPVC (Agua Fría y Caliente)":
                        categorySelection.setSelectedIndex(3);
                        break;
                    case "Tuberia Hidraulica Cedula 40 (Agua Fría a Presión)":
                        categorySelection.setSelectedIndex(4);
                        break;
                    case "Pintura":
                        categorySelection.setSelectedIndex(5);
                        break;
                    case "Tornillos":
                        categorySelection.setSelectedIndex(6);
                        break;
                    case "Arandelas":
                        categorySelection.setSelectedIndex(7);
                        break;
                    case "Galvanizado":
                        categorySelection.setSelectedIndex(8);
                        break;
                    case "Electrico":
                        categorySelection.setSelectedIndex(9);
                        break;
                    case "Varios":
                        categorySelection.setSelectedIndex(10);
                        break;
                }
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        PreparedStatement ps = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            if (repetido(textoNombre.getText()) == 0) {
                ps = conexion.prepareStatement("insert into itemsproducts (Code, Name, Cost, Quantity, Category) values (?,?,?,?,?)");
                ps.setString(1, textoClave.getText());
                ps.setString(2, textoNombre.getText());
                ps.setDouble(3, Double.parseDouble(textoPrecio.getText()));
                ps.setInt(4, Integer.parseInt(textoQuantity.getText()));
                ps.setString(5, categorySelection.getItemAt(categorySelection.getSelectedIndex()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registrado correctamente");
                limpiarCajas();
                botonCargarActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un elemento con el mismo nombre");
            }
        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        PreparedStatement ps = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("update itemsproducts set Code=?, Name=?, Cost=?, Quantity=?, Category=? where Code=?");
            ps.setString(1, textoClave.getText());
            ps.setString(2, textoNombre.getText());
            ps.setDouble(3, Double.parseDouble(textoPrecio.getText()));
            ps.setInt(4, Integer.parseInt(textoQuantity.getText()));
            ps.setString(5, categorySelection.getItemAt(categorySelection.getSelectedIndex()));
            ps.setString(6, textoClave.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
            limpiarCajas();
            botonCargarActionPerformed(evt);

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        PreparedStatement ps = null;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("delete from itemsproducts where Code=?");
            ps.setString(1, textoClave.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            limpiarCajas();
            botonCargarActionPerformed(evt);

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprarActionPerformed
        CarritoEmpresa carritoE = new CarritoEmpresa();
        carritoE.setVisible(true);
        dispose();

    }//GEN-LAST:event_botonComprarActionPerformed

    private void carritoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carritoBotonActionPerformed
        Carrito carrito = new Carrito();
        carrito.setVisible(true);
        dispose();
    }//GEN-LAST:event_carritoBotonActionPerformed

    private void botonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOrdenarActionPerformed

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProducto.setModel(modeloTabla);

        String ASC = "select Code, Name, Cost, Quantity, Category from itemsproducts order by Code ASC";
        String DESC = "select Code, Name, Cost, Quantity, Category from itemsproducts order by Code DESC";
        try {
            if (botonOrdenar.getSelectedItem().equals("Ascendente")) {
                ps = conexion.prepareStatement(ASC);
                rs = ps.executeQuery();

                modeloTabla.addColumn("Codigo");
                modeloTabla.addColumn("Nombre");
                modeloTabla.addColumn("Costo");
                modeloTabla.addColumn("Cantidad");
                modeloTabla.addColumn("Categoria");

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidadColumnas = rsMD.getColumnCount();

                int anchos[] = {5, 200, 5, 5, 200};

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

            } else {
                ps = conexion.prepareStatement(DESC);
                rs = ps.executeQuery();

                modeloTabla.addColumn("Codigo");
                modeloTabla.addColumn("Nombre");
                modeloTabla.addColumn("Costo");
                modeloTabla.addColumn("Cantidad");
                modeloTabla.addColumn("Categoria");

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidadColumnas = rsMD.getColumnCount();

                int anchos[] = {5, 200, 5, 5, 200};

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

            }
        } catch (Exception ex) {
            System.out.println("Error, " + ex);

        }
    }//GEN-LAST:event_botonOrdenarActionPerformed

    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        Conexion con = new Conexion();

        try {

            Connection conexion = con.getConnection();
            JasperReport reporte = null;

            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reporte/ReporteVentas.jasper"));

            JasperPrint imprimirReporte = JasperFillManager.fillReport(reporte, null, conexion);

            JasperViewer vistaReporte = new JasperViewer(imprimirReporte, false);

            vistaReporte.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            vistaReporte.setVisible(true);

        } catch (Exception ex) {
            System.out.println("Error, " + ex);
        }
    }//GEN-LAST:event_botonReporteActionPerformed

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed

    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed

    }//GEN-LAST:event_categorySelectionActionPerformed

    public void limpiarCajas() {

        textoQuantity.setText(null);
        textoNombre.setText(null);
        textoPrecio.setText(null);
        textoClave.setText(null);
        cajaBuscar.setText(null);
        categorySelection.setSelectedIndex(0);
    }

    public int repetido(String nombre) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "select count(Code) from itemsproducts where Name = ?";

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
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonCargar;
    private javax.swing.JMenuItem botonComprar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox<String> botonOrdenar;
    private javax.swing.JMenuItem botonReporte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JMenuItem carritoBoton;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JMenu comprarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textoClave;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPrecio;
    private javax.swing.JTextField textoQuantity;
    // End of variables declaration//GEN-END:variables
}
