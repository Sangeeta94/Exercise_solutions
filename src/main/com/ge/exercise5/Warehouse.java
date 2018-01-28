package com.ge.exercise5;

import java.util.ArrayList;
import java.util.List;

import static com.ge.exercise5.Item.ItemType.*;

public class Warehouse {

    List<Item> items;

    public Warehouse() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItems() {
        for (Item item : items) {
            if (item.getType() != AGEABLE && item.getType() != CLIFF) {
                if (item.getValue() > 0) {
                    if (item.getType() == NORMAL) {
                        item.setValue(item.getValue() - 1);
                    }
                }
            } else if (item.getType() != NORMAL && item.getType() != AGEABLE && item.getType() != CLIFF) {
                if (item.getValue() > 0) {
                    item.setValue(item.getValue() - 1);
                }
            } else if (item.getValue() < 50) {
                item.setValue(item.getValue() + 1);
                if (item.getType() == CLIFF) {
                    if (item.getSellBy() <= 14) {
                        if (item.getValue() < 50)
                            item.setValue(item.getValue() + 1);
                    }
                    if (item.getSellBy() <= 7) {
                        if (item.getValue() < 50)
                            item.setValue(item.getValue() + 1);
                    }
                }
            }
            if (item.getType() != PRECIOUS) {
                item.setSellBy(item.getSellBy() - 1);
            }
            if (item.getSellBy() < 0) {
                if (item.getType() != AGEABLE) {
                    if (item.getType() != CLIFF) {
                        if (item.getValue() > 0) {
                            if (item.getType() != PRECIOUS) {
                                item.setValue(item.getValue() - 1);
                            }
                        }
                    } else {
                        item.setValue(item.getValue() - item.getValue());
                    }
                } else {
                    if (item.getValue() < 50) {
                        item.setValue(item.getValue() + 1);
                    }
                }
            }
        }
    }
}