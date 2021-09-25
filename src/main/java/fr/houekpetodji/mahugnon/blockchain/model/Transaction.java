package fr.houekpetodji.mahugnon.blockchain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID transactionId;

    private  String sender;
    private  String receiver;
    private Double value;
    private String producerInfo;

    public Transaction() throws UnknownHostException {
producerInfo = InetAddress.getLocalHost().getHostAddress().toString();
    }



    public Transaction(String sender, String receiver, Double value) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;

    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "sender:'" + sender + '\'' +
                ", receiver:'" + receiver + '\'' +
                ", value:" + value +
                '}';
    }
}
