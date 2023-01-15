package com.book.repository;

import com.book.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o " +
    "where  o.member.userid = :userid " +
    "order by o.orderDate desc")
    List<Order> findOrders(@Param("userid") String userid, Pageable pageable);

    @Query("select count(o) from Order  o "+
    "where o.member.userid = :userid")
    Long countOrder(@Param("userid") String userid);
}
