package vn.iotstar.api.bai3api.controller;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import vn.iotstar.api.bai3api.Respone.Respone;
import vn.iotstar.api.bai3api.entity.Category;
import vn.iotstar.api.bai3api.service.ICategoryService;

import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("v1/api/category")
public class CategoryAPIController {

    @Autowired
    private ICategoryService categoryService;
    /*@Autowired
    private CategoryRepository repository;
    @RequestMapping("")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(repository.findAll());
    }*/
    @GetMapping("/get")
    public ResponseEntity<Category> getCategory(@RequestParam("name") String categoryname) {
        Optional<Category> category =
                categoryService.findByName(categoryname);

        System.out.println(category);

        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/save")
    public Category saveCategory(@Valid @RequestBody Category category) {
        return categoryService.save(category);
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId,
                                         @Valid @RequestBody Category category) {
        Optional<Category> cate = categoryService.findByCategoryId(categoryId);
        if (cate.isPresent()) {
            cate.get().setName(category.getName());
            Category updatedContact = categoryService.save(cate.get());
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Long categoryId) {
        Optional<Category> cate = categoryService.findByCategoryId(categoryId);
        if (cate.isPresent()) {
            categoryService.delete(cate.get().getCategoryId());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> getAllCategory() {
        return new ResponseEntity<Respone>(new Respone(true, "Thành công",  categoryService.findAll()), HttpStatus.OK);
    }
    @GetMapping("/get3")
    public ResponseEntity<?> getCategoryById(@Validated @RequestParam(value = "id") Long categoryId) {
        Optional<Category> category = categoryService.findByCategoryId(categoryId);
        if (category.isPresent()) {
            return new  ResponseEntity<Respone>(new Respone(true, "Thành công", category.get()), HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }


}


