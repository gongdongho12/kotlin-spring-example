package com.store.repository.reactive

import com.store.domain.Order
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.r2dbc.repository.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ReactiveOrderRepository : R2dbcRepository<Order, Long> {
    @Query("SELECT * from orders where id = :id")
    fun findByIdRx(id: Long): Mono<Order>
}
