package io.petproject.data.item;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
public class ItemsRepository {
    private ItemDataStore dbDataStore;
    private ItemDataStore cloudDataStore;

    public ItemsRepository(ItemDataStore dbDataStore,
                           ItemDataStore cloudDataStore) {
        this.dbDataStore = dbDataStore;
        this.cloudDataStore = cloudDataStore;
    }

    public Observable<ItemViewEntity> getItem(long itemId) {
        return Observable.concat(dbDataStore.getItem(itemId).toObservable(),
                                 cloudDataStore.getItem(itemId).toObservable())
                         .takeFirst(new Func1<ApiItem, Boolean>() {
                             @Override
                             public Boolean call(ApiItem apiItem) {
                                 return apiItem != null;
                             }
                         })
                         .map(new Func1<ApiItem, ItemViewEntity>() {
                             @Override
                             public ItemViewEntity call(ApiItem apiItem) {
                                 return ItemViewEntity.from(apiItem);
                             }
                         });
    }

    public Observable<List<ItemViewEntity>> getItems() {
        return Observable.concat(dbDataStore.getItems().toObservable(),
                                 cloudDataStore.getItems().toObservable())
                         .takeFirst(new Func1<List<ApiItem>, Boolean>() {
                             @Override
                             public Boolean call(List<ApiItem> apiItems) {
                                 return apiItems != null;
                             }
                         })
                         .map(new Func1<List<ApiItem>, List<ItemViewEntity>>() {
                             @Override
                             public List<ItemViewEntity> call(List<ApiItem> apiItems) {
                                 int size = apiItems.size();
                                 List<ItemViewEntity> itemViewEntities = new ArrayList<>(
                                         size);
                                 for (final ApiItem apiItem : apiItems) {
                                     itemViewEntities.add(ItemViewEntity.from(apiItem));
                                 }
                                 return itemViewEntities;
                             }
                         });
    }
}
