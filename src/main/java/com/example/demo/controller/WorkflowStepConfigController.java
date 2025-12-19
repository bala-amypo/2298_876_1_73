@RestController
@RequestMapping("/api/steps")
@Tag(name = "Workflow Step Config Controller")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(WorkflowStepConfigService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowStepConfig create(@RequestBody WorkflowStepConfig step) {
        return service.create(step);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getByTemplate(@PathVariable Long templateId) {
        return service.getByTemplateId(templateId);
    }
}
