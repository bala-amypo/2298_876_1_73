@RestController
@RequestMapping("/api/requests")
@CrossOrigin("*")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService approvalRequestService;

    // CREATE
    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return approvalRequestService.createRequest(request);
    }

    // READ ALL ✅ (THIS FIXES Cannot GET)
    @GetMapping
    public List<ApprovalRequest> getAll() {
        return approvalRequestService.getAllRequests();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ApprovalRequest getById(@PathVariable Long id) {
        return approvalRequestService.getRequestById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApprovalRequest update(
            @PathVariable Long id,
            @RequestBody ApprovalRequest request) {
        return approvalRequestService.updateRequest(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        approvalRequestService.deleteRequest(id);
    }
}
