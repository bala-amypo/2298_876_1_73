public interface WorkflowTemplateService {
    WorkflowTemplate create(WorkflowTemplate template);
    WorkflowTemplate getById(Long id);
    WorkflowTemplate update(Long id, WorkflowTemplate template);
    List<WorkflowTemplate> getAll();
}
