package ir.gymbot.service;

import ir.gymbot.domain.*; // for static metamodels
import ir.gymbot.domain.Kline;
import ir.gymbot.repository.KlineRepository;
import ir.gymbot.repository.search.KlineSearchRepository;
import ir.gymbot.service.criteria.KlineCriteria;
import ir.gymbot.service.dto.KlineDTO;
import ir.gymbot.service.mapper.KlineMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Kline} entities in the database.
 * The main input is a {@link KlineCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link KlineDTO} or a {@link Page} of {@link KlineDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class KlineQueryService extends QueryService<Kline> {

    private final Logger log = LoggerFactory.getLogger(KlineQueryService.class);

    private final KlineRepository klineRepository;

    private final KlineMapper klineMapper;

    private final KlineSearchRepository klineSearchRepository;

    public KlineQueryService(KlineRepository klineRepository, KlineMapper klineMapper, KlineSearchRepository klineSearchRepository) {
        this.klineRepository = klineRepository;
        this.klineMapper = klineMapper;
        this.klineSearchRepository = klineSearchRepository;
    }

    /**
     * Return a {@link List} of {@link KlineDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<KlineDTO> findByCriteria(KlineCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Kline> specification = createSpecification(criteria);
        return klineMapper.toDto(klineRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link KlineDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<KlineDTO> findByCriteria(KlineCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Kline> specification = createSpecification(criteria);
        return klineRepository.findAll(specification, page).map(klineMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(KlineCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Kline> specification = createSpecification(criteria);
        return klineRepository.count(specification);
    }

    /**
     * Function to convert {@link KlineCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Kline> createSpecification(KlineCriteria criteria) {
        Specification<Kline> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Kline_.id));
            }
            if (criteria.getTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTime(), Kline_.time));
            }
            if (criteria.getOpen() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOpen(), Kline_.open));
            }
            if (criteria.getClose() != null) {
                specification = specification.and(buildStringSpecification(criteria.getClose(), Kline_.close));
            }
            if (criteria.getHigh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHigh(), Kline_.high));
            }
            if (criteria.getLow() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLow(), Kline_.low));
            }
            if (criteria.getVolume() != null) {
                specification = specification.and(buildStringSpecification(criteria.getVolume(), Kline_.volume));
            }
            if (criteria.getTurnover() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTurnover(), Kline_.turnover));
            }
            if (criteria.getTimeType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTimeType(), Kline_.timeType));
            }
            if (criteria.getSymbolId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getSymbolId(), root -> root.join(Kline_.symbol, JoinType.LEFT).get(Symbol_.id))
                    );
            }
        }
        return specification;
    }
}
