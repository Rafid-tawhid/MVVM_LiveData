package com.example.mvvm_pattern;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvvm_pattern.adapter.EmployeeAdapter;
import com.example.mvvm_pattern.databinding.FragmentHomeBinding;
import com.example.mvvm_pattern.models.Employee;
import com.example.mvvm_pattern.viewmodels.EmployeeViewModels;

import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private EmployeeViewModels employeeViewModels;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false);

        employeeViewModels=new ViewModelProvider(requireActivity()).get(EmployeeViewModels.class);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.newEmployeeFragment);

            }
        });


        final LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        binding.rv.setLayoutManager(llm);
        employeeViewModels.getEmployeeLiveDataList().observe(getViewLifecycleOwner(), employees -> {

            final EmployeeAdapter adapter=new EmployeeAdapter(employees);
            binding.rv.setAdapter(adapter);

        });
        return binding.getRoot();
    }
}