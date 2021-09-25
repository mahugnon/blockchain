package fr.houekpetodji.mahugnon.blockchain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class SmartBlockchain implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID smartBlockchainId;
    @OneToMany
    @JoinColumn(name = "blocks")
    private List<SmartBlock> chaines;
    public SmartBlockchain() {
    }

    /**
     * Create the root block of the blockchain. This root block has no previous hash
     */
    private void createGenesis() {
        chaines = new ArrayList<>();
        chaines.add(new SmartBlock( new ArrayList<Transaction>(), ""));
    }

    /**
     * Create a new block and add it to the block chaine
     *
     * @param block The block to be add
     */
    public SmartBlock newBlock(SmartBlock block) {


        this.chaines.add(block);

        return block;
    }


    public SmartBlock lastBlock() throws Exception{
      return   this.chaines.get(this.chaines.size()-1);
    }

    public List<SmartBlock> getChaines() {
        if (chaines ==null) {
            this.createGenesis();
        }
        return chaines;
    }



}
