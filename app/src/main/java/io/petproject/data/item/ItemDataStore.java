package io.petproject.data.item;

import java.util.List;

import rx.Single;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
public interface ItemDataStore {
    Single<ApiItem> getItem(long id);
    Single<List<ApiItem>> getItems();
}
