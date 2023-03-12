package spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OPENNING_TIME")
public class OpenHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPENTIME_NO")
    private int openTimeNo;

    @Column(name = "WEEK")
    private byte week;

    @Column(name = "OPENTIME_START")
    private Time openTimeStart;

    @Column(name = "OPENTIME_END")
    private Time openTimeEnd;
}
