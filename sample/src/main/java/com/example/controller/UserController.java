package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private static final String MSG_SUCESS_INSERT = "User inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "User successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted User successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private UserService userService;

	@GetMapping
	public String index(Model model) {
		List<User> all = userService.findAll();
		model.addAttribute("listUser", all);
		return "user/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			User user = userService.findOne(id);
			model.addAttribute("user", user);
		}
		return "user/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute User entity) {
		model.addAttribute("user", entity);
		return "user/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute User entity, BindingResult result, RedirectAttributes redirectAttributes) {
		User user = null;
		try {
			user = userService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/users/" + user.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				User entity = userService.findOne(id);
				model.addAttribute("user", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "user/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute User entity, BindingResult result, RedirectAttributes redirectAttributes) {
		User user = null;
		try {
			user = userService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/users/" + user.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				User entity = userService.findOne(id);
				userService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/users/index";
	}

}
