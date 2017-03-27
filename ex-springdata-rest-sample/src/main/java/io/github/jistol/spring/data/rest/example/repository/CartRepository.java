package io.github.jistol.spring.data.rest.example.repository;

import io.github.jistol.spring.data.rest.example.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kimjh on 2017-03-24.
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {}
