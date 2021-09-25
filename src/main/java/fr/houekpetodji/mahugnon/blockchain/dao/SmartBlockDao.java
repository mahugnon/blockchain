package fr.houekpetodji.mahugnon.blockchain.dao;

import fr.houekpetodji.mahugnon.blockchain.model.SmartBlock;
import fr.houekpetodji.mahugnon.blockchain.repositories.SmartBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmartBlockDao {
    @Autowired
    SmartBlockRepository smartBlockRepository;

    /**
     *
     * Save a new block to the database
     * @param block  the block to persist
     * */
    public SmartBlock newBlock(SmartBlock block) {
       return smartBlockRepository.save(block);
    }
}
