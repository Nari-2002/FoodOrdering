package com.example.FoodOrdering.controller;

import com.example.FoodOrdering.entity.FoodItem;
import com.example.FoodOrdering.entity.Type;
import com.example.FoodOrdering.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    // ✅ 1. Add a single food item
    @PostMapping("/add")
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem saved = foodItemService.addItem(foodItem);
        return ResponseEntity.ok(saved);
    }

    // ✅ 2. Add multiple food items at once
    @PostMapping("/addAll")
    public ResponseEntity<List<FoodItem>> addAllFoodItems(@RequestBody List<FoodItem> foodItems) {
        List<FoodItem> savedItems = foodItemService.addAll(foodItems);
        return ResponseEntity.ok(savedItems);
    }

    // ✅ 3. Get all food items
    @GetMapping("/all")
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> items = foodItemService.getAll();
        return ResponseEntity.ok(items);
    }

    // ✅ 4. Get food items by type (BREAKFAST, LUNCH, etc.)
    @GetMapping("/type/{type}")
    public ResponseEntity<List<FoodItem>> getByType(@PathVariable Type type) {
        List<FoodItem> items = foodItemService.getByType(type);
        return ResponseEntity.ok(items);
    }

    // ✅ 5. Update an existing food item
    @PutMapping("/update/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem updatedFoodItem) {
        FoodItem updated = foodItemService.updateItem(id, updatedFoodItem);
        return ResponseEntity.ok(updated);
    }

    // ✅ 6. Delete a food item by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable Long id) {
        foodItemService.deleteItem(id);
        return ResponseEntity.ok("Food item deleted successfully with ID: " + id);
    }
}
