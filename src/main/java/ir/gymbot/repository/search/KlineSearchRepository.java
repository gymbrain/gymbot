package ir.gymbot.repository.search;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import ir.gymbot.domain.Kline;
import ir.gymbot.repository.KlineRepository;
import java.util.List;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Data Elasticsearch repository for the {@link Kline} entity.
 */
public interface KlineSearchRepository extends ElasticsearchRepository<Kline, Long>, KlineSearchRepositoryInternal {}

interface KlineSearchRepositoryInternal {
    Page<Kline> search(String query, Pageable pageable);

    Page<Kline> search(Query query);

    void index(Kline entity);
}

class KlineSearchRepositoryInternalImpl implements KlineSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final KlineRepository repository;

    KlineSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate, KlineRepository repository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.repository = repository;
    }

    @Override
    public Page<Kline> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        return search(nativeSearchQuery.setPageable(pageable));
    }

    @Override
    public Page<Kline> search(Query query) {
        SearchHits<Kline> searchHits = elasticsearchTemplate.search(query, Kline.class);
        List<Kline> hits = searchHits.map(SearchHit::getContent).stream().collect(Collectors.toList());
        return new PageImpl<>(hits, query.getPageable(), searchHits.getTotalHits());
    }

    @Override
    public void index(Kline entity) {
        repository.findOneWithEagerRelationships(entity.getId()).ifPresent(elasticsearchTemplate::save);
    }
}
