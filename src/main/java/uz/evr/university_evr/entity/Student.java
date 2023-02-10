package uz.evr.university_evr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.evr.university_evr.entity.template.AbsStudent;
import uz.evr.university_evr.enums.LanguageEnum;
import uz.evr.university_evr.enums.StudyTypeEnum;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "students")
public class Student extends AbsStudent {

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @Enumerated(EnumType.STRING)
    private StudyTypeEnum studyType;

    @ManyToOne
    private Faculty faculty;
}
