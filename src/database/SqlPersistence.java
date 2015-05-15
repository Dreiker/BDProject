package database;

import database.entities.AccountBan;
import database.entities.Accounts;
import database.entities.Servers;
import dbview.TableModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SqlPersistence {
    
    private List<Accounts> accounts;
    private List<AccountBan> bans;
    private List<Servers> servers;
    
    EntityManager entityManager = Persistence
            .createEntityManagerFactory("DBViewPU")
            .createEntityManager();
    
    /** Sets a specified table model with the information of the accounts
    * loaded from the database */
    public void setAccountTable(TableModel model) {
        Query query = entityManager.createNamedQuery("Accounts.findAll");
        accounts = query.getResultList();
        
        model.addColumn("AccountName");
        model.addColumn("Md5PassHash");
        model.addColumn("CreationDate");
        model.addColumn("Email");
        model.addColumn("LastIP");
        model.addColumn("online");
        model.addColumn("LastLogin");
        model.addColumn("Active");
        
        for(Accounts a: accounts) {
           Object[] data = new Object[8];
           data[0] = a.getAccountName();
           data[1] = a.getMd5PassHash();
           data[2] = a.getCreationDate();
           data[3] = a.getEmail();
           data[4] = a.getLastIp();
           data[5] = a.getOnline();
           data[6] = a.getLastLogin();
           data[7] = a.getActive();
           model.addRow(data);
        }
    }
    
    /** Sets a specified table model with the information of the account bans
     * loaded from the database */
    public void setAccountBanTable(TableModel model) {
        Query query = entityManager.createNamedQuery("AccountBan.findAll");
        bans = query.getResultList();
        
        model.addColumn("AccountName");
        model.addColumn("Description");
        model.addColumn("BanDate");
        model.addColumn("BanFinish");
        
        for(AccountBan b: bans) {
            Object[] data = new Object[4];
            
            data[0] = b.getAccountId().getAccountName();
            data[1] = b.getDescription();
            data[2] = b.getBanDate();
            data[3] = b.getBanFinish();
            model.addRow(data);
        }
    }
    /** Sets a specified table model with the information of the servers
     * loaded from the database */
    public void setServerTable(TableModel model) {
        Query query = entityManager.createNamedQuery("Servers.findAll");
        servers = query.getResultList();
        
        model.addColumn("ServerName");
        model.addColumn("ServerIp");
        model.addColumn("Location");
        model.addColumn("TimeZone");
        
        for(Servers s: servers) {
            Object[] data = new Object[4];
            data[0] = s.getServerName();
            data[1] = s.getTimeZone();
            data[2] = s.getLocation();
            data[3] = s.getServerIp();
            model.addRow(data);
        }
    }
    
    /** Gets the server items loaded from the database. */
    public List<Servers> getServerItems() {
        return servers;
    }
    
    /** Gets the account ban items loaded from the database. */
    public List<AccountBan> getBanItems() {
        return bans;
    }
    
    /** Gets the accounts items loaded from the database.
     * @return  */
    public List<Accounts> getAccountsItems() {
        return accounts;
    }
}