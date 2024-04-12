package com.example.taaportal.repositories;

import com.example.taaportal.entities.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, Integer> {
    CatalogItem findTopByOrderByIdDesc();
}