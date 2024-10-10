package de.volkswagen.template.template;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class
TemplateController {

	private final TemplateService templateService;

	public TemplateController(TemplateService templateService) {
		this.templateService = templateService;
	}

	@GetMapping
	public List<Template> getAll() {
		return this.templateService.getAll();
	}

	@GetMapping("/{id}")
	public Template getById(@PathVariable String id) {
		return this.templateService.getById(id);
	}

	@PostMapping("/{id}")
	public Template create(@PathVariable String id, @RequestBody Template template) {
		return this.templateService.create(id, template);
	}

	@PutMapping("/{id}")
	public Template update(@PathVariable String id, @RequestBody Template template) {
		return this.templateService.update(id, template);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		return this.templateService.delete(id);
	}
}