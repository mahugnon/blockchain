package fr.houekpetodji.mahugnon.blockchain.repositories;

import fr.houekpetodji.mahugnon.blockchain.model.SmartBlock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SmartBlockRepository extends JpaRepository<SmartBlock, UUID> {
}
