package com.store.controller

import com.store.domain.ProductOptionItem
import com.store.service.ProductOptionItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/api/product_option_items")
class ProductOptionItemController {
    @Autowired
    lateinit var productOptionItemService: ProductOptionItemService

    @PostMapping
    fun create(@RequestBody productOptionItem: ProductOptionItem): ResponseEntity<ProductOptionItem> {
        val result = productOptionItemService.save(productOptionItem)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id)
                .toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping("/{product_option_item_id}")
    fun show(@PathVariable("product_option_item_id") productOptionItemId: Long): ResponseEntity<Optional<ProductOptionItem>> {
        val product = productOptionItemService.findById(productOptionItemId)
        return ResponseEntity.ok(product)
    }

    @PutMapping("/{product_option_item_id}")
    fun update(@PathVariable("product_option_item_id") productOptionItemId: Long, @RequestBody productOptionItem: ProductOptionItem): ResponseEntity<ProductOptionItem> {
        val result = productOptionItemService.save(productOptionItem)
        return ResponseEntity.ok(result)
    }
}
