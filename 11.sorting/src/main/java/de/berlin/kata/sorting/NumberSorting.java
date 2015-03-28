package de.berlin.kata.sorting;
import java.util.ArrayList;
import java.util.List;

class NumberSorting{

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getSortedNumbers(){
        return numbers;
    }

    public void addNumber(Integer newNumber){
        int index=0;
        for(Integer number : numbers){
            if(number > newNumber){
                break;
            }else{
                index++;
            }
        }
        numbers.add(index, newNumber);
    }

}