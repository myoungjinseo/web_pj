package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import net.skhu.mapper.StudentMapper;

@Controller
public class StudentController {
	@Autowired
	StudentMapper studentMapper;

	@RequestMapping("student/list")
	public String list(Model model) {
		model.addAttribute("students", studentMapper.findAll());
		return "student/list";
	}

	@RequestMapping("student/list1")
	public String list1(Model model, String srchText) {
		if (srchText == null)
			srchText = "";
		model.addAttribute("students", studentMapper.findByName(srchText +"%" ));
		model.addAttribute("srchText", srchText);
		return "student/list1";
	}
}
