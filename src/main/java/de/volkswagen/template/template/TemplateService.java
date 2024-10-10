package de.volkswagen.template.template;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

	private final TemplateRepository templateRepository;

	public TemplateService(TemplateRepository templateRepository) {
		this.templateRepository = templateRepository;
	}

	public List<Template> getAll() {
		return this.templateRepository.findAll();
	}

	public Template getById(String id) {
		return this.templateRepository.findById(this.parseIdToLong(id)).orElseThrow(() -> new EntityNotFoundException(
				"No Entity with the ID: " + id + " found."));
	}

	public long parseIdToLong(String id) {
		long parsed = -1;
		try {
			parsed = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Provided id: " + id + " does not have the right format.");
		}
		return parsed;
	}

	public Template create(String id, Template template) {
		if (this.parseIdToLong(id) != template.getId()) {
			throw new EntityNotFoundException("Provided IDs dont match:" + id + " , " + template.getId());
		}
		if (this.getById(id) != null) {
			throw new EntityExistsException("Entity with id: " + id + " already exists.");
		}
		return this.templateRepository.save(template);
	}

	public Template update(String id, Template template) {
		if (this.parseIdToLong(id) != template.getId()) {
			throw new EntityNotFoundException("Provided IDs dont match:" + id + " , " + template.getId());
		}
		try {
			this.getById(id);
		} catch (EntityNotFoundException ex) {
			throw new EntityNotFoundException("Entity with the ID: " + id + " doesn't exist.");
		}
		this.delete(id);
		return this.templateRepository.save(template);
	}

	public void delete(String id) {
		this.templateRepository.deleteById(this.parseIdToLong(id));
	}
}