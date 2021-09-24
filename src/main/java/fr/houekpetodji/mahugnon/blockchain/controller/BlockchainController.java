package fr.houekpetodji.mahugnon.blockchain.controller;

import fr.houekpetodji.mahugnon.blockchain.model.SmartBlock;
import fr.houekpetodji.mahugnon.blockchain.model.Transaction;
import fr.houekpetodji.mahugnon.blockchain.service.SmartBlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlockchainController {
    @Autowired
SmartBlockchainService smartBlockchainService;

    /**
     * Apo to create a new block and add it to the server blockchain
     */
    @GetMapping(value = "/mine")
    @ResponseBody
    public ResponseEntity<String> mine()  {
        try {
            this.smartBlockchainService.mine();
            return new ResponseEntity<>("A new block is successfully mined", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    /**
     *Apo to add new transaction
     */
    @PostMapping(value = "/transactions/new")
    public ResponseEntity<String> newTransaction(@RequestBody Transaction transaction) {
      try {
          this.smartBlockchainService.newTransaction(transaction);
          return new ResponseEntity<>("The new transaction  is successfully mined", HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
      }
    }
/**
 * Api to fetch the blockchain
 * */
    @GetMapping(value = "/chain")
    @ResponseBody
    public List<SmartBlock> fullChain() {
        return smartBlockchainService.getChain();
    }


}
