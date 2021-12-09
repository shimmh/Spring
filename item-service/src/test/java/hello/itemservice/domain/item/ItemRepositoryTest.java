package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("item1", 1000, 2);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);//실제 값, 기대한 값
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("item1", 1000, 2);
        Item item2 = new Item("item2", 2000, 3);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("item1", 1000, 2);
        itemRepository.save(item);
        Long itemId = item.getId();

        //when
        Item updateItem = new Item("item2", 2000, 3);
        itemRepository.update(itemId, updateItem);

        //then
        Item result = itemRepository.findById(itemId);
        assertThat(result.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(result.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(result.getQuantity()).isEqualTo(updateItem.getQuantity());

    }
}