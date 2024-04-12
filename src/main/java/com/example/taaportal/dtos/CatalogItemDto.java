package com.example.taaportal.dtos;

import com.example.taaportal.entities.CatalogItem;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link CatalogItem}
 */
@Value
public class CatalogItemDto implements Serializable {
    Integer id;
    Integer recordType;
    String name;
    String image;
    String description;
    String codeBarcode;
    String codeSerial;
    Integer fkModelId;
    Integer fkOwnerId;
    Boolean placeDefIsItem;
    Integer fkPlaceDefId;
    Boolean placeCurIsItem;
    Integer fkPlaceCurId;
    Integer count;
    Boolean archived;
}