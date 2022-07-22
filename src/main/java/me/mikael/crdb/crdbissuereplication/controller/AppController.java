package me.mikael.crdb.crdbissuereplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mikael.crdb.crdbissuereplication.entity.Item;
import me.mikael.crdb.crdbissuereplication.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("issue")
public class AppController {

    private final ItemRepository itemRepository;

    @PostMapping("/create")
    public String createPost(){

        var item = itemRepository.save(new Item(UUID.randomUUID().toString(), "Created "+ LocalDateTime.now()));

        return item.getId();
    }

    @GetMapping("/fetch/{id}")
    public String fetchGet(@PathVariable("id") String id){

        var itemOptional = itemRepository.findById(id);

        return itemOptional.map(item -> item.getId() +", '" +item.getMessage() +"'").orElse("Not Found");
    }
}
