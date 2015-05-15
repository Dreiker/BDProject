package dbview;

import database.SqlConnection;
import database.SqlPersistence;
import java.sql.ResultSet;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import renderers.CountryRenderer;
import renderers.OnlineRenderer;

public class TableHandler {
    public static final byte ACCOUNTS = 0;
    public static final byte ACCOUNT_BAN = 1;
    public static final byte SERVERS = 2;
    public static final byte PERMISSIONS = 3;
    
    private TableModel model;
    private Form form;
    private final SqlConnection SQL_CONNECTION = new SqlConnection("authentication");
    private final SqlPersistence SQL_PERSISTENCE = new SqlPersistence();
    private int selectedTable = -1;
    
    public TableHandler(Form form) {
        this.form = form;
    }
    
    public void setTable(int table) {
        selectedTable = table;
        model = new TableModel(this);
        switch(table) {
            case ACCOUNTS:
                SQL_PERSISTENCE.setAccountTable(model);
                form.getTable().setModel(model);
//                tableSelected = ACCOUNTS;
//                ResultSet rs1 = connection.getData("SELECT * FROM accounts");
//                connection.loadTable(model, rs1);
//                form.getTable().setModel(model);
                form.getTable().getColumnModel().getColumn(5).setCellRenderer(new OnlineRenderer());
//                setMode(Mode.READ);
                break;
            case ACCOUNT_BAN:
                SQL_PERSISTENCE.setAccountBanTable(model);
                form.getTable().setModel(model);
//                tableSelected = ACCOUNT_BAN;
//                ResultSet rs2 = connection.getData("SELECT * FROM account_ban");
//                connection.loadTable(model, rs2);
//                form.getTable().setModel(model);
//                setMode(Mode.READ);
                break;
            case SERVERS:
                SQL_PERSISTENCE.setServerTable(model);
                form.getTable().setModel(model);
//                tableSelected = SERVERS;
//                ResultSet rs3 = connection.getData("SELECT * FROM servers");
//                connection.loadTable(model, rs3);
//                form.getTable().setModel(model);
                form.getTable().getColumnModel().getColumn(2).setCellRenderer(new CountryRenderer());
                break;
            case PERMISSIONS:
                selectedTable = PERMISSIONS;
                ResultSet rs4 = SQL_CONNECTION.getData("SELECT * FROM special_permissions");
                SQL_CONNECTION.loadTable(model, rs4);
                form.getTable().setModel(model);

                JComboBox combo = new JComboBox();
                combo.addItem("0 - Moderator");
                combo.addItem("1 - Admin");
                combo.addItem("2 - Superadmin");
                form.getTable().getColumn("permission_level").setCellEditor(new DefaultCellEditor(combo));
                break;
        }
    }
    
    public void query(String string) {
        model = new TableModel(this);
        SQL_CONNECTION.loadTable(model, SQL_CONNECTION.getData(string));
        form.getTable().setModel(model);
    }
    
    public void update(int column, int row, String table, String data) {
//        System.out.println("UPDATE " + table
//                + " SET "+ model.getColumnName(column) + " = '" + data + "'"
//                + " WHERE " + model.getColumnName(0) + " = " + form.getTable().getValueAt(row + 1 , 0));  
        SQL_CONNECTION.sendData("UPDATE " + table
                + " SET "+ model.getColumnName(column) + " = '" + data + "'"
                + " WHERE " + model.getColumnName(0) + " = " + form.getTable().getValueAt(row + 1, 0));
    }
    
    public int getSelectedTable() {
        return selectedTable;
    }
    
    public SqlConnection getSqlConnection() {
        return SQL_CONNECTION;
    }
    
    public SqlPersistence getSqlPersistence() {
        return SQL_PERSISTENCE;
    }
    
    public Form getForm() {
        return form;
    }
    
}
