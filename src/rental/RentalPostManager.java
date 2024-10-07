package rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.User;

import java.util.List;

@Service
public class RentalPostManager {

    private final RentalPostDAO rentalPostDAO;

    @Autowired
    public RentalPostManager(RentalPostDAO rentalPostDAO) {
        this.rentalPostDAO = rentalPostDAO;
    }

    // 대여글 생성
    public void createRentalPost(RentalPostDto rentalPostDto) {
        RentalPostDto rentalPost = new RentalPostDto(
                rentalPostDto.getId(),
                rentalPostDto.getType(),
                rentalPostDto.getTitle(),
                rentalPostDto.getRentalItem(),
                rentalPostDto.getContent(),
                rentalPostDto.getRentalPoint(),
                rentalPostDto.getRentalStartDate(),
                rentalPostDto.getRentalEndDate(),
                rentalPostDto.getRentalLocation(),
                rentalPostDto.getReturnLocation(),
                rentalPostDto.getImageUrl(),
                rentalPostDto.getStatus(),
                rentalPostDto.getWriter()
        );
        rentalPostDAO.save(rentalPost);
    }

    // 모든 대여글 조회
    public List<RentalPostDto> getAllRentalPosts() {
        List<RentalPostDto> rentalPosts = rentalPostDAO.findAll();
        return rentalPosts.stream()
                .map(this::convertToDto)
                .toList();
    }

    // 제목으로 대여글 검색
    public List<RentalPostDto> searchRentalPostsByTitle(String title) {
        List<RentalPostDto> rentalPosts = rentalPostDAO.findByTitleContaining(title);
        return rentalPosts.stream()
                .map(this::convertToDto)
                .toList();
    }

    // ID로 특정 대여글 조회
    public RentalPostDto getRentalPostById(int id) {
        RentalPostDto rentalPost = rentalPostDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rental post not found with id: " + id));
        return convertToDto(rentalPost);
    }

    // 대여글 수정
    public void updateRentalPost(int id, RentalPostDto rentalPostDto) {
        RentalPostDto rentalPost = rentalPostDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rental post not found with id: " + id));

        rentalPost.setType(rentalPostDto.getType());
        rentalPost.setTitle(rentalPostDto.getTitle());
        rentalPost.setContent(rentalPostDto.getContent());
        rentalPost.setRentalItem(rentalPostDto.getRentalItem());
        rentalPost.setRentalPoint(rentalPostDto.getRentalPoint());
        rentalPost.setRentalStartDate(rentalPostDto.getRentalStartDate());
        rentalPost.setRentalEndDate(rentalPostDto.getRentalEndDate());
        rentalPost.setRentalLocation(rentalPostDto.getRentalLocation());
        rentalPost.setReturnLocation(rentalPostDto.getReturnLocation());
        rentalPost.setImageUrl(rentalPostDto.getImageUrl());
        rentalPost.setStatus(rentalPostDto.getStatus());
        rentalPost.setWriter(rentalPostDto.getWriter());

        rentalPostDAO.save(rentalPost);
    }

    // 대여글 삭제
    public void deleteRentalPost(int id) {
        rentalPostDAO.deleteById(id);
    }

    // Entity를 DTO로 변환
    private RentalPostDto convertToDto(RentalPostDto rentalPost) {
        return new RentalPostDto(
                rentalPost.getId(),
                rentalPost.getType(),
                rentalPost.getTitle(),
                rentalPost.getRentalItem(),
                rentalPost.getContent(),
                rentalPost.getRentalPoint(),
                rentalPost.getRentalStartDate(),
                rentalPost.getRentalEndDate(),
                rentalPost.getRentalLocation(),
                rentalPost.getReturnLocation(),
                rentalPost.getImageUrl(),
                rentalPost.getStatus(),
                rentalPost.getWriter()
        );
    }
}
