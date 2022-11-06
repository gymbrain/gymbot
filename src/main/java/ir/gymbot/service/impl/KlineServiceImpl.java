package ir.gymbot.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.*;

import ir.gymbot.domain.Kline;
import ir.gymbot.repository.KlineRepository;
import ir.gymbot.repository.search.KlineSearchRepository;
import ir.gymbot.service.KlineService;
import ir.gymbot.service.dto.KlineDTO;
import ir.gymbot.service.mapper.KlineMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Kline}.
 */
@Service
@Transactional
public class KlineServiceImpl implements KlineService {

    private final Logger log = LoggerFactory.getLogger(KlineServiceImpl.class);

    private final KlineRepository klineRepository;

    private final KlineMapper klineMapper;

    private final KlineSearchRepository klineSearchRepository;

    public KlineServiceImpl(KlineRepository klineRepository, KlineMapper klineMapper, KlineSearchRepository klineSearchRepository) {
        this.klineRepository = klineRepository;
        this.klineMapper = klineMapper;
        this.klineSearchRepository = klineSearchRepository;
    }

    @Override
    public KlineDTO save(KlineDTO klineDTO) {
        log.debug("Request to save Kline : {}", klineDTO);
        Kline kline = klineMapper.toEntity(klineDTO);
        kline = klineRepository.save(kline);
        KlineDTO result = klineMapper.toDto(kline);
        klineSearchRepository.index(kline);
        return result;
    }

    @Override
    public KlineDTO update(KlineDTO klineDTO) {
        log.debug("Request to update Kline : {}", klineDTO);
        Kline kline = klineMapper.toEntity(klineDTO);
        kline = klineRepository.save(kline);
        KlineDTO result = klineMapper.toDto(kline);
        klineSearchRepository.index(kline);
        return result;
    }

    @Override
    public Optional<KlineDTO> partialUpdate(KlineDTO klineDTO) {
        log.debug("Request to partially update Kline : {}", klineDTO);

        return klineRepository
            .findById(klineDTO.getId())
            .map(existingKline -> {
                klineMapper.partialUpdate(existingKline, klineDTO);

                return existingKline;
            })
            .map(klineRepository::save)
            .map(savedKline -> {
                klineSearchRepository.save(savedKline);

                return savedKline;
            })
            .map(klineMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<KlineDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Klines");
        return klineRepository.findAll(pageable).map(klineMapper::toDto);
    }

    public Page<KlineDTO> findAllWithEagerRelationships(Pageable pageable) {
        return klineRepository.findAllWithEagerRelationships(pageable).map(klineMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<KlineDTO> findOne(Long id) {
        log.debug("Request to get Kline : {}", id);
        return klineRepository.findOneWithEagerRelationships(id).map(klineMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Kline : {}", id);
        klineRepository.deleteById(id);
        klineSearchRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<KlineDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Klines for query {}", query);
        return klineSearchRepository.search(query, pageable).map(klineMapper::toDto);
    }
}
