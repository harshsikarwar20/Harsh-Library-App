package com.Harsh.LibraryApp.controller;

import com.Harsh.LibraryApp.service.LibManageService;
import com.Harsh.LibraryApp.model.LibManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/LibraryManage-App/")
public class LibManageController {

    @Autowired
    private LibManageService service;

    @GetMapping("libraries") // get all
    public List<LibManage> getAllLibraries(){
        return service.getAllLibraries();
    }

    @GetMapping("library/name/{name}") // get by name
    public LibManage getLibrary(@PathVariable String name){
        return service.getLibrary(name);
    }

    @PostMapping("add") // Adding new Libraries
    public String addLibrary(@RequestBody LibManage library){
        return service.addLibrary(library);
    }

    @PutMapping("update/name/{name}") // update existing Library
    public String updateLibrary(@RequestBody LibManage library, @PathVariable String name){
        return service.updateLibrary(library, name);
    }

    @DeleteMapping("delete/name/{name}") // delete Library
    public String deleteLibrary(@PathVariable String name){
        return service.deleteLibrary(name);
    }
}
