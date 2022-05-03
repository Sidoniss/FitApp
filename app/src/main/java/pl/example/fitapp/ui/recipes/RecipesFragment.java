package pl.example.fitapp.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pl.example.fitapp.databinding.FragmentRecipesBinding;

import java.util.ArrayList;

public class RecipesFragment extends Fragment {
    private RecipesViewModel recipesViewModel;
    private FragmentRecipesBinding binding;
    private RecyclerView recipesRecView;
    private RecipesRecViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recipesViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recipesRecView = binding.recipesRecView;

        adapter = new RecipesRecViewAdapter(this.getContext());
        recipesRecView.setAdapter(adapter);
        //
        //adapter.setRecipesList(recipesList);

        recipesViewModel.getRecipeMutableLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Recipe>>() {
            @Override
            public void onChanged(ArrayList<Recipe> recipesList) {
                adapter.setRecipesList(recipesList);
            }
        });

        //recipesRecView.setAdapter(adapter);
        recipesRecView.setLayoutManager(new LinearLayoutManager(this.getContext()));



        final TextView textView = binding.textRecipes;
        recipesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
