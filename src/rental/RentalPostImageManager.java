package rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalPostImageManager {

    private final RentalPostImageDao rentalPostImageDao;

    @Autowired
    public RentalPostImageManager(RentalPostImageDao rentalPostImageDao) {
        this.rentalPostImageDao = rentalPostImageDao;
    }

    // 대여글 이미지 등록
    public void addRentalPostImage(RentalPostImageDto rentalPostImageDto) {
        RentalPostImage rentalPostImage = new RentalPostImage(rentalPostImageDto);
        rentalPostImageDao.insertRentalPostImage(rentalPostImage);
    }

    // 특정 이미지 조회
    public RentalPostImageDto getRentalPostImageById(int id) {
        return new RentalPostImageDto(rentalPostImageDao.selectRentalPostImageById(id));
    }

    // 특정 대여글의 모든 이미지 조회
    public List<RentalPostImageDto> getRentalPostImagesByPostId(int postId) {
        List<RentalPostImage> images = rentalPostImageDao.selectRentalPostImagesByPostId(postId);
        return images.stream().map(RentalPostImageDto::new).toList();
    }

    // 대여글 이미지 삭제
    public void deleteRentalPostImage(int id) {
        rentalPostImageDao.deleteRentalPostImage(id);
    }

    // 대여글 이미지 수정
    public void updateRentalPostImage(int id, RentalPostImageDto rentalPostImageDto) {
        RentalPostImage rentalPostImage = new RentalPostImage(rentalPostImageDto);
        rentalPostImage.setId(id);
        rentalPostImageDao.updateRentalPostImage(rentalPostImage);
    }
}
