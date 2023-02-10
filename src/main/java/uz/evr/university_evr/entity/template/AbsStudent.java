package uz.evr.university_evr.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AbsStudent extends AbsEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Column(name = "passport_series", nullable = false)
    private String passportSeries;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "added_phone_number", nullable = false)
    private String addedPhoneNumber;
}
