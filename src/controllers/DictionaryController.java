package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("/home")
    public String translate()
    {
        return "index";
    }

    @PostMapping("/trans")
    public String convert(@RequestParam String word, Model model)
    {
        Map<String, String> dict = new HashMap<>();

        dict.put("hello", "chao xìn");
        dict.put("book", "Cuốn sách");
        dict.put("come", "Đến");
        dict.put("go", "Sủa");

        String result = dict.get(word);
        if (result != null)
        {
            model.addAttribute("word", word);
            model.addAttribute("result", result);
        }
        else
        {
            model.addAttribute("result", "Error");
        }

        return "result";
    }

}
