package fr.houekpetodji.mahugnon.blockchain.dao;

import fr.houekpetodji.mahugnon.blockchain.model.SmartBlock;
import fr.houekpetodji.mahugnon.blockchain.model.SmartBlockchain;
import fr.houekpetodji.mahugnon.blockchain.repositories.SmartBlockchainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmartBlockchainDao {
    @Autowired
    private SmartBlockchainRepository smartBlockchainRepository;
    private SmartBlockchain smartBlockchain;
    @Autowired
    private SmartBlockDao smartBlockDao;

    /**
     * This all to get the blockchain from database.
     * As it is often used, it is store in an instance variable
     */
    public SmartBlockchain getSmartBlockchain() {
        if (smartBlockchain == null) {
            this.fetchSmartBlockchain();
        }
        return smartBlockchain;
    }

    /**
     * Save a new block in the blockchain
     *
     * @param block the block to add
     */
    public void newBlock(SmartBlock block) {

        this.getSmartBlockchain().newBlock(smartBlockDao.newBlock(block));
        smartBlockchainRepository.save(this.getSmartBlockchain());
    }

    /**
     * Get a fresh smartBlockchaine from the database
     */
    private void fetchSmartBlockchain() {
        List<SmartBlockchain> smartBlockchains = smartBlockchainRepository.findAll();
        if (smartBlockchains.isEmpty()) {
            smartBlockchain = smartBlockchainRepository.save(new SmartBlockchain());
        } else {
            smartBlockchain = smartBlockchains.get(0);
        }
    }
}
