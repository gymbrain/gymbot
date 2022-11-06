package ir.gymbot.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.*;

import com.kucoin.sdk.KucoinClientBuilder;
import com.kucoin.sdk.KucoinRestClient;
import com.kucoin.sdk.rest.response.SymbolResponse;
import ir.gymbot.domain.Symbol;
import ir.gymbot.repository.SymbolRepository;
import ir.gymbot.repository.search.SymbolSearchRepository;
import ir.gymbot.service.SymbolService;
import ir.gymbot.service.dto.SymbolDTO;
import ir.gymbot.service.mapper.SymbolMapper;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Symbol}.
 */
@Service
@Transactional
public class SymbolServiceImpl implements SymbolService {

    private final Logger log = LoggerFactory.getLogger(SymbolServiceImpl.class);

    private final SymbolRepository symbolRepository;

    private final SymbolMapper symbolMapper;

    private final SymbolSearchRepository symbolSearchRepository;

    public SymbolServiceImpl(SymbolRepository symbolRepository, SymbolMapper symbolMapper, SymbolSearchRepository symbolSearchRepository) {
        this.symbolRepository = symbolRepository;
        this.symbolMapper = symbolMapper;
        this.symbolSearchRepository = symbolSearchRepository;
    }

    @Override
    public SymbolDTO save(SymbolDTO symbolDTO) {
        log.debug("Request to save Symbol : {}", symbolDTO);
        Symbol symbol = symbolMapper.toEntity(symbolDTO);
        symbol = symbolRepository.save(symbol);
        SymbolDTO result = symbolMapper.toDto(symbol);
        symbolSearchRepository.index(symbol);
        return result;
    }

    @Override
    public SymbolDTO update(SymbolDTO symbolDTO) {
        log.debug("Request to update Symbol : {}", symbolDTO);
        Symbol symbol = symbolMapper.toEntity(symbolDTO);
        symbol = symbolRepository.save(symbol);
        SymbolDTO result = symbolMapper.toDto(symbol);
        symbolSearchRepository.index(symbol);
        return result;
    }

    @Override
    public Optional<SymbolDTO> partialUpdate(SymbolDTO symbolDTO) {
        log.debug("Request to partially update Symbol : {}", symbolDTO);

        return symbolRepository
            .findById(symbolDTO.getId())
            .map(existingSymbol -> {
                symbolMapper.partialUpdate(existingSymbol, symbolDTO);

                return existingSymbol;
            })
            .map(symbolRepository::save)
            .map(savedSymbol -> {
                symbolSearchRepository.save(savedSymbol);

                return savedSymbol;
            })
            .map(symbolMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SymbolDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Symbols");
        return symbolRepository.findAll(pageable).map(symbolMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SymbolDTO> findOne(Long id) {
        log.debug("Request to get Symbol : {}", id);
        return symbolRepository.findById(id).map(symbolMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Symbol : {}", id);
        symbolRepository.deleteById(id);
        symbolSearchRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SymbolDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Symbols for query {}", query);
        return symbolSearchRepository.search(query, pageable).map(symbolMapper::toDto);
    }

    @Scheduled(initialDelay = 1, fixedRate = 1000 * 60 * 60 * 24 * 7)
    public void getSymbols() throws IOException {
        KucoinClientBuilder builder = new KucoinClientBuilder().withBaseUrl("https://openapi-v2.kucoin.com");
        KucoinRestClient kucoinRestClient = builder.buildRestClient();
        List<SymbolResponse> symbols = kucoinRestClient.symbolAPI().getSymbols();
        System.out.println(symbols);
    }
}
