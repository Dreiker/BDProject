/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import database.SqlPersistence;
import dbview.BDViewerCore;
import dbview.UserInterfaceManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Juan Manuel
 */
public class AccountsMouseListener implements MouseListener{
    private BDViewerCore core;
    private JTable table;
    private UserInterfaceManager userManager;
    private SqlPersistence persistence;
    public AccountsMouseListener(BDViewerCore core) {
        this.core = core;
        table = core.getForm().getTable();
        userManager = core.getForm().getUserInterfaceManager();
        persistence = core.getSqlPersistence();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(table.getSelectedColumn() < 7) {
            if(persistence.getCurrentTransaction() == null || !persistence.getCurrentTransaction().isActive())
                persistence.newTransaction();
            userManager.setTargetAccount(core.getSqlPersistence().getAccountsItems()
                    .get(table.getSelectedColumn()));
            
            userManager.setTargetAccount(persistence.getAccountsItems().get(table.getSelectedRow()));
            switch(table.getSelectedColumn()) {
                case 0:
                    userManager.getTargetAccount().setAccountName((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                    persistence.persist(userManager.getTargetAccount());
                    break;
                case 3:
                    userManager.getTargetAccount().setEmail((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                    persistence.persist(userManager.getTargetAccount());
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
