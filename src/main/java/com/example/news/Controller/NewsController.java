package com.example.news.Controller;

import com.example.news.DataAccess.Entry;
import com.example.news.Repositories.EntryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {
    private final  EntryRepository repository;

    public NewsController(EntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getNews(Model model){
        model.addAttribute("entries", repository.findAll());
        return "homepage";
    }

    @GetMapping("/add")
    public String addNewEntry(Model model) {
        Entry entry = new Entry();
        model.addAttribute("entry", entry);
        return "newentry";
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute("entry") Entry entry, BindingResult result) {
        if(result.hasErrors()){
            if(entry.getId() == null){
                return "newentry";
            }
            return "updateentry";
        }
        repository.save(entry);
        return "redirect:/";
    }

    @PostMapping("/confirmdelete")
    public String deleteEntry(@ModelAttribute("entry") Entry entry) {
        repository.delete(entry);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateEntry(@PathVariable(value = "id") long id, Model model) {
        if(repository.findById(id).isPresent()) {
            Entry entry = repository.findById(id).get();
            model.addAttribute("entry", entry);
            return "updateentry";
        }
        return "homepage";
    }
    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable(value = "id") long id, Model model) {
        if(repository.findById(id).isPresent()) {
            Entry entry = repository.findById(id).get();
            model.addAttribute("entry", entry);
            return "deleteentry";
        }
        return "homepage";


    }
}
