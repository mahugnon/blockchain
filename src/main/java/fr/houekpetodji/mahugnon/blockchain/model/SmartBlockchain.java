package fr.houekpetodji.mahugnon.blockchain.model;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmartBlockchain implements Serializable {
    private List<SmartBlock> chaine;
    public SmartBlockchain() {
    }

    /**
     * Create the root block of the blockchain. This root block has no previous hash
     */
    private void createGenesis() {
        chaine = new ArrayList<>();
        chaine.add(new SmartBlock( new ArrayList<Transaction>(), ""));
    }

    /**
     * Create a new block and add it to the block chaine
     *
     * @param block The block to be add
     */
    public SmartBlock newBlock(SmartBlock block) {


        this.chaine.add(block);

        return block;
    }


    public SmartBlock lastBlock(){
      return   this.chaine.get(this.chaine.size()-1);
    }

    public List<SmartBlock> getChaine() {
        if (chaine==null) {
            this.createGenesis();
        }
        return chaine;
    }



}
