package com.example.taaportal.mappers;

import com.example.taaportal.dtos.CatalogItemDto;
import com.example.taaportal.entities.CatalogItem;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CatalogItemMapper {
    CatalogItem toEntity(CatalogItemDto catalogItemDto);

    CatalogItemDto toDto(CatalogItem catalogItem);

    List<CatalogItemDto> toDtoList(List<CatalogItem> catalogItems);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CatalogItem partialUpdate(CatalogItemDto catalogItemDto, @MappingTarget CatalogItem catalogItem);
}