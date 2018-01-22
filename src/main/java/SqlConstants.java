public class SqlConstants {
    public static  String SELECT_ALL_FROM_ACTOR = "SELECT * FROM actor WHERE actor_id BETWEEN 20 AND 60;";
    public static  String SELECT_LAST_N_ACTOR = "SELECT * FROM actor ORDER BY actor_id DESC LIMIT ?";
    public static  String SELECT_JOIn = "SELECT t3.title,t1.first_name,t1.last_name\n" +
            "FROM actor t1\n" +
            "INNER JOIN film_actor t2\n" +
            "ON t1.actor_id = t2.actor_id\n" +
            "INNER JOIN film t3\n" +
            "ON t2.film_id = t3.film_id\n" +
            "WHERE t1.actor_id>?";
}

// film actor join, film.title,actor.first_name,actor.last_name és id >0