package rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalPostImage")
public class RentalPostImageController {

    private final RentalPostImageManager rentalPostImageManager;

    @Autowired
    public RentalPostImageController(RentalPostImageManager rentalPostImageManager) {
        this.rentalPostImageManager = rentalPostImageManager;
    }

    // POST /rentalPostImage: 대여글 이미지 등록
    @PostMapping
    public ResponseEntity<String> createRentalPostImage(@RequestBody RentalPostImageDto rentalPostImageDto) {
        rentalPostImageManager.addRentalPostImage(rentalPostImageDto);
        return ResponseEntity.ok("Rental post image added successfully!");
    }

    // GET /rentalPostImage/{id}: 특정 이미지 조회
    @GetMapping("/{id}")
    public ResponseEntity<RentalPostImageDto> getRentalPostImageById(@PathVariable int id) {
        RentalPostImageDto rentalPostImage = rentalPostImageManager.getRentalPostImageById(id);
        return ResponseEntity.ok(rentalPostImage);
    }

    // GET /rentalPostImage/post/{postId}: 특정 대여글의 모든 이미지 조회
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<RentalPostImageDto>> getRentalPostImagesByPostId(@PathVariable int postId) {
        List<RentalPostImageDto> rentalPostImages = rentalPostImageManager.getRentalPostImagesByPostId(postId);
        return ResponseEntity.ok(rentalPostImages);
    }

    // DELETE /rentalPostImage/{id}: 대여글 이미지 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentalPostImage(@PathVariable int id) {
        rentalPostImageManager.deleteRentalPostImage(id);
        return ResponseEntity.ok("Rental post image deleted successfully!");
    }

    // PUT /rentalPostImage/{id}: 대여글 이미지 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRentalPostImage(@PathVariable int id, @RequestBody RentalPostImageDto rentalPostImageDto) {
        rentalPostImageManager.updateRentalPostImage(id, rentalPostImageDto);
        return ResponseEntity.ok("Rental post image updated successfully!");
    }
}
