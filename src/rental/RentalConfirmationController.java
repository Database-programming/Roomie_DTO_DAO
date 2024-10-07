package rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalConfirmation")
public class RentalConfirmationController {

    private final RentalConfirmationManager rentalConfirmationManager;

    @Autowired
    public RentalConfirmationController(RentalConfirmationManager rentalConfirmationManager) {
        this.rentalConfirmationManager = rentalConfirmationManager;
    }

    // POST /rentalConfirmation: 대여 확정 요청
    @PostMapping
    public ResponseEntity<String> createRentalConfirmation(@RequestBody RentalConfirmationDto rentalConfirmationDto) {
        rentalConfirmationManager.addRentalConfirmation(rentalConfirmationDto);
        return ResponseEntity.ok("Rental confirmation added successfully!");
    }

    // GET /rentalConfirmation/{id}: 특정 대여 확정 조회
    @GetMapping("/{id}")
    public ResponseEntity<RentalConfirmationDto> getRentalConfirmationById(@PathVariable int id) {
        RentalConfirmationDto rentalConfirmation = rentalConfirmationManager.getRentalConfirmationById(id);
        return ResponseEntity.ok(rentalConfirmation);
    }

    // GET /rentalConfirmation: 모든 대여 확정 조회
    @GetMapping
    public ResponseEntity<List<RentalConfirmationDto>> getAllRentalConfirmations() {
        List<RentalConfirmationDto> rentalConfirmations = rentalConfirmationManager.getAllRentalConfirmations();
        return ResponseEntity.ok(rentalConfirmations);
    }

    // DELETE /rentalConfirmation/{id}: 대여 확정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentalConfirmation(@PathVariable int id) {
        rentalConfirmationManager.deleteRentalConfirmation(id);
        return ResponseEntity.ok("Rental confirmation deleted successfully!");
    }

    // PUT /rentalConfirmation/{id}: 대여 확정 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRentalConfirmation(@PathVariable int id, @RequestBody RentalConfirmationDto rentalConfirmationDto) {
        rentalConfirmationManager.updateRentalConfirmation(id, rentalConfirmationDto);
        return ResponseEntity.ok("Rental confirmation updated successfully!");
    }
}
