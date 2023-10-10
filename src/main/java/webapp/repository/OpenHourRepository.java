package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webapp.pojo.OpenHour;

@Repository
public interface OpenHourRepository extends JpaRepository<OpenHour, Integer> {
    // connection pool + similar to DAO(both support by extends Jpa repository)

    @Query(value = "SELECT OPENTIME_NO FROM OPENNING_TIME WHERE WEEK=:week", nativeQuery = true)
    int findByWeek(@Param("week") String week);

//    @Transactional
//    @Modifying
//    @Query("UPDATE OpenHour o SET o.openTimeStart =:start, o.openTimeEnd =: end WHERE o.week =: week")
//    Integer updateTime(@Param("openTimeStart") Integer week,
//                       @Param("openTimeStart") String start,
//                       @Param("openTimeEnd") String end);

}
