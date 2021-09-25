package fr.houekpetodji.mahugnon.blockchain.repositories;

import fr.houekpetodji.mahugnon.blockchain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository  extends JpaRepository<Transaction, UUID> {
}
