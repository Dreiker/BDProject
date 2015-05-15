package database;

import dbview.TableModel;
import dbview.Configuration;
import dbview.TableHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SqlConnection {
    private static final Logger LOGGER = Logger.getLogger(SqlConnection.class.getName());
    private Statement stmt;
    
    public SqlConnection(String database) {
        LOGGER.addHandler(Configuration.consoleHandler);
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + database, "root", "");
            stmt = con.createStatement();
            LOGGER.finest("Conexión establecida.");
        } catch (Exception  e) {
            String msg = "No se ha podido establecer la conexión con la base de datos.";
            LOGGER.severe(msg);
            Runnable jOptionPane = () -> { JOptionPane.showMessageDialog(null, msg); };
            new Thread(jOptionPane).start();
        } 
    }
    
    public ResultSet getData(String string) {
            ResultSet rs = null;
        try {
            rs = stmt.executeQuery(string);
        } catch (SQLException ex) {
            LOGGER.severe("No se han podido extraer los datos de la base de datos.");
        }
            return rs;
    }
    
    public void sendData(String string) {
        try {
            stmt.executeUpdate(string);
        } catch (SQLException ex) {
            LOGGER.severe("Error al ejecutar la actualización de base de datos.");
        }
    }
    
    public void loadTable(TableModel model, ResultSet rs) {
        try {
            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++)
                model.addColumn(rs.getMetaData().getColumnName(i));
            while(rs.next()) {
                Object[] data = new Object[rs.getMetaData().getColumnCount()];
                for(int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
                    Object aux = rs.getObject(i);
                    if(aux != null) data[i - 1] = rs.getObject(i);
                    else if(aux == null) data[i - 1] = "";
                    System.out.println(aux);
                }
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
