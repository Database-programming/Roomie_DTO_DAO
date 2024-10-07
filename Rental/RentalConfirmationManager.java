package rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalConfirmationManager {

    private final RentalConfirmationDao rentalConfirmationDao;

    @Autowired
    public RentalConfirmationManager(RentalConfirmationDao rentalConfirmationDao) {
        this.rentalConfirmationDao = rentalConfirmationDao;
    }

    // 대여 확정 추가
    public void addRentalConfirmation(RentalConfirmationDto rentalConfirmationDto) {
        RentalConfirmation rentalConfirmation = new RentalConfirmation(rentalConfirmationDto);
        rentalConfirmationDao.insertRentalConfirmation(rentalConfirmation);
    }

    // 특정 대여 확정 조회
    public RentalConfirmationDto getRentalConfirmationById(int id) {
        return new RentalConfirmationDto(rentalConfirmationDao.selectRentalConfirmationById(id));
    }

    // 모든 대여 확정 조회
    public List<RentalConfirmationDto> getAllRentalConfirmations() {
        List<RentalConfirmation> confirmations = rentalConfirmationDao.selectAllRentalConfirmations();
        return confirmations.stream().map(RentalConfirmationDto::new).toList();
    }

    // 대여 확정 삭제
    public void deleteRentalConfirmation(int id) {
        rentalConfirmationDao.deleteRentalConfirmation(id);
    }

    // 대여 확정 수정
    public void updateRentalConfirmation(int id, RentalConfirmationDto rentalConfirmationDto) {
        RentalConfirmation rentalConfirmation = new RentalConfirmation(rentalConfirmationDto);
        rentalConfirmation.setId(id);
        rentalConfirmationDao.updateRentalConfirmation(rentalConfirmation);
    }
}
