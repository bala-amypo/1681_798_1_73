@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository repository;

    public ApprovalActionServiceImpl(ApprovalActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApprovalAction create(ApprovalAction action) {
        return repository.save(action);
    }

    @Override
    public List<ApprovalAction> getByLevelAndAction(Integer level, String action) {
        return repository.findByLevelAndAction(level, action);
    }

    @Override
    public List<ApprovalAction> getByRequestId(Long requestId) {
        return repository.findByRequestId(requestId);
    }
}
