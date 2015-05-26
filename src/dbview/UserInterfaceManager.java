/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbview;

import database.SqlPersistence;
import database.entities.Accounts;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Manuel
 */
public class UserInterfaceManager {
    public static final int UPDATE = 0;
    public static final int INSERT = 1;
    
    private Form form;
    private BDViewerCore tableHandler;
    private Accounts targetAccount;
    
    public UserInterfaceManager(Form form) {
        this.form = form;
        tableHandler = form.getTableHandler();
    }
    
    public void sendData(int operation, Accounts account) {
        SqlPersistence persistence = tableHandler.getSqlPersistence();
        
        if(!persistence.currentTransactionExists())
           persistence.newTransaction();
        
        if (targetAccount != null) {
            switch(operation) {
                case UPDATE:
                    targetAccount.setActive(account.getActive());
                    if(validateName(account.getAccountName()))
                        targetAccount.setAccountName(account.getAccountName());
                    if(validateEmail(account.getEmail()))
                        targetAccount.setEmail(account.getEmail());
                    targetAccount.setActive(account.getActive());
                    break;
                case INSERT:
                    if(!validateName(account.getAccountName())) {
                        JOptionPane.showMessageDialog(form, "Nombre vacío o no válido");
                        return;
                    }
                    if(!validateEmail(account.getEmail())) {
                        JOptionPane.showMessageDialog(form, "Email vacío o no válido");
                        return;
                    }
                    targetAccount.setActive(account.getActive());
                    targetAccount.setActive(account.getActive());
                    targetAccount.setLastIp("N/A");
                    targetAccount.setOnline(false);
                    break;
            }
            persistence.persist(targetAccount);
        }
        
    }
    
    public void search(String searchField) {
        List<Accounts> accounts = tableHandler.getSqlPersistence().getAccountsItems();
        for(Accounts i: accounts) {
            if(i.getAccountName().equals(searchField)) targetAccount = i;
            System.out.println(i.getAccountName().equals(searchField));
        }
    }
    
    public void setTargetAccount(Accounts account) {
        targetAccount = account;
    }
    
    public Accounts getTargetAccount() {
        return targetAccount;
    }
    
    public boolean validateEmail(String string) {
        return !string.isEmpty() && string.length() < 30;
    }
    
    public boolean validateName(String string) {
        return !string.isEmpty();
    }
}
