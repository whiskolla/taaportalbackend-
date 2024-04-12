package com.example.taaportal.controller;

import com.example.taaportal.dtos.CatalogItemDto;
import lombok.RequiredArgsConstructor;
import com.example.taaportal.services.CatalogItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@CrossOrigin(
        origins = {
                "http://10.0.91.123", "http://10.0.91.123:80", "http://10.0.91.123:4200", "http://10.0.91.123:8181",
                "http://10.0.90.155", "http://10.0.90.155:80", "http://10.0.90.155:4200", "http://10.0.90.155:8181",
                "http://10.0.91.20", "http://10.0.91.20:80", "http://10.0.91.20:4200", "http://10.0.91.20:8181",
                "http://localhost", "http://localhost:80", "http://localhost:4200", "http://localhost:8181",
        }, allowedHeaders="*", methods={RequestMethod.POST,RequestMethod.GET}

)
@RequestMapping("/taaapi/catalog")
@RequiredArgsConstructor
public class CatalogItemController {
    private final CatalogItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(CatalogItemController.class);

    @ResponseBody
    @GetMapping("/itemslist")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CatalogItemDto>> findAll() {
        logger.info("CatalogItemController >> findAll");
        List<CatalogItemDto> tempList = itemService.findAll();
        logger.info("Sent (n=" + tempList.size() +")");
        ResponseEntity.BodyBuilder response = ResponseEntity.ok();
        return response.body(tempList);
    }

    @ResponseBody
    @GetMapping("/itemlast")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CatalogItemDto> findTopByOrderByIdDesc(){
        logger.info("CatalogItemController >> findTopByOrderByIdDesc");
        CatalogItemDto temp = itemService.findTopByOrderByIdDesc();
        logger.info("Sent (id=" + temp.getId() +")");
        ResponseEntity.BodyBuilder response = ResponseEntity.ok();
        return response.body(temp);
    }

    @PostMapping("/itemedit")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody CatalogItemDto itemDtoExt) {
        logger.info("CatalogItemController >> save | " + itemDtoExt.getId());
        logger.info(String.valueOf(itemDtoExt));
        itemService.save(itemDtoExt);
        logger.info("Saved");
    }
}





