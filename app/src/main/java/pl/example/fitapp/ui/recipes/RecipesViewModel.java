package pl.example.fitapp.ui.recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pl.example.fitapp.R;

import java.util.ArrayList;

public class RecipesViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<Recipe>> rList;
    private ArrayList<Recipe> recipesList;

    public RecipesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("What are we going to eat today?");

        rList = new MutableLiveData<>();
        init();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<ArrayList<Recipe>> getRecipeMutableLiveData() {
        return rList;
    }

    public void init() {
        populateList();
        rList.setValue(recipesList);
    }

    public void populateList() {
        recipesList = new ArrayList<>();

        recipesList.add(new Recipe("Sałatka Cezar","30min","https://cdn.aniagotuje.com/pictures/articles/2021/11/21731412-v-1500x1500.jpg","Zdrowa i pożywna sałatka!", "-component\r\n-component\r\n-component\r\n\r\ntexttext text text texttext text texttexttext text texttext texttexttexttext text text texttext text text texttext."));
        recipesList.add(new Recipe("Burger wołowy","1h 30min","https://cdn.aniagotuje.com/pictures/articles/2020/05/3989474-v-1500x1500.jpg","Pyszny i pożywny.","-component\r\n-component\r\n-component\r\n\r\ntexttext text text texttext text texttexttext text texttext texttexttexttext text text texttext text text texttext."));
        recipesList.add(new Recipe("Stek wołowy","3h","https://ocdn.eu/pulscms-transforms/1/j-0k9kqTURBXy9kMTA5YTdiMjgyMmY4MzEzYzQyMTAxNzgwNjU3N2JkMC5qcGVnk5UDAMzCzQPozQIzkwXNAxTNAbyTCaY0MjhmMDgGgaEwAQ/jak-przygotowac-perfekcyjny-stek-z-kratka-oto-przepis.jpg","Jeśli go nie polubisz nie nazywaj się wielbicielem mięsa!","-component\r\n-component\r\n-component\r\n\r\ntexttext text text texttext text texttexttext text texttext texttexttexttext text text texttext text text texttext."));
        recipesList.add(new Recipe("Kurczak po hawajsku","1h 25min","https://cdn-bchgf.nitrocdn.com/gmtsYkEJzbilQlGoIcXFZxuYpejslsPB/assets/static/optimized/rev-6a9b973/wp-content/uploads/2020/01/kuczak_po_hawajsku_after-1024x767.jpg","Bo kto nie lubi kurczaka?","-component\r\n-component\r\n-component\r\n\r\ntexttext text text texttext text texttexttext text texttext texttexttexttext text text texttext text text texttext."));


    }

}
