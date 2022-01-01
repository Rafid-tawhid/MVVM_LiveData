package com.example.mvvm_pattern.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_pattern.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeViewModels extends ViewModel {

    private MutableLiveData<List<Employee>> empLiveDataList;
    private final List<Employee> employeeList=new ArrayList<>();
    public LiveData<List<Employee>> getEmployeeLiveDataList(){

        if(empLiveDataList!=null){
            return  empLiveDataList;
        }
        else {
            empLiveDataList=new MutableLiveData<>();
            return empLiveDataList;
        }
    }
    public void addEmployee(Employee employee){

        employeeList.add(employee);
        empLiveDataList.postValue(employeeList);

    }

}
