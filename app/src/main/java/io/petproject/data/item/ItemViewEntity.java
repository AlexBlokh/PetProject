package io.petproject.data.item;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
public class ItemViewEntity {
    public String title;

    public ItemViewEntity(String title) {
        this.title = title;
    }

    public static ItemViewEntity from(ApiItem apiItem) {
        return new ItemViewEntity(apiItem.itemName);
    }
}
