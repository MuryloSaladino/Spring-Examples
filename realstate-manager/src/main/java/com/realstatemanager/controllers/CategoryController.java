package com.realstatemanager.controllers;

import com.realstatemanager.dto.category.CategoryCreationPayload;
import com.realstatemanager.dto.category.CategoryResponse;
import com.realstatemanager.exceptions.ForbiddenException;
import com.realstatemanager.exceptions.UnauthorizedException;
import com.realstatemanager.interfaces.CategoryService;
import com.realstatemanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("categories")
public class CategoryController {

    @Autowired
    UserSession userSession;

    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    protected ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryCreationPayload body) {

        if(userSession.getId() == null) throw new UnauthorizedException();
        if(!userSession.getAdmin()) throw new ForbiddenException();

        return ResponseEntity
                .status(201)
                .body(new CategoryResponse( categoryService.create(body) ));
    }

    @GetMapping("")
    protected ResponseEntity<List<CategoryResponse>> getCategories() {

        var categories = categoryService
                .readAll()
                .stream()
                .map(x -> new CategoryResponse(x))
                .toList();

        return ResponseEntity.ok(categories);
    }
}
