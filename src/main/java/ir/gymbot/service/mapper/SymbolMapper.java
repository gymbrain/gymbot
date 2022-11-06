package ir.gymbot.service.mapper;

import ir.gymbot.domain.Symbol;
import ir.gymbot.service.dto.SymbolDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Symbol} and its DTO {@link SymbolDTO}.
 */
@Mapper(componentModel = "spring")
public interface SymbolMapper extends EntityMapper<SymbolDTO, Symbol> {}
