package com.example.mvvm_pattern;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_pattern.databinding.FragmentNewEmployeeBinding;
import com.example.mvvm_pattern.models.Employee;
import com.example.mvvm_pattern.viewmodels.EmployeeViewModels;


public class NewEmployeeFragment extends Fragment {

    FragmentNewEmployeeBinding binding;
    private EmployeeViewModels employeeViewModels;
    public NewEmployeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentNewEmployeeBinding.inflate(inflater,container,false);
        employeeViewModels=new ViewModelProvider(requireActivity()).get(EmployeeViewModels.class);

        binding.btn1.setOnClickListener(view -> {

            final String name=binding.ed1.getText().toString();
            final String designation=binding.ed2.getText().toString();
            final double sallary=Double.parseDouble(binding.ed3.getText().toString());
            final Employee employee=new Employee(name,designation,sallary);
            employeeViewModels.addEmployee(employee);

            Navigation.findNavController(view).popBackStack();

        });
        return binding.getRoot();
    }
}