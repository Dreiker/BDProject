/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dbview;

import database.SqlPersistence;
import database.entities.Accounts;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    private boolean editable = true;
    private ArrayList<String> columns = new ArrayList<String>();
    private ArrayList<Object[]> data = new ArrayList<Object[]>();
    private TableHandler tableHandler;
    private SqlPersistence sqlPersistence;
    public TableModel(TableHandler tableHandler) {
        this.tableHandler = tableHandler;
        sqlPersistence = tableHandler.getSqlPersistence();
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        switch(tableHandler.getSelectedTable()) {
            case TableHandler.ACCOUNTS:
            if(column == 2) return false;
            if(column == 5) return false;
        }
        return editable;
    }
    
    
    @Override
    public int getColumnCount() {
        return columns.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        return data.get(row)[column];
    }
    
    @Override
    public Class getColumnClass(int column) {
        return (getValueAt(0, column).getClass());
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        switch(tableHandler.getSelectedTable()) {
            case TableHandler.ACCOUNTS:
                Accounts account = sqlPersistence.getAccountsItems().get(row);
                if(column == 0) account.setAccountName(String.valueOf(value));
                else if(column == 1) account.setMd5PassHash(String.valueOf(value));
                break;
            case TableHandler.ACCOUNT_BAN:
                sqlPersistence.getAccountsItems().get(row);
                break;
            case TableHandler.SERVERS:
                sqlPersistence.getAccountsItems().get(row);
                break;
        }
        
        data.get(row)[column] = value;
    }
    
    public void setEditable(boolean b) {
        editable = b;
    }
    
    public void addColumn(String column) {
        this.columns.add(column);
    }
    
    public void addRow(Object[] rowData) {
        this.data.add(rowData);
    }
}
