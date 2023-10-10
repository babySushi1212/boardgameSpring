package webapp.dto;

import java.sql.Time;
import lombok.Data;

@Data
public class OpenHourDTO {
    private int openTimeNo;
    private byte week;
    private Time openTimeStart;
    private Time openTimeEnd;
}
