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
@Entity(name = "faculty")
public class Faculty extends AbsEntity {
    @Column( nullable = false)
    private String facultyName;
}
