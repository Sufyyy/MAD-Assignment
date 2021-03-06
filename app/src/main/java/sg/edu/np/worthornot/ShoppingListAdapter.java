package sg.edu.np.worthornot;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListViewHolder> {
    ArrayList<ShoppingList> shoppingData;
    Context context;
    Drawable foodDrawable;
    Drawable drinkDrawable;
    Drawable householdDrawable;
    Drawable petDrawable;

    public ShoppingListAdapter(ArrayList<ShoppingList> input){
        this.shoppingData = input;
    }

    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_shoppinglist, parent, false);
        return new ShoppingListViewHolder(item);
    }

    public void onBindViewHolder(ShoppingListViewHolder holder, int position){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = 100;
        ShoppingList shoppingItem = shoppingData.get(position);
        if (shoppingItem.getItemCategory().equals("F")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText("Price: $" + String.valueOf(String.format("%.2f", shoppingItem.getItemPrice())));
            holder.itemPrice.setText(String.valueOf("Quantity: x"+shoppingItem.getItemAmount()));
            holder.itemImage.setImageResource(R.drawable.ic_food);
        }
        else if (shoppingItem.getItemCategory().equals("D")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText("Price: $" + String.valueOf(String.format("%.2f", shoppingItem.getItemPrice())));
            holder.itemPrice.setText(String.valueOf("Quantity: x"+shoppingItem.getItemAmount()));
            holder.itemImage.setImageResource(R.drawable.ic_drinks);
        }
        else if (shoppingItem.getItemCategory().equals("H")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText("Price: $" + String.valueOf(String.format("%.2f", shoppingItem.getItemPrice())));
            holder.itemPrice.setText(String.valueOf("Quantity: x"+shoppingItem.getItemAmount()));
            holder.itemImage.setImageResource(R.drawable.ic_household_items);
        }
        else {
            holder.itemName.setText("Item not found!");
        }
    }

    public int getItemCount(){
        return shoppingData.size();
    }
}
