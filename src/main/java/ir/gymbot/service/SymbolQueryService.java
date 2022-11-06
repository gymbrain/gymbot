package ir.gymbot.service;

import ir.gymbot.domain.*; // for static metamodels
import ir.gymbot.domain.Symbol;
import ir.gymbot.repository.SymbolRepository;
import ir.gymbot.repository.search.SymbolSearchRepository;
import ir.gymbot.service.criteria.SymbolCriteria;
import ir.gymbot.service.dto.SymbolDTO;
import ir.gymbot.service.mapper.SymbolMapper;
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
 * Service for executing complex queries for {@link Symbol} entities in the database.
 * The main input is a {@link SymbolCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SymbolDTO} or a {@link Page} of {@link SymbolDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SymbolQueryService extends QueryService<Symbol> {

    private final Logger log = LoggerFactory.getLogger(SymbolQueryService.class);

    private final SymbolRepository symbolRepository;

    private final SymbolMapper symbolMapper;

    private final SymbolSearchRepository symbolSearchRepository;

    public SymbolQueryService(SymbolRepository symbolRepository, SymbolMapper symbolMapper, SymbolSearchRepository symbolSearchRepository) {
        this.symbolRepository = symbolRepository;
        this.symbolMapper = symbolMapper;
        this.symbolSearchRepository = symbolSearchRepository;
    }

    /**
     * Return a {@link List} of {@link SymbolDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SymbolDTO> findByCriteria(SymbolCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Symbol> specification = createSpecification(criteria);
        return symbolMapper.toDto(symbolRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SymbolDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SymbolDTO> findByCriteria(SymbolCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Symbol> specification = createSpecification(criteria);
        return symbolRepository.findAll(specification, page).map(symbolMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SymbolCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Symbol> specification = createSpecification(criteria);
        return symbolRepository.count(specification);
    }

    /**
     * Function to convert {@link SymbolCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Symbol> createSpecification(SymbolCriteria criteria) {
        Specification<Symbol> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Symbol_.id));
            }
            if (criteria.getSymbol() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSymbol(), Symbol_.symbol));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Symbol_.name));
            }
            if (criteria.getBaseCurrency() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBaseCurrency(), Symbol_.baseCurrency));
            }
            if (criteria.getQuoteCurrency() != null) {
                specification = specification.and(buildStringSpecification(criteria.getQuoteCurrency(), Symbol_.quoteCurrency));
            }
            if (criteria.getFeeCurrency() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeCurrency(), Symbol_.feeCurrency));
            }
            if (criteria.getMarket() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMarket(), Symbol_.market));
            }
            if (criteria.getBaseMinSize() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBaseMinSize(), Symbol_.baseMinSize));
            }
            if (criteria.getQuoteMinSize() != null) {
                specification = specification.and(buildStringSpecification(criteria.getQuoteMinSize(), Symbol_.quoteMinSize));
            }
            if (criteria.getBaseMaxSize() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBaseMaxSize(), Symbol_.baseMaxSize));
            }
            if (criteria.getQuoteMaxSize() != null) {
                specification = specification.and(buildStringSpecification(criteria.getQuoteMaxSize(), Symbol_.quoteMaxSize));
            }
            if (criteria.getBaseIncrement() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBaseIncrement(), Symbol_.baseIncrement));
            }
            if (criteria.getQuoteIncrement() != null) {
                specification = specification.and(buildStringSpecification(criteria.getQuoteIncrement(), Symbol_.quoteIncrement));
            }
            if (criteria.getPriceIncrement() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPriceIncrement(), Symbol_.priceIncrement));
            }
            if (criteria.getPriceLimitRate() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPriceLimitRate(), Symbol_.priceLimitRate));
            }
            if (criteria.getMinFunds() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMinFunds(), Symbol_.minFunds));
            }
            if (criteria.getIsMarginEnabled() != null) {
                specification = specification.and(buildSpecification(criteria.getIsMarginEnabled(), Symbol_.isMarginEnabled));
            }
            if (criteria.getEnableTrading() != null) {
                specification = specification.and(buildSpecification(criteria.getEnableTrading(), Symbol_.enableTrading));
            }
            if (criteria.getActive() != null) {
                specification = specification.and(buildSpecification(criteria.getActive(), Symbol_.active));
            }
        }
        return specification;
    }
}
