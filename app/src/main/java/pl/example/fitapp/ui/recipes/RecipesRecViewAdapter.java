package pl.example.fitapp.ui.recipes;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import org.jetbrains.annotations.NotNull;
import pl.example.fitapp.R;

import java.util.ArrayList;

public class RecipesRecViewAdapter extends RecyclerView.Adapter<RecipesRecViewAdapter.ViewHolder> {

    private ArrayList<Recipe> recipesList = new ArrayList<>();

    private Context context;

    public RecipesRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.nameOfRecipe.setText(recipesList.get(position).getName());
        holder.timeOfCook.setText("Time:" + recipesList.get(position).getTime());
        holder.descriptionOfMeal.setText(recipesList.get(position).getDescription());
        holder.recipeTxt.setText(recipesList.get(position).getRecipetxt());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, recipesList.get(position).getName() + " Selected",Toast.LENGTH_SHORT).show();
                int v = (holder.recipeTxt.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

                TransitionManager.beginDelayedTransition(holder.recipeLayout,new AutoTransition());
                holder.recipeTxt.setVisibility(v);
            }
        });

        /*Glide.with(context)
                .asBitmap()
                .load(recipesList.get(position).getImageUrl())
                .into(holder.image);*/
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    public void setRecipesList(final ArrayList<Recipe> recipesList) {
        this.recipesList.clear();
        this.recipesList = recipesList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameOfRecipe, timeOfCook, descriptionOfMeal, recipeTxt;
        private RelativeLayout recipeLayout;
        //private ImageView image;
        private CardView parent;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nameOfRecipe = itemView.findViewById(R.id.nameOfRecipe);
            timeOfCook = itemView.findViewById(R.id.timeOfCook);
            //image = (ImageView) itemView.findViewById(R.id.image);
            descriptionOfMeal = itemView.findViewById(R.id.descriptionOfMeal);
            recipeTxt = itemView.findViewById(R.id.recipeText);
            recipeLayout = itemView.findViewById(R.id.recipeLayout);
            recipeLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
            parent = itemView.findViewById(R.id.parent);
        }
    }


}
