package ir.gymbot.service;

import ir.gymbot.service.dto.KlineDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link ir.gymbot.domain.Kline}.
 */
public interface KlineService {
    /**
     * Save a kline.
     *
     * @param klineDTO the entity to save.
     * @return the persisted entity.
     */
    KlineDTO save(KlineDTO klineDTO);

    /**
     * Updates a kline.
     *
     * @param klineDTO the entity to update.
     * @return the persisted entity.
     */
    KlineDTO update(KlineDTO klineDTO);

    /**
     * Partially updates a kline.
     *
     * @param klineDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<KlineDTO> partialUpdate(KlineDTO klineDTO);

    /**
     * Get all the klines.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<KlineDTO> findAll(Pageable pageable);

    /**
     * Get all the klines with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<KlineDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" kline.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<KlineDTO> findOne(Long id);

    /**
     * Delete the "id" kline.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the kline corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<KlineDTO> search(String query, Pageable pageable);
}
