
package rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-posts")
public class RentalPostController {

    private final RentalPostManager rentalPostManager;

    @Autowired
    public RentalPostController(RentalPostManager rentalPostManager) {
        this.rentalPostManager = rentalPostManager;
    }

    // POST /rental-posts : 대여글 등록 요청
    @PostMapping
    public ResponseEntity<String> createRentalPost(@RequestBody RentalPostDto rentalPostDto) {
        rentalPostManager.createRentalPost(rentalPostDto);
        return ResponseEntity.ok("Rental post created successfully!");
    }

    // GET /rental-posts : 모든 대여글 조회
    @GetMapping
    public ResponseEntity<List<RentalPostDto>> getAllRentalPosts() {
        List<RentalPostDto> rentalPosts = rentalPostManager.getAllRentalPosts();
        return ResponseEntity.ok(rentalPosts);
    }

    // GET /rental-posts?title=검색어 : 제목으로 검색
    @GetMapping(params = "title")
    public ResponseEntity<List<RentalPostDto>> searchRentalPostsByTitle(@RequestParam("title") String title) {
        List<RentalPostDto> rentalPosts = rentalPostManager.searchRentalPostsByTitle(title);
        return ResponseEntity.ok(rentalPosts);
    }

    // GET /rental-posts/{id} : 특정 대여글 조회
    @GetMapping("/{id}")
    public ResponseEntity<RentalPostDto> getRentalPostById(@PathVariable int id) {
        RentalPostDto rentalPost = rentalPostManager.getRentalPostById(id);
        return ResponseEntity.ok(rentalPost);
    }

    // PUT /rental-posts/{id} : 대여글 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRentalPost(@PathVariable int id, @RequestBody RentalPostDto rentalPostDto) {
        rentalPostManager.updateRentalPost(id, rentalPostDto);
        return ResponseEntity.ok("Rental post updated successfully!");
    }

    // DELETE /rental-posts/{id} : 대여글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentalPost(@PathVariable int id) {
        rentalPostManager.deleteRentalPost(id);
        return ResponseEntity.ok("Rental post deleted successfully!");
    }
}
