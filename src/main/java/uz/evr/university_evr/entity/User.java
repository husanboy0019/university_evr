package uz.evr.university_evr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.evr.university_evr.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public final class User extends AbsEntity {
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
}
