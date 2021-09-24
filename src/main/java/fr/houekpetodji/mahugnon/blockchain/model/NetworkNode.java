package fr.houekpetodji.mahugnon.blockchain.model;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.UUID;

public class NetworkNode implements Serializable {
    private Integer nodeId;
    private String ip;

    public NetworkNode(Integer nodeId, String ip) {
        this.nodeId = nodeId;
        this.ip = ip;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public String getIp() {
        return ip;
    }
}
