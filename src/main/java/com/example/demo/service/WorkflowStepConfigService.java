public interface WorkflowStepConfigService {
    WorkflowStepConfig create(WorkflowStepConfig step);
    List<WorkflowStepConfig> getByTemplateId(Long templateId);
}
