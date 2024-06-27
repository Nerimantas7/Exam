package lt.techin.exam.controller;


import lombok.AllArgsConstructor;
import lt.techin.exam.dto.AdvertCategoryDto;
import lt.techin.exam.service.AdvertCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/adverts/categories")
public class AdvertCategoryController {

    private AdvertCategoryService advertCategoryService;

    // Build Add Advert Category REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @PostMapping
    public ResponseEntity<AdvertCategoryDto> addCategory(@RequestBody AdvertCategoryDto advertCategoryDto){
        AdvertCategoryDto addedCategory = advertCategoryService.addCategory(advertCategoryDto);
        System.out.println("Category added: " + addedCategory);
        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
    }

    // Build Get Advert REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping("{id}")
    public ResponseEntity<AdvertCategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
        AdvertCategoryDto advertCategoryDto = advertCategoryService.getCategoryById(categoryId);
        System.out.println("Category find with given ID: " + categoryId);
        return ResponseEntity.ok(advertCategoryDto);
    }

    // Build Get All Categories REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping
    public ResponseEntity<List<AdvertCategoryDto>> getAllCategories(){
        List<AdvertCategoryDto> categories = advertCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Build Update Advert Category REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @PutMapping("{id}")
    public ResponseEntity<AdvertCategoryDto> updateAdvertCategory(@PathVariable("id") Long categoryId,
                                                              @RequestBody AdvertCategoryDto updatedCategory){
        AdvertCategoryDto advertCategoryDto = advertCategoryService.updateAdvertCategory(categoryId, updatedCategory);
        System.out.println(("Advert category successfully updated with given Id: " + categoryId));
        return ResponseEntity.ok(advertCategoryDto);
    }

    // Build Delete Advert Category REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        advertCategoryService.deleteAdvertCategory(categoryId);
        return ResponseEntity.ok("Advert Category deleted successfully!");
    }
}


