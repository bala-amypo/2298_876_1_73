public interface WorkflowStepConfigRepository
        extends JpaRepository<WorkflowStepConfig, Long> {

    List<WorkflowStepConfig> findByWorkflowTemplateId(Long templateId);
}
