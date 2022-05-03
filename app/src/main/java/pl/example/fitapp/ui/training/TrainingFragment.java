package pl.example.fitapp.ui.training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import pl.example.fitapp.databinding.FragmentTrainingBinding;

public class TrainingFragment extends Fragment {

    private TrainingViewModel trainingViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentTrainingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trainingViewModel =
                new ViewModelProvider(this).get(TrainingViewModel.class);

        binding = FragmentTrainingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tabLayout = binding.treningTab;
        viewPager = binding.viewPager;

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new TreningEasyFragment(),"Easy");
        vpAdapter.addFragment(new TreningMediumFragment(),"Medium");
        vpAdapter.addFragment(new TreningHardFragment(),"Hard");
        viewPager.setAdapter(vpAdapter);

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}