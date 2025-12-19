@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository repository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApprovalRequest create(ApprovalRequest request) {
        return repository.save(request);
    }

    @Override
    public List<ApprovalRequest> getAll() {
        return repository.findAll();
    }
}
