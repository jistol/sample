package io.github.jistol.spring.data.rest.example.repository;

import io.github.jistol.spring.data.rest.example.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kimjh on 2017-03-24.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {}
