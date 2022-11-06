package ir.gymbot.service.mapper;

import ir.gymbot.domain.Kline;
import ir.gymbot.domain.Symbol;
import ir.gymbot.service.dto.KlineDTO;
import ir.gymbot.service.dto.SymbolDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Kline} and its DTO {@link KlineDTO}.
 */
@Mapper(componentModel = "spring")
public interface KlineMapper extends EntityMapper<KlineDTO, Kline> {
    @Mapping(target = "symbol", source = "symbol", qualifiedByName = "symbolSymbol")
    KlineDTO toDto(Kline s);

    @Named("symbolSymbol")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "symbol", source = "symbol")
    SymbolDTO toDtoSymbolSymbol(Symbol symbol);
}
