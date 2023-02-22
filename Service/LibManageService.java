package com.Harsh.LibraryApp.service;

import com.Harsh.LibraryApp.model.LibManage;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibManageService {
    private static List<LibManage> libraries = new ArrayList<>();
    static int autoNum = 0;
    static{
        libraries.add(new LibManage("The Bookworm Library", "Radhika Complex, Gwalior", ++autoNum, 88));
        libraries.add(new LibManage("Study Circle Library", "Tansen Road,Gwalior", ++autoNum, 123));
        libraries.add(new LibManage("National Library Of Russia", "Russia", ++autoNum, 200));
        libraries.add(new LibManage("Delhi Public Library", "Delhi", ++autoNum, 89));
        libraries.add(new LibManage("The National Library Of India", "Kolkata", ++autoNum, 1000));
    }

    public List<LibManage> getAllLibraries() {
        return libraries;
    }

    public LibManage getLibrary(String name) {
        for (LibManage library: libraries){
            if(library.getName().equals(name)) return library;
        }
        return null;
    }

    public String addLibrary(LibManage library) {
        libraries.add(new LibManage(library.getName(),
                library.getAddress(),
                ++autoNum,
                library.getFaculties()));
        return library.getName() + " Added Successfully!";
    }

    public String updateLibrary(LibManage library, String name) {
        LibManage oldLibrary = this.getLibrary(name);
        if(oldLibrary != null) {
            if (library.getName() != null) oldLibrary.setName(library.getName());
            if (library.getFaculties() != 0) oldLibrary.setFaculties(library.getFaculties());
            if (library.getAddress() != null) oldLibrary.setAddress(library.getAddress());
            if (library.getNumber() != 0) oldLibrary.setNumber(library.getNumber());
            return "Library with name " + name + " Updated Successfully";
        }
        else return "Library not found to Update, Add library first";
    }

    public String deleteLibrary(String name) {
        LibManage library = this.getLibrary(name);
        if(library != null) {
            libraries.remove(library.getNumber()-1);
            return "Library with name " + name + " Deleted Successfully";
        }
        else return "Library not found to Delete, Add library first";
    }
}
