@RestController
@RequestMapping("/api/templates")
@Tag(name = "Workflow Template Controller")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return service.create(template);
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public WorkflowTemplate update(@PathVariable Long id,
                                   @RequestBody WorkflowTemplate template) {
        return service.update(id, template);
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return service.getAll();
    }
}
