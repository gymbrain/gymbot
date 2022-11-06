package ir.gymbot.web.rest;

import static org.elasticsearch.index.query.QueryBuilders.*;

import ir.gymbot.repository.KlineRepository;
import ir.gymbot.service.KlineQueryService;
import ir.gymbot.service.KlineService;
import ir.gymbot.service.criteria.KlineCriteria;
import ir.gymbot.service.dto.KlineDTO;
import ir.gymbot.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;
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
 * REST controller for managing {@link ir.gymbot.domain.Kline}.
 */
@RestController
@RequestMapping("/api")
public class KlineResource {

    private final Logger log = LoggerFactory.getLogger(KlineResource.class);

    private static final String ENTITY_NAME = "kline";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final KlineService klineService;

    private final KlineRepository klineRepository;

    private final KlineQueryService klineQueryService;

    public KlineResource(KlineService klineService, KlineRepository klineRepository, KlineQueryService klineQueryService) {
        this.klineService = klineService;
        this.klineRepository = klineRepository;
        this.klineQueryService = klineQueryService;
    }

    /**
     * {@code POST  /klines} : Create a new kline.
     *
     * @param klineDTO the klineDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new klineDTO, or with status {@code 400 (Bad Request)} if the kline has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/klines")
    public ResponseEntity<KlineDTO> createKline(@RequestBody KlineDTO klineDTO) throws URISyntaxException {
        log.debug("REST request to save Kline : {}", klineDTO);
        if (klineDTO.getId() != null) {
            throw new BadRequestAlertException("A new kline cannot already have an ID", ENTITY_NAME, "idexists");
        }
        KlineDTO result = klineService.save(klineDTO);
        return ResponseEntity
            .created(new URI("/api/klines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /klines/:id} : Updates an existing kline.
     *
     * @param id the id of the klineDTO to save.
     * @param klineDTO the klineDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated klineDTO,
     * or with status {@code 400 (Bad Request)} if the klineDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the klineDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/klines/{id}")
    public ResponseEntity<KlineDTO> updateKline(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody KlineDTO klineDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Kline : {}, {}", id, klineDTO);
        if (klineDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, klineDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!klineRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        KlineDTO result = klineService.update(klineDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, klineDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /klines/:id} : Partial updates given fields of an existing kline, field will ignore if it is null
     *
     * @param id the id of the klineDTO to save.
     * @param klineDTO the klineDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated klineDTO,
     * or with status {@code 400 (Bad Request)} if the klineDTO is not valid,
     * or with status {@code 404 (Not Found)} if the klineDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the klineDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/klines/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<KlineDTO> partialUpdateKline(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody KlineDTO klineDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Kline partially : {}, {}", id, klineDTO);
        if (klineDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, klineDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!klineRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<KlineDTO> result = klineService.partialUpdate(klineDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, klineDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /klines} : get all the klines.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of klines in body.
     */
    @GetMapping("/klines")
    public ResponseEntity<List<KlineDTO>> getAllKlines(
        KlineCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Klines by criteria: {}", criteria);
        Page<KlineDTO> page = klineQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /klines/count} : count all the klines.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/klines/count")
    public ResponseEntity<Long> countKlines(KlineCriteria criteria) {
        log.debug("REST request to count Klines by criteria: {}", criteria);
        return ResponseEntity.ok().body(klineQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /klines/:id} : get the "id" kline.
     *
     * @param id the id of the klineDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the klineDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/klines/{id}")
    public ResponseEntity<KlineDTO> getKline(@PathVariable Long id) {
        log.debug("REST request to get Kline : {}", id);
        Optional<KlineDTO> klineDTO = klineService.findOne(id);
        return ResponseUtil.wrapOrNotFound(klineDTO);
    }

    /**
     * {@code DELETE  /klines/:id} : delete the "id" kline.
     *
     * @param id the id of the klineDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/klines/{id}")
    public ResponseEntity<Void> deleteKline(@PathVariable Long id) {
        log.debug("REST request to delete Kline : {}", id);
        klineService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    /**
     * {@code SEARCH  /_search/klines?query=:query} : search for the kline corresponding
     * to the query.
     *
     * @param query the query of the kline search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/klines")
    public ResponseEntity<List<KlineDTO>> searchKlines(
        @RequestParam String query,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to search for a page of Klines for query {}", query);
        Page<KlineDTO> page = klineService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
