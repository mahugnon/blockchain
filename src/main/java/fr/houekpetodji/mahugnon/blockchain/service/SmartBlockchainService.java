package fr.houekpetodji.mahugnon.blockchain.service;

import fr.houekpetodji.mahugnon.blockchain.dao.SmartBlockchainDao;
import fr.houekpetodji.mahugnon.blockchain.model.SmartBlock;
import fr.houekpetodji.mahugnon.blockchain.model.SmartBlockchain;
import fr.houekpetodji.mahugnon.blockchain.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SmartBlockchainService {
    private List<Transaction> currentTransations = new ArrayList<>();
    @Autowired
    private SmartBlockchainDao smartBlockchainDao;

    public void mine() throws Exception {
        if (this.hasNewTransactions()) {
            SmartBlock block = new SmartBlock(currentTransations, this.lastHash());
            smartBlockchainDao.newBlock(block);
            currentTransations = new ArrayList<>();
        } else {
            throw new Exception("You must add transaction before mine");
        }


    }

    /**
     * Create new transation and add it to the transaction list. This list will be used to create the new block
     *
     * @param transaction the new transaction
     *
     */
    public Transaction newTransaction(Transaction transaction) throws UnknownHostException {

        currentTransations.add(transaction);
        return transaction;
    }
    /**
     * Return the last hash value.
     * */
    public String lastHash() {
        try {
            return smartBlockchainDao.getSmartBlockchain().lastBlock().getHash();
        } catch (Exception e) {
           return e.getMessage();
        }
    }
/**
 * test if a transaction is added
 * */
    private boolean hasNewTransactions() {
        return !currentTransations.isEmpty();
    }

/**
 * Return all the blocks of the blockchain
 * */
    public SmartBlockchain getChain() {
        return  smartBlockchainDao.getSmartBlockchain();
    }


}
