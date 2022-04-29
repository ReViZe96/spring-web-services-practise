package com.Spring_WS.practise;

import com.spring_ws.practise.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//Предоставляет объект на основе данных запроса
@Component
public class ItemsRepository {
    private static final List<Item> items = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Item first = new Item();
        first.setTitle("Кроссовки");
        first.setPrice(4500);
        first.setDescription("Новейшая разработка от фирмы Nuke");

        items.add(first);

        Item second = new Item();
        second.setTitle("Очки");
        second.setPrice(1000);
        second.setDescription("Очки солнцезащитные из бронебойного стекла");

        items.add(second);

        Item third = new Item();
        third.setTitle("Кепка");
        third.setPrice(200);
        third.setDescription("От бренда 'Солнцепёк'");

        items.add(third);
    }

    //Товар по названию
    public Item findItem(String title) {
        Assert.notNull(title);

        Item result = null;

        for (Item item : items) {
            if (title.equals(item.getTitle())) {
                result = item;
            }
        }
        return result;
    }
}