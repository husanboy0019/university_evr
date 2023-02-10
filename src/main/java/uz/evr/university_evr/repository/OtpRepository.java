package uz.evr.university_evr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.evr.university_evr.entity.OTPMessage;
import uz.evr.university_evr.entity.User;

import java.util.Date;

public interface OtpRepository extends JpaRepository<OTPMessage, Long> {


    @Query(value = "select t.created_date from OTP_message t where t.state <> 2 and t.user = ?1 ", nativeQuery = true)
    Date lastSentCode(User user);

    @Query(value = "select count(t) from OTP_message t where t.state <> 2 and t.user = ?1 and t.created_date >= ?2 ", nativeQuery = true)
    Long countByUser(User user, Date dateTime);

    @Query(value = "select t from OTP_message t left join User u on t.user_id = u.id " +
            "where (u.username = ?1 or u.phone_number =?1) and t.state <> 2 order by t.id desc ", nativeQuery = true)
    OTPMessage findByUsername(String uniqueParam);
}
