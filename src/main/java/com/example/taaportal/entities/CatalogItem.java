package com.example.taaportal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "catalog_items")
public class CatalogItem {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "record_type", nullable = false)
    private Integer recordType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "code_barcode", nullable = false)
    private String codeBarcode;

    @Column(name = "code_serial", nullable = false)
    private String codeSerial;

    @Column(name = "fk_model_id")
    private Integer fkModelId;

    @Column(name = "fk_owner_id")
    private Integer fkOwnerId;

    @Column(name = "place_def_is_item", nullable = false)
    private Boolean placeDefIsItem = false;

    @Column(name = "fk_place_def_id")
    private Integer fkPlaceDefId;

    @Column(name = "place_cur_is_item", nullable = false)
    private Boolean placeCurIsItem = false;

    @Column(name = "fk_place_cur_id")
    private Integer fkPlaceCurId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "archived", nullable = false)
    private Boolean archived = false;

}