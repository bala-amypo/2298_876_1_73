@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowStepConfig create(WorkflowStepConfig step) {
        return repository.save(step);
    }

    @Override
    public List<WorkflowStepConfig> getByTemplateId(Long templateId) {
        return repository.findByWorkflowTemplateId(templateId);
    }
}
