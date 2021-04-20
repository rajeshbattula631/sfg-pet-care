package com.example.sfgpetcare.services.map;

import com.example.sfgpetcare.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }
    T save(T object){
        if(object != null){
            if(object.getId() == null){
            object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else {
            throw new RuntimeException("Object Can't be not null");
        }

        return object;
    }
    void delete(T object){
         map.entrySet().removeIf(e->e.getValue().equals(object));
    }
    void deleteById(ID id){
        map.remove(id);
    }
    private Long getNextId(){
        Long nextId = null;
        try {
            nextId =Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
        nextId = 1L;
        }

        return nextId;
    }

}
