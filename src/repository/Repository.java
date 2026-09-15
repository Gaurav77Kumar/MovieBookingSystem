package src.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item){
        items.add(item);
    }

    public List<T> getAll(){
        return items;
    }

    public T findFirst(Predicate<T> condition){
        for(T item: items){
            if(condition.test(item)) return item;
        }
        return null;
    }
}
