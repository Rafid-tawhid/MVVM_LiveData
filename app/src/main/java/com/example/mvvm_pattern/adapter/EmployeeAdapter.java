package com.example.mvvm_pattern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_pattern.databinding.EmpRowBinding;
import com.example.mvvm_pattern.models.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        EmpRowBinding binding=EmpRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final Employee employee=employeeList.get(position);
        holder.bind(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{

        EmpRowBinding binding;
        public EmployeeViewHolder(EmpRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
        public void bind(Employee employee){
            binding.setEmp(employee);
        }
    }
}
