
package fr.houekpetodji.mahugnon.blockchain.model;

import com.google.common.hash.Hashing;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class SmartBlock {
    @Id
    @GeneratedValue(generator = "UUID")
private UUID blockId;
private Date timestamp;
@OneToMany
@JoinColumn(name = "transactions")
private  List<Transaction> transactions;
private String previousHash;
private  String hash;
    public SmartBlock(List<Transaction> transactions, String previousHash) {

        this.timestamp = new Date();
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.hash = this.hash();
    }

    public SmartBlock() {

    }

    public UUID getBlockId() {
        return blockId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }
    private  String hash(){
        String sha256hex = Hashing.sha256()
                .hashString(this.toString(), StandardCharsets.UTF_8)
                .toString();
      return  sha256hex;
    }

    @Override
    public String toString() {
        String transactionsString;
        transactionsString = "[\n";
        for (Transaction tr : transactions) transactionsString = transactionsString + tr.toString() + "\n";
        transactionsString = transactionsString+"]";
        return new StringBuilder().append("{").append("index=").append(blockId).append(", timestamp=").append(timestamp).append(", transactions:").append(transactionsString).append(", previousHash:'").append(previousHash).append('\'').append('}').toString();
    }

    public String getHash() {
        return hash;
    }
}
