package fr.houekpetodji.mahugnon.blockchain.dao;

import fr.houekpetodji.mahugnon.blockchain.model.SmartBlockchain;
import org.springframework.stereotype.Component;

@Component
public class SmartBlockchainDao {
  private SmartBlockchain smartBlockchain;

    public SmartBlockchainDao() {
        this.smartBlockchain = new SmartBlockchain();
    }
    public  SmartBlockchain getSmartBlockchain(){
        return  this.smartBlockchain;
    }
}
