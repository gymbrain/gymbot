package ir.gymbot.service;

import ir.gymbot.service.dto.SymbolDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link ir.gymbot.domain.Symbol}.
 */
public interface SymbolService {
    /**
     * Save a symbol.
     *
     * @param symbolDTO the entity to save.
     * @return the persisted entity.
     */
    SymbolDTO save(SymbolDTO symbolDTO);

    /**
     * Updates a symbol.
     *
     * @param symbolDTO the entity to update.
     * @return the persisted entity.
     */
    SymbolDTO update(SymbolDTO symbolDTO);

    /**
     * Partially updates a symbol.
     *
     * @param symbolDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SymbolDTO> partialUpdate(SymbolDTO symbolDTO);

    /**
     * Get all the symbols.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SymbolDTO> findAll(Pageable pageable);

    /**
     * Get the "id" symbol.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SymbolDTO> findOne(Long id);

    /**
     * Delete the "id" symbol.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the symbol corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SymbolDTO> search(String query, Pageable pageable);
}
