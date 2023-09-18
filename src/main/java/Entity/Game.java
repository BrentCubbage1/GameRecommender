package Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



}
