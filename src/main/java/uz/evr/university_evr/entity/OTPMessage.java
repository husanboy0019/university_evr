package uz.evr.university_evr.entity;


import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.evr.university_evr.entity.template.AbsEntity;
import uz.evr.university_evr.enums.OtpTargetType;
import uz.evr.university_evr.enums.OtpType;
import uz.evr.university_evr.enums.State;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "otp_message")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OTPMessage extends AbsEntity {

    private State state = State.New;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private User user;

//    @Column(insertable = false, updatable = false)
//    private Long user_id;

    private String messageId;
    private String message;
    private Date createdDate;
    private Date expireDate;
    private String code;
    private String uniqueParam;

    @Enumerated(EnumType.STRING)
    private OtpType type;

    @Enumerated(EnumType.STRING)
    private OtpTargetType target;

}
