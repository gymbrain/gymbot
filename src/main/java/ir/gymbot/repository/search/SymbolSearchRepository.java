package ir.gymbot.repository.search;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import ir.gymbot.domain.Symbol;
import ir.gymbot.repository.SymbolRepository;
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
 * Spring Data Elasticsearch repository for the {@link Symbol} entity.
 */
public interface SymbolSearchRepository extends ElasticsearchRepository<Symbol, Long>, SymbolSearchRepositoryInternal {}

interface SymbolSearchRepositoryInternal {
    Page<Symbol> search(String query, Pageable pageable);

    Page<Symbol> search(Query query);

    void index(Symbol entity);
}

class SymbolSearchRepositoryInternalImpl implements SymbolSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final SymbolRepository repository;

    SymbolSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate, SymbolRepository repository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.repository = repository;
    }

    @Override
    public Page<Symbol> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        return search(nativeSearchQuery.setPageable(pageable));
    }

    @Override
    public Page<Symbol> search(Query query) {
        SearchHits<Symbol> searchHits = elasticsearchTemplate.search(query, Symbol.class);
        List<Symbol> hits = searchHits.map(SearchHit::getContent).stream().collect(Collectors.toList());
        return new PageImpl<>(hits, query.getPageable(), searchHits.getTotalHits());
    }

    @Override
    public void index(Symbol entity) {
        repository.findById(entity.getId()).ifPresent(elasticsearchTemplate::save);
    }
}
