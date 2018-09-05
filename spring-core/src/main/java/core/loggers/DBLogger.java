package core.loggers;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBLogger implements EventLogger {

    private JdbcTemplate jdbcTemplate;

    public DBLogger(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void logEvent(Event event) {
        String SQL = "INSERT INTO logevents(id,message,event_date) VALUES(?,?,?)";
        jdbcTemplate.update(SQL,event.getId(),event.getMsg(),event.getDate());
        System.out.println("Event successful added to DB!");
    }
}
