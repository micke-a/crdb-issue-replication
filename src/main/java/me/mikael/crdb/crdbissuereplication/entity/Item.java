package me.mikael.crdb.crdbissuereplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity()
public class Item implements Serializable {

    @Id
    private String id;

    private String message;
}
