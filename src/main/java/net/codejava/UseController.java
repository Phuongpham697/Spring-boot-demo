package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UseController
{
    @Autowired
    private UseService service;

    @RequestMapping("/")
    public String viewHomePage(Model model)
    {
        return viewPage(model, 1);
    }

    @RequestMapping("/search")
    public String viewSearch(Model model, @RequestParam("keyword") String keyword) {
        List<Use> listUses = service.listSearch(keyword);
        model.addAttribute("listUses", listUses);
        model.addAttribute("keyword", keyword);

        return "index1";
    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage(
            Model model,
            @PathVariable(name = "pageNum") int pageNum)
    {
        Page<Use> page = service.listAll(pageNum);

        List<Use> listUses = page.getContent();
        model.addAttribute("listUses", listUses);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        return "index1";
    }

    @RequestMapping("/new")
    public String showNewUsePage(Model model)
    {
        Use use = new Use();
        model.addAttribute("use", use);

        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUse(@ModelAttribute("use") Use use)
    {
        service.save(use);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUsePage(@PathVariable(name = "id") int id)
    {
        ModelAndView mav = new ModelAndView("edit_user");
        Use use = service.get(id);
        mav.addObject("use", use);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUse(@PathVariable(name = "id") int id)
    {
        service.delete(id);
        return "redirect:/";
    }
}
