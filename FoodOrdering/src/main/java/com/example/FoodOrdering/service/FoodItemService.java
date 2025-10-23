package com.example.FoodOrdering.service;

import com.example.FoodOrdering.entity.Category;
import com.example.FoodOrdering.entity.FoodItem;
import com.example.FoodOrdering.entity.Type;
import com.example.FoodOrdering.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepo repository;

    public List<FoodItem> getAll() {
        return repository.findAll();
    }

    public List<FoodItem> getByCategory(Category category) {
        return repository.findByCategory(category);
    }

    public List<FoodItem> getByType(Type type) {
        return repository.findByType(type);
    }

    public FoodItem addItem(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public List<FoodItem> addAll(List<FoodItem> items) {
        return repository.saveAll(items);
    }


    public FoodItem updateItem(Long id, FoodItem updatedItem) {
        Optional<FoodItem> optionalItem = repository.findById(id);

        if (optionalItem.isPresent()) {
            FoodItem existingItem = optionalItem.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setAvailable(updatedItem.isAvailable());
            existingItem.setCategory(updatedItem.getCategory());
            existingItem.setType(updatedItem.getType());
            existingItem.setImageUrl(updatedItem.getImageUrl());

            return repository.save(existingItem);
        } else {
            throw new RuntimeException("Food item not found with id " + id);
        }
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}
