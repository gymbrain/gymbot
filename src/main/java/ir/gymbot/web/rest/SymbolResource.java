package ir.gymbot.web.rest;

import static org.elasticsearch.index.query.QueryBuilders.*;

import ir.gymbot.repository.SymbolRepository;
import ir.gymbot.service.SymbolQueryService;
import ir.gymbot.service.SymbolService;
import ir.gymbot.service.criteria.SymbolCriteria;
import ir.gymbot.service.dto.SymbolDTO;
import ir.gymbot.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ir.gymbot.domain.Symbol}.
 */
@RestController
@RequestMapping("/api")
public class SymbolResource {

    private final Logger log = LoggerFactory.getLogger(SymbolResource.class);

    private static final String ENTITY_NAME = "symbol";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SymbolService symbolService;

    private final SymbolRepository symbolRepository;

    private final SymbolQueryService symbolQueryService;

    public SymbolResource(SymbolService symbolService, SymbolRepository symbolRepository, SymbolQueryService symbolQueryService) {
        this.symbolService = symbolService;
        this.symbolRepository = symbolRepository;
        this.symbolQueryService = symbolQueryService;
    }

    /**
     * {@code POST  /symbols} : Create a new symbol.
     *
     * @param symbolDTO the symbolDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new symbolDTO, or with status {@code 400 (Bad Request)} if the symbol has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/symbols")
    public ResponseEntity<SymbolDTO> createSymbol(@Valid @RequestBody SymbolDTO symbolDTO) throws URISyntaxException {
        log.debug("REST request to save Symbol : {}", symbolDTO);
        if (symbolDTO.getId() != null) {
            throw new BadRequestAlertException("A new symbol cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SymbolDTO result = symbolService.save(symbolDTO);
        return ResponseEntity
            .created(new URI("/api/symbols/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /symbols/:id} : Updates an existing symbol.
     *
     * @param id the id of the symbolDTO to save.
     * @param symbolDTO the symbolDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated symbolDTO,
     * or with status {@code 400 (Bad Request)} if the symbolDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the symbolDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/symbols/{id}")
    public ResponseEntity<SymbolDTO> updateSymbol(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SymbolDTO symbolDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Symbol : {}, {}", id, symbolDTO);
        if (symbolDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, symbolDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!symbolRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SymbolDTO result = symbolService.update(symbolDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, symbolDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /symbols/:id} : Partial updates given fields of an existing symbol, field will ignore if it is null
     *
     * @param id the id of the symbolDTO to save.
     * @param symbolDTO the symbolDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated symbolDTO,
     * or with status {@code 400 (Bad Request)} if the symbolDTO is not valid,
     * or with status {@code 404 (Not Found)} if the symbolDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the symbolDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/symbols/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SymbolDTO> partialUpdateSymbol(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SymbolDTO symbolDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Symbol partially : {}, {}", id, symbolDTO);
        if (symbolDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, symbolDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!symbolRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SymbolDTO> result = symbolService.partialUpdate(symbolDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, symbolDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /symbols} : get all the symbols.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of symbols in body.
     */
    @GetMapping("/symbols")
    public ResponseEntity<List<SymbolDTO>> getAllSymbols(
        SymbolCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Symbols by criteria: {}", criteria);
        Page<SymbolDTO> page = symbolQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /symbols/count} : count all the symbols.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/symbols/count")
    public ResponseEntity<Long> countSymbols(SymbolCriteria criteria) {
        log.debug("REST request to count Symbols by criteria: {}", criteria);
        return ResponseEntity.ok().body(symbolQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /symbols/:id} : get the "id" symbol.
     *
     * @param id the id of the symbolDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the symbolDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/symbols/{id}")
    public ResponseEntity<SymbolDTO> getSymbol(@PathVariable Long id) {
        log.debug("REST request to get Symbol : {}", id);
        Optional<SymbolDTO> symbolDTO = symbolService.findOne(id);
        return ResponseUtil.wrapOrNotFound(symbolDTO);
    }

    /**
     * {@code DELETE  /symbols/:id} : delete the "id" symbol.
     *
     * @param id the id of the symbolDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/symbols/{id}")
    public ResponseEntity<Void> deleteSymbol(@PathVariable Long id) {
        log.debug("REST request to delete Symbol : {}", id);
        symbolService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    /**
     * {@code SEARCH  /_search/symbols?query=:query} : search for the symbol corresponding
     * to the query.
     *
     * @param query the query of the symbol search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/symbols")
    public ResponseEntity<List<SymbolDTO>> searchSymbols(
        @RequestParam String query,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to search for a page of Symbols for query {}", query);
        Page<SymbolDTO> page = symbolService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
