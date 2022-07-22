package me.mikael.crdb.crdbissuereplication.repository;

import me.mikael.crdb.crdbissuereplication.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 *
 */
@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, String> {
}
