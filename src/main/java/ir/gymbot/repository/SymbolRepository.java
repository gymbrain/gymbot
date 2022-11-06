package ir.gymbot.repository;

import ir.gymbot.domain.Symbol;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Symbol entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long>, JpaSpecificationExecutor<Symbol> {}
