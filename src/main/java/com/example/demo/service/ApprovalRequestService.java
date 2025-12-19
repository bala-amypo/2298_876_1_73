public interface ApprovalRequestService {

    ApprovalRequest createRequest(ApprovalRequest request);

    List<ApprovalRequest> getAllRequests();

    ApprovalRequest getRequestById(Long id);

    ApprovalRequest updateRequest(Long id, ApprovalRequest request);

    void deleteRequest(Long id);
}
