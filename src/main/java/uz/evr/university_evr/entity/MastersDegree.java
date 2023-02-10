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
@Entity(name = "masters")
public class MastersDegree extends AbsStudent {

    @Column(name = "language", nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @Column(name = "study_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyTypeEnum studyType;

    @ManyToOne
    private Faculty faculty;
}
