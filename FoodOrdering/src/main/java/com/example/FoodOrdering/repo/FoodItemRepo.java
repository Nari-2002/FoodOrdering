package com.example.FoodOrdering.repo;

import com.example.FoodOrdering.entity.Category;
import com.example.FoodOrdering.entity.FoodItem;
import com.example.FoodOrdering.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long> {
        List<FoodItem> findByCategory(Category category);
        List<FoodItem> findByType(Type type);
    }

