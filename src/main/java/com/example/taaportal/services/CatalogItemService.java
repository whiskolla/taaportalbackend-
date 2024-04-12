package com.example.taaportal.services;

import com.example.taaportal.controller.CatalogItemController;
import com.example.taaportal.dtos.CatalogItemDto;
import com.example.taaportal.mappers.CatalogItemMapper;
import com.example.taaportal.repositories.CatalogItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.taaportal.entities.CatalogItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogItemService {
    private final CatalogItemRepository itemRepository;
    private final CatalogItemMapper itemMapper;
    private final Logger logger = LoggerFactory.getLogger(CatalogItemController.class);

    public List<CatalogItemDto> findAll() {
        logger.info("CatalogItemService >> findAll");
        logger.info("Get List<CatalogItemDto>");
        logger.info("Send List");
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    public CatalogItemDto findTopByOrderByIdDesc() {
        logger.info("CatalogItemService >> findTopByOrderByIdDesc");
        logger.info("Send Item");
        return itemMapper.toDto(itemRepository.findTopByOrderByIdDesc());
    }

    @Transactional
    public void save(CatalogItemDto itemDto){
        logger.info("CatalogItemService >> save | " + itemDto.getId());
        logger.info("Create CatalogItem");
        CatalogItem item = itemMapper.toEntity(itemDto);
        logger.info("Check for new item");
        int id;
        if (itemDto.getId() == -1) {
            id = itemRepository.findTopByOrderByIdDesc().getId() + 1;
            logger.info("Create new on " + id);
        }
        else {
            id = itemDto.getId();
            logger.info("Update old on " + id);
        }
        item.setId(id);
        logger.info("Save Item");
        itemRepository.save(item);
    }
}
