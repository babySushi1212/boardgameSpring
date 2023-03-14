package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webapp.pojo.OpenHour;

@Repository
public interface OpenHourRepository extends JpaRepository<OpenHour, Integer> {
    // connection pool + similar to DAO(both support by extends Jpa repository)
    // program new DAO behavior here

//    SELECT u FROM User u WHERE u.username = :username AND u.enabled = true


    @Query(value = "SELECT OPENTIME_NO FROM OPENNING_TIME WHERE WEEK=:week", nativeQuery = true)
//    int findByUsername();
    int findByUsername(@Param("week") String week);
}
