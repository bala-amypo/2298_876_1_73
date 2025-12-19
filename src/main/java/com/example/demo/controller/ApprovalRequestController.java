@RestController
@RequestMapping("/api/requests")
@Tag(name = "Approval Request Controller")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAll();
    }
}
