package sideproject.practice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "emotion")
public class Emotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reaction")
    private String reaction;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    public Emotion(String reaction, Diary diary) {
        this.reaction = reaction;
        this.diary = diary;
    }
}
