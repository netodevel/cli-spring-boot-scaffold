package br.com.example.controller;

import java.util.List;
import java.util.Optional;

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
import br.com.example.model.UserModel;
import br.com.example.service.UserModelService;

@Controller
@RequestMapping("/usermodels")
public class UserModelController {

	private static final String MSG_SUCESS_INSERT = "UserModel inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "UserModel successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted UserModel successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private UserModelService usermodelService;

	@GetMapping
	public String index(Model model) {
		List<UserModel> all = usermodelService.findAll();
		model.addAttribute("listUserModel", all);
		return "usermodel/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<UserModel> usermodel = usermodelService.findById(id);
			
			if (usermodel.isPresent())
				model.addAttribute("usermodel", usermodel.get());
		}
		return "usermodel/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute UserModel entity) {
		model.addAttribute("usermodel", entity);
		return "usermodel/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute UserModel entity, BindingResult result, RedirectAttributes redirectAttributes) {
		UserModel usermodel = null;
		try {
			usermodel = usermodelService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/usermodels/" + usermodel.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<UserModel> entity = usermodelService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("usermodel", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "usermodel/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute UserModel entity, BindingResult result, RedirectAttributes redirectAttributes) {
		UserModel usermodel = null;
		try {
			usermodel = usermodelService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/usermodels/" + usermodel.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<UserModel> entity = usermodelService.findById(id);
				
				if (entity.isPresent()) {    
					usermodelService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/usermodels/index";
	}

}
