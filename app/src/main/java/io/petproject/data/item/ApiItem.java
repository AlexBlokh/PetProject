package io.petproject.data.item;

import com.google.gson.annotations.SerializedName;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
public class ApiItem {
    @SerializedName("item_name") public String itemName;
    @SerializedName("item_id ") public  long   itemId;
}
